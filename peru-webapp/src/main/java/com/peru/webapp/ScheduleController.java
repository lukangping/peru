package com.peru.webapp;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.APIRequest;
import com.facebook.ads.sdk.APIResponse;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.AdsInsights;
import com.facebook.ads.sdk.Campaign;
import com.google.common.collect.Maps;
import com.peru.dal.ReportDailyDO;
import com.peru.dal.ReportDailyDOMapper;
import com.peru.dal.UserAccountDO;
import com.peru.dal.UserAccountDOCriteria;
import com.peru.dal.UserAccountDOMapper;
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
  public String doGet(String sinceDay, String utilDay) throws APIException, ParseException {

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date sinceDate = df.parse(sinceDay);
    Date utilDate = df.parse(utilDay);

    Calendar sinceCalendar = Calendar.getInstance();
    sinceCalendar.setTime(sinceDate);

    Calendar utilCalendar = Calendar.getInstance();
    utilCalendar.setTime(utilDate);

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
        APIResponse adsetsResponse = adsetsRequest.execute();
        APINodeList<AdSet> adsets = (APINodeList<AdSet>) adsetsResponse;

        for (AdSet adSet : adsets) {

          logger.info("to import adSet {}.", adSet.getId());

          while (sinceCalendar.before(utilCalendar)) {

            logger.info("to import date {}.", sinceCalendar.getTime());

            APIRequest<AdsInsights> insightsRequest = new APIRequest<>(context, adSet.getId(), "/insights", "GET", AdsInsights.getParser());
            HashMap<String, Object> params = Maps.newHashMap();
            params.put("fields", "impressions,clicks,frequency,reach,spend,total_actions,total_action_value");

            String sinceTime = df.format(sinceCalendar.getTime());
            sinceCalendar.add(Calendar.DAY_OF_MONTH, 1);
            String utilTime = df.format(sinceCalendar.getTime());

            params.put("time_range", "{\"since\":\"" + sinceTime + "\",\"until\":\"" + utilTime + "\"}");

            String fieldDailyBudget = adSet.getFieldDailyBudget();
            APIResponse insightsResponse = insightsRequest.execute(params);

            if (null != insightsResponse) {
              APINodeList<AdsInsights> insights = (APINodeList<AdsInsights>) insightsResponse;
              for (AdsInsights adsInsights : insights) {

                logger.info("to import insight {}.", adsInsights);

                ReportDailyDO reportDailyDO = new ReportDailyDO();
                reportDailyDO.setAdsetId(adSet.getId());
                if (null != fieldDailyBudget) {
                  reportDailyDO.setBudget(new BigDecimal(fieldDailyBudget));
                }
                reportDailyDO.setClicks(Integer.valueOf(adsInsights.getFieldClicks()));
                reportDailyDO.setDate(Integer.valueOf(sinceTime.replaceAll("-", "")));
                reportDailyDO.setFacebookId(userAccountDO.getFacebookId());
                reportDailyDO.setImpressions(Integer.valueOf(adsInsights.getFieldImpressions()));
                reportDailyDO.setFrequency(Float.valueOf(adsInsights.getFieldFrequency()));
                reportDailyDO.setReachs(Integer.valueOf(adsInsights.getFieldReach()));
                if (null != adsInsights.getFieldSpend()) {
                  reportDailyDO.setSpend(new BigDecimal(adsInsights.getFieldSpend()));
                }
                reportDailyDO.setUpdateTime(new Date());

                reportDailyDOMapper.insert(reportDailyDO);

              }
            }
          }
        }
      }

    }

    return "success";

  }

  public static void main(String[] args) throws APIException {

    APIContext context = new APIContext("EAAFzrZCeZBHoIBAJ2ZCpuZBY20voFvV9nXrhX1IDKuqdqNfA0hcPj0nEjf6cfAclYmcYhgVTTD8V0wGXgMgUb6kxgRZCoYccCglEbljI29Hahhhw8SEZAdXHFPnieyBRzMG9kbn5EihxRo3ptVZBHZCyNMWW8LhJCvGrpfO2Gwy28bTSlwqdAclV");
    APIRequest<AdAccount> adAccountsRequest = new APIRequest<AdAccount>(context,
      "212380059411381", "/adaccounts", "GET", AdAccount.getParser());
    APIResponse response = adAccountsRequest.execute();
    APINodeList<AdAccount> adAccounts = (APINodeList<AdAccount>) response;
    for (AdAccount adAccount : adAccounts) {
      System.out.println(adAccount);

      APIRequest<AdSet> adsetsRequest = new APIRequest<AdSet>(context, "act_" + adAccount.getId(), "/adsets", "GET", AdSet.getParser());
      HashMap<String, Object> adsetsParams = Maps.newHashMap();
      adsetsParams.put("fields", "fields=name,daily_budget");
      APIResponse adsetsResponse = adsetsRequest.execute(adsetsParams);
      APINodeList<AdSet> adsets = (APINodeList<AdSet>) adsetsResponse;
      for (AdSet adSet : adsets) {

        System.out.println(adSet.getId());

        APIRequest<AdsInsights> insightsRequest = new APIRequest<>(context, adSet.getId(), "/insights", "GET", AdsInsights.getParser());
        HashMap<String, Object> params = Maps.newHashMap();
        params.put("fields", "impressions,clicks,frequency,reach,spend,total_actions,total_action_value");
        params.put("time_range", "{\"since\":\"2018-03-01\",\"until\":\"2018-04-01\"}");
        String fieldDailyBudget = adSet.getFieldDailyBudget();
        System.out.println(fieldDailyBudget);

        APIResponse insightsResponse = insightsRequest.execute(params);
        System.out.println(insightsResponse);


      }
    }

  }

}
