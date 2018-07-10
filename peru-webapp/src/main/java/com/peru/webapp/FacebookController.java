package com.peru.webapp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.facebook.ads.sdk.APIConfig;
import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APIRequest;
import com.facebook.ads.sdk.APIResponse;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.peru.common.Constants;
import com.peru.common.HttpHelper;
import com.peru.dal.UserAccountDO;
import com.peru.dal.UserAccountDOCriteria;
import com.peru.dal.UserAccountDOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by roger.lu on 2018/5/7.
 */
@Controller
public class FacebookController {

  @Autowired
  private UserAccountDOMapper userAccountDOMapper;

  @Autowired
  private HttpHelper httpHelper;

  private static final Logger logger = LoggerFactory.getLogger(FacebookController.class);

  public static final String APP_ID = "408674589613698";
  public static final String APP_SECRET = "571be6710d3855e2858236304edcaaad";

  @RequestMapping("/facebook/accounts")
  @ResponseBody
  public DefaultServiceResult doGet(HttpSession session) {

    String userId = session.getAttribute(Constants.SESSION_USERID).toString();

    UserAccountDOCriteria userAccountDOCriteria = new UserAccountDOCriteria();
    UserAccountDOCriteria.Criteria criteria = userAccountDOCriteria.createCriteria();
    criteria.andUserIdEqualTo(Integer.valueOf(userId));
    List<UserAccountDO> userAccountDOs = userAccountDOMapper.selectByExample(userAccountDOCriteria);

    return new DefaultServiceResult(userAccountDOs);
  }

  @RequestMapping("/auth/redirect")
  @ResponseBody
  public String doRedirect() {
    try {
      Thread.sleep(100000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "redirect.";
  }

  @RequestMapping("/auth/token")
  @ResponseBody
  public String doGetAccessToken(HttpSession session, String accessToken, String facebookId) {

    logger.info("get returned access token {} facebook userID {}.", accessToken, facebookId);

    String graphAPI = APIConfig.DEFAULT_API_BASE + "/" + APIConfig.DEFAULT_API_VERSION + "/oauth/access_token";
    HashMap<String, String> params = Maps.newHashMap();
    params.put("grant_type", "fb_exchange_token");
    params.put("client_id", APP_ID);
    params.put("client_secret", APP_SECRET);
    params.put("fb_exchange_token", accessToken);

    String response = httpHelper.get(graphAPI, params);
    JSONObject jsonObject = JSON.parseObject(response);
    String refreshedToken = jsonObject.getString("access_token");

    logger.info("refreshed token {}.", refreshedToken);

    String userId = (String)session.getAttribute(Constants.SESSION_USERID);
    UserAccountDO userAccountDO = new UserAccountDO();
    userAccountDO.setUserId(Integer.valueOf(userId));
    userAccountDO.setAccessToken(refreshedToken);
    userAccountDO.setFacebookId(facebookId);

    UserAccountDOCriteria userAccountDOCriteria = new UserAccountDOCriteria();
    UserAccountDOCriteria.Criteria criteria = userAccountDOCriteria.createCriteria();
    criteria.andUserIdEqualTo(Integer.valueOf(userId));
    criteria.andFacebookIdEqualTo(facebookId);

    List<UserAccountDO> userAccountDOs = userAccountDOMapper.selectByExample(userAccountDOCriteria);
    if (null != userAccountDOs && userAccountDOs.size() > 0) {
      userAccountDOMapper.updateByExample(userAccountDO, userAccountDOCriteria);
    } else {
      int result = userAccountDOMapper.insert(userAccountDO);
      if (result > 0) {
        logger.info("new facebook userID and accessToken are saved.");
      }
    }

    return "success.";

  }



}
