package com.scm.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.scm.entities.User;
import com.scm.scm.forms.UserForm;
import com.scm.scm.services.UserService;

@Controller
public class PageController {

  @Autowired
  private UserService userService;

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
  public String register(Model model) {
    UserForm userForm = new UserForm();
    // userForm.setName("Technology");
    // userForm.setEmail("rajan@mail.com");
    // userForm.setAbout("About here");
    // userForm.setPassword("123");
    // userForm.setPhoneNumber("999999123");
    // default data also send from here
    model.addAttribute("userForm", userForm);
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

  // processing register
  @RequestMapping(value = "/do-register", method = RequestMethod.POST)
  public String processRegister(@ModelAttribute UserForm userForm) {
    System.out.println("Processing register.........");
    // fetch form data
    // UserForm
    System.out.println(userForm);
    // validate form data
    // save to db
    // userService

    // UserForm --> user
    User user = User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getPhoneNumber())
        .phoneNumber(userForm.getPhoneNumber())
        .profile(
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.P5sjoKLC37cI8QgqT53VGAHaHa%26pid%3DApi%26h%3D160&f=1&ipt=2e76dd5a8fafb435a5b606eef45e34020c1106fe445f78d2c036f01d5f9548ed&ipo=images")
        .build();
    User savedUser = userService.saveUser(user);
    System.out.println("savedUser");
    // message = "Registration successful"
    // redirect to login page
    return "redirect:/register";
  }

}
