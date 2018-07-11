package com.peru.webapp;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.hash.Hashing;
import com.peru.common.Constants;
import com.peru.dal.UserDO;
import com.peru.dal.UserDOCriteria;
import com.peru.dal.UserDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by roger.lu on 2018/5/7.
 */
@Controller
public class LoginController {

  @Autowired
  private UserDOMapper userDOMapper;

  @RequestMapping(value="/login", method= RequestMethod.POST)
  @ResponseBody
  public DefaultServiceResult doPost(HttpServletResponse response, HttpSession session,
    @RequestParam("email") String email, @RequestParam("password") String password) {

    response.setHeader("Access-Control-Allow-Origin", "*");

    if (Strings.isNullOrEmpty(email) || Strings.isNullOrEmpty(password)) {
      return new DefaultServiceResult(false, "either email or password is empty.");
    }

    String pwd = Hashing.md5().hashString(password, Charsets.UTF_8).toString();

    UserDOCriteria userDOCriteria = new UserDOCriteria();
    UserDOCriteria.Criteria criteria = userDOCriteria.createCriteria();
    criteria.andEmailEqualTo(email);
    criteria.andPasswordEqualTo(pwd);

    List<UserDO> userDOs = userDOMapper.selectByExample(userDOCriteria);
    if (!userDOs.isEmpty()) {
      session.setAttribute(Constants.SESSION_USERID, userDOs.get(0).getId().toString());
      return new DefaultServiceResult(true);
    } else {
      return new DefaultServiceResult(false, "email and password are not matched.");
    }

  }

  @RequestMapping(value="/login/check", method= RequestMethod.GET)
  @ResponseBody
  public DefaultServiceResult doCheck(HttpServletResponse response, HttpSession session){

    String userId = (String)session.getAttribute(Constants.SESSION_USERID);
    if (Strings.isNullOrEmpty(userId)) {
      return new DefaultServiceResult(false);
    } else {
      return new DefaultServiceResult(true);
    }

  }

  @RequestMapping(value="/logout", method= RequestMethod.GET)
  @ResponseBody
  public String doLogout(HttpServletResponse response, HttpSession session){

    session.removeAttribute(Constants.SESSION_USERID);
    return "success";

  }

}
