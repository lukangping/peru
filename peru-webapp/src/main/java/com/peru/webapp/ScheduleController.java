package com.peru.webapp;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.APIRequest;
import com.facebook.ads.sdk.APIResponse;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.Campaign;
import com.peru.dal.UserAccountDO;
import com.peru.dal.UserAccountDOCriteria;
import com.peru.dal.UserAccountDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by roger.lu on 2018/7/10.
 */
@Controller
public class ScheduleController {

  @Autowired
  private UserAccountDOMapper userAccountDOMapper;

  @RequestMapping(value = "/schedule/hourly", method = RequestMethod.GET)
  @ResponseBody
  public String doGet() throws APIException {

    UserAccountDOCriteria userAccountDOCriteria = new UserAccountDOCriteria();
    UserAccountDOCriteria.Criteria criteria = userAccountDOCriteria.createCriteria();
    criteria.andAccessTokenIsNotNull();

    List<UserAccountDO> userAccountDOs = userAccountDOMapper.selectByExample(userAccountDOCriteria);
    for (UserAccountDO userAccountDO : userAccountDOs) {
      APIContext context = new APIContext(userAccountDO.getAccessToken());
      APIRequest<AdAccount> adAccountsRequest = new APIRequest<AdAccount>(context,
        String.valueOf(userAccountDO.getUserId()), "/adaccounts", "GET", AdAccount.getParser());
      APIResponse response = adAccountsRequest.execute();
      APINodeList<AdAccount> adAccounts = (APINodeList<AdAccount>) response;
      for (AdAccount adAccount : adAccounts) {
        System.out.println(adAccount);

        APIRequest<Campaign> campaignsRequest = new APIRequest<Campaign>(context, adAccount.getId(), "/campaigns", "GET", Campaign.getParser());
        APIResponse campaignsResponse = campaignsRequest.execute();

        APINodeList<Campaign> campaigns = (APINodeList<Campaign>) campaignsResponse;
        for (Campaign campaign : campaigns) {
          System.out.println(campaign);

          APIRequest<AdSet> adsetsRequest = new APIRequest<AdSet>(context, campaign.getId(), "/adsets", "GET", AdSet.getParser());
          APIResponse adsetsResponse = adsetsRequest.execute();
          APINodeList<AdSet> adsets = (APINodeList<AdSet>) adsetsResponse;
          for (AdSet adSet : adsets) {

            System.out.println(adSet.getId());


          }



        }


      }



    }

    return null;

  }

  public static void main(String[] args) throws APIException {

    APIContext context = new APIContext("EAAFzrZCeZBHoIBAJ2ZCpuZBY20voFvV9nXrhX1IDKuqdqNfA0hcPj0nEjf6cfAclYmcYhgVTTD8V0wGXgMgUb6kxgRZCoYccCglEbljI29Hahhhw8SEZAdXHFPnieyBRzMG9kbn5EihxRo3ptVZBHZCyNMWW8LhJCvGrpfO2Gwy28bTSlwqdAclV");

    APIRequest<AdSet> request = new APIRequest<AdSet>(context, "act_1068712073265524", "/adsets", "GET", AdSet.getParser());

    APIResponse response = request.execute();

    APINodeList<AdSet> response1 = (APINodeList<AdSet>) response;
    for (AdSet adset : response1) {

      System.out.println(adset);
    }


  }

}
