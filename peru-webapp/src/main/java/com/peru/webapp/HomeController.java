package com.peru.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by roger.lu on 2018/5/8.
 */
@Controller
public class HomeController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseBody
  public String doGet() {
    return "peru.";
  }
}
