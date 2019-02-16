package com.easyiot.easylinker.controller;

import com.easyiot.easylinker.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 默认首页
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public ModelAndView index(ModelAndView modelAndView) {

        return modelAndView;
    }

}