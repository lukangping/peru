package com.peru.webapp;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.peru.common.Constants;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by roger.lu on 2018/5/7.
 */
public class AuthorizeInterceptor extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    HttpSession session = request.getSession();
    if (null == session || null == session.getAttribute(Constants.SESSION_USERID)) {
      response.sendRedirect("/index.html");
      return false;
    }

    return true;
  }
}
