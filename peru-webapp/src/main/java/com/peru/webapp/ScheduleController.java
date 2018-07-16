package com.peru.webapp;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.APIRequest;
import com.facebook.ads.sdk.APIResponse;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.AdsActionStats;
import com.facebook.ads.sdk.AdsInsights;
import com.facebook.ads.sdk.Campaign;
import com.google.common.collect.Maps;
import com.peru.dal.ReportDailyDO;
import com.peru.dal.ReportDailyDOCriteria;
import com.peru.dal.ReportDailyDOMapper;
import com.peru.dal.UserAccountDO;
import com.peru.dal.UserAccountDOCriteria;
import com.peru.dal.UserAccountDOMapper;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by roger.lu on 2018/7/10.
 */
@Controller
public class ScheduleController {

  @Autowired
  private UserAccountDOMapper userAccountDOMapper;

  @Autowired
  private ReportDailyDOMapper reportDailyDOMapper;

  private static final Logger logger = LoggerFactory.getLogger(ScheduleController.class);

  @RequestMapping(value = "/schedule/daily", method = RequestMethod.GET)
  @ResponseBody
  public String doGet(String sinceDay, String utilDay) throws APIException, ParseException, InterruptedException {

    Calendar utilCalendar = Calendar.getInstance();
    Calendar sinceCalendar = Calendar.getInstance();
    sinceCalendar.add(Calendar.DAY_OF_MONTH, -1);

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    if (Strings.isNotBlank(utilDay) && Strings.isNotBlank(sinceDay)) {
      Date sinceDate = df.parse(sinceDay);
      Date utilDate = df.parse(utilDay);
      sinceCalendar.setTime(sinceDate);
      utilCalendar.setTime(utilDate);
    }

    UserAccountDOCriteria userAccountDOCriteria = new UserAccountDOCriteria();
    UserAccountDOCriteria.Criteria criteria = userAccountDOCriteria.createCriteria();
    criteria.andAccessTokenIsNotNull();

    List<UserAccountDO> userAccountDOs = userAccountDOMapper.selectByExample(userAccountDOCriteria);
    for (UserAccountDO userAccountDO : userAccountDOs) {

      logger.info("to import facebook userID {}.", userAccountDO.getFacebookId());

      APIContext context = new APIContext(userAccountDO.getAccessToken());
      APIRequest<AdAccount> adAccountsRequest = new APIRequest<AdAccount>(context,
        userAccountDO.getFacebookId(), "/adaccounts", "GET", AdAccount.getParser());
      APIResponse response = adAccountsRequest.execute();
      APINodeList<AdAccount> adAccounts = (APINodeList<AdAccount>) response;

      for (AdAccount adAccount : adAccounts) {

        logger.info("to import adAccount {}.", adAccount.getId());

        APIRequest<AdSet> adsetsRequest = new APIRequest<AdSet>(context, "act_" + adAccount.getId(), "/adsets", "GET", AdSet.getParser());
        HashMap<String, Object> adsetsParams = Maps.newHashMap();
        adsetsParams.put("fields", "daily_budget");
        adsetsParams.put("effective_status", "[\"ACTIVE\", \"PENDING_REVIEW\"]");
        adsetsParams.put("limit", "1000");
        APIResponse adsetsResponse = adsetsRequest.execute(adsetsParams);
        APINodeList<AdSet> adsets = (APINodeList<AdSet>) adsetsResponse;

        for (AdSet adSet : adsets) {

          logger.info("to import adSet {}.", adSet.getId());

          Calendar inst = Calendar.getInstance();
          inst.setTime(sinceCalendar.getTime());


          while (inst.before(utilCalendar)) {

            logger.info("to import date {}.", inst.getTime());

            APIRequest<AdsInsights> insightsRequest = new APIRequest<>(context, adSet.getId(), "/insights", "GET", AdsInsights.getParser());
            HashMap<String, Object> params = Maps.newHashMap();
            params.put("fields", "impressions,unique_actions,frequency,reach,spend,actions,action_values");

            String sinceTime = df.format(inst.getTime());
            inst.add(Calendar.DAY_OF_MONTH, 1);
            String utilTime = df.format(inst.getTime());

            params.put("time_range", "{\"since\":\"" + sinceTime + "\",\"until\":\"" + utilTime + "\"}");
            params.put("limit", "1000");

            String fieldDailyBudget = adSet.getFieldDailyBudget();
            APIResponse insightsResponse = insightsRequest.execute(params);

            if (null != insightsResponse) {
              APINodeList<AdsInsights> insights = (APINodeList<AdsInsights>) insightsResponse;

//              while (!insights.isEmpty()) {
                for (AdsInsights adsInsights : insights) {
                  logger.info("to import insight {}.", adsInsights);

                  ReportDailyDO reportDailyDO = new ReportDailyDO();
                  reportDailyDO.setAdsetId(adSet.getId());
                  if (null != fieldDailyBudget) {
                    BigDecimal budget = new BigDecimal(Integer.valueOf(fieldDailyBudget) / 100);
                    budget.setScale(2);
                    reportDailyDO.setBudget(budget);
                  }

                  List<AdsActionStats> fieldUniqueActions = adsInsights.getFieldUniqueActions();
                  if (null != fieldUniqueActions) {
                    for (AdsActionStats stat : fieldUniqueActions) {
                      if (stat.getFieldActionType().equals("link_click")) {
                        reportDailyDO.setClicks(Integer.valueOf(stat.getFieldValue()));
                      }
                    }
                  }

                  reportDailyDO.setDate(Integer.valueOf(sinceTime.replaceAll("-", "")));
                  reportDailyDO.setFacebookId(userAccountDO.getFacebookId());
                  reportDailyDO.setImpressions(Integer.valueOf(adsInsights.getFieldImpressions()));
                  reportDailyDO.setFrequency(Float.valueOf(adsInsights.getFieldFrequency()));
                  reportDailyDO.setReachs(Integer.valueOf(adsInsights.getFieldReach()));

                  List<AdsActionStats> actionsStats = adsInsights.getFieldActions();
                  if (null != actionsStats) {
                    for (AdsActionStats stat : actionsStats) {
                      if (stat.getFieldActionType().equals("offsite_conversion.fb_pixel_purchase")) {
                        reportDailyDO.setPurchases(Integer.valueOf(stat.getFieldValue()));
                      }
                    }
                  }

                  if (null == reportDailyDO.getPurchases()) {
                    reportDailyDO.setPurchases(0);
                  }

                  BigDecimal gmv = null;
                  BigDecimal generalCost = null;
                  BigDecimal vendorCost = null;
                  List<AdsActionStats> fieldActionValues = adsInsights.getFieldActionValues();
                  if (null != fieldActionValues) {
                    for (AdsActionStats stat : fieldActionValues) {
                      if (stat.getFieldActionType().equals("offsite_conversion.fb_pixel_purchase")) {
                        gmv = new BigDecimal(stat.getFieldValue());
                        gmv.setScale(2);
                        reportDailyDO.setGmv(gmv);
                        generalCost = gmv.multiply(new BigDecimal(0.1));
                        generalCost = generalCost.setScale(2, BigDecimal.ROUND_DOWN);
                        reportDailyDO.setCostGeneral(generalCost);

                        vendorCost = gmv.multiply(new BigDecimal(0.47));
                        vendorCost = vendorCost.setScale(2, BigDecimal.ROUND_DOWN);
                        reportDailyDO.setCostPurchasing(vendorCost);

                      }
                    }
                  }

                  if (null == reportDailyDO.getGmv()) {
                    reportDailyDO.setGmv(new BigDecimal(0));
                    reportDailyDO.setCostGeneral(new BigDecimal(0));
                    reportDailyDO.setCostPurchasing(new BigDecimal(0));
                  }

                  BigDecimal spend = null;
                  if (null != adsInsights.getFieldSpend()) {
                    spend = new BigDecimal(adsInsights.getFieldSpend());
                    spend.setScale(2);
                    reportDailyDO.setSpend(spend);
                  }

                  reportDailyDO.setUpdateTime(new Date());

                  ReportDailyDOCriteria reportDailyDOCriteria = new ReportDailyDOCriteria();
                  ReportDailyDOCriteria.Criteria reportCriteria = reportDailyDOCriteria.createCriteria();
                  reportCriteria.andDateEqualTo(Integer.valueOf(sinceTime.replaceAll("-", "")));
                  reportCriteria.andFacebookIdEqualTo(userAccountDO.getFacebookId());
                  reportCriteria.andAdsetIdEqualTo(adSet.getId());
                  List<ReportDailyDO> reportDailyDOs = reportDailyDOMapper.selectByExample(reportDailyDOCriteria);
                  if (null == reportDailyDO || reportDailyDOs.isEmpty()) {
                    reportDailyDOMapper.insert(reportDailyDO);
                  }

                }

//                Thread.sleep(1000);
//                insights = insights.nextPage(1000);

//              }

            }


          }
        }
      }

    }

    return "success";

  }

