package oit.is.ouyouteam.c03.sec_app.sec_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample3")
public class Sample31Controller {

  @GetMapping("step1")
  public String sample31() {
    return "sample31.html";
  }
}
