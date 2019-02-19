package com.easyiot.easylinker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/home")
    public ModelAndView dashboard(ModelAndView modelAndView) {
        modelAndView.setViewName("/user/home");
        return modelAndView;
    }

}
