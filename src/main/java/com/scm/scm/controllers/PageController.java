package com.scm.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

  @RequestMapping("/home")
  public String home(Model model) {
    model.addAttribute("name", "Technology");
    model.addAttribute("GitHub", "github.com/scm-spain/scm-webapp");
    return "home";
  }

  @RequestMapping("/about")
  public String about() {
    return "about";
  }

  @RequestMapping("/services")
  public String services() {
    return "services";
  }

  @RequestMapping("/register")
  public String register() {
    return "register";
  }

  @RequestMapping("/login")
  public String login() {
    return "login";
  }

  @RequestMapping("/contact")
  public String contact() {
    return "contact";
  }
}
