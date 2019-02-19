package com.easyiot.easylinker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 控制面板
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @RequestMapping(value = "/index")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("dashboard/index");
        return modelAndView;
    }

}
