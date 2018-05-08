package com.peru.webapp;

import com.google.common.base.Strings;
import com.peru.common.Constants;
import com.peru.dal.UserAccountDO;
import com.peru.dal.UserAccountDOCriteria;
import com.peru.dal.UserAccountDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by roger.lu on 2018/5/7.
 */
@Controller
public class FacebookController {

  @Autowired
  private UserAccountDOMapper userAccountDOMapper;

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

}