  public static void main(String[] args) throws APIException {

    Calendar instance = Calendar.getInstance();

    instance.add(Calendar.DAY_OF_MONTH, -16);

    System.out.println(instance.getTime());

//    String a = "1.23";
//    BigDecimal budget = new BigDecimal(a);
//    budget.setScale(2);
//
//    BigDecimal multiply = budget.multiply(new BigDecimal(0.1));
//    multiply = multiply.setScale(2, BigDecimal.ROUND_UP);
//
//    System.out.println(budget);
//    System.out.println(multiply);


//    APIContext context = new APIContext("EAAFzrZCeZBHoIBAJ2ZCpuZBY20voFvV9nXrhX1IDKuqdqNfA0hcPj0nEjf6cfAclYmcYhgVTTD8V0wGXgMgUb6kxgRZCoYccCglEbljI29Hahhhw8SEZAdXHFPnieyBRzMG9kbn5EihxRo3ptVZBHZCyNMWW8LhJCvGrpfO2Gwy28bTSlwqdAclV");
//    APIRequest<AdAccount> adAccountsRequest = new APIRequest<AdAccount>(context,
//      "212380059411381", "/adaccounts", "GET", AdAccount.getParser());
//    APIResponse response = adAccountsRequest.execute();
//    APINodeList<AdAccount> adAccounts = (APINodeList<AdAccount>) response;
//    for (AdAccount adAccount : adAccounts) {
//      System.out.println(adAccount);
//
//      APIRequest<AdSet> adsetsRequest = new APIRequest<AdSet>(context, "act_" + adAccount.getId(), "/adsets", "GET", AdSet.getParser());
//      HashMap<String, Object> adsetsParams = Maps.newHashMap();
//      adsetsParams.put("fields", "fields=name,daily_budget");
//      APIResponse adsetsResponse = adsetsRequest.execute(adsetsParams);
//      APINodeList<AdSet> adsets = (APINodeList<AdSet>) adsetsResponse;
//      for (AdSet adSet : adsets) {
//
//        System.out.println(adSet.getId());
//
//        APIRequest<AdsInsights> insightsRequest = new APIRequest<>(context, adSet.getId(), "/insights", "GET", AdsInsights.getParser());
//        HashMap<String, Object> params = Maps.newHashMap();
//        params.put("fields", "impressions,clicks,frequency,reach,spend,total_actions,total_action_value");
//        params.put("time_range", "{\"since\":\"2018-03-01\",\"until\":\"2018-04-01\"}");
//        String fieldDailyBudget = adSet.getFieldDailyBudget();
//        System.out.println(fieldDailyBudget);
//
//        APIResponse insightsResponse = insightsRequest.execute(params);
//        System.out.println(insightsResponse);
//
//
//      }
//    }

  }

}
