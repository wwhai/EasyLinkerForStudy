package com.easyiot.easylinker.controller;

import com.easyiot.easylinker.model.User;
import com.easyiot.easylinker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 默认首页
 */
@Controller
public class IndexController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(ModelAndView modelAndView, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) {
        String email = httpServletRequest.getParameter("email");
        String password = httpServletRequest.getParameter("password");
        if (email == null || password == null) {
            modelAndView.addObject("login_error_message", "邮箱和密码不能为空!");
            return modelAndView;

        }
        User user = userService.getTopByEmailAndPassword(email, password);

        if (user != null) {
            httpServletRequest.getSession().setAttribute("user", user);
            modelAndView.setViewName("redirect:dashboard/index");

        } else {
            redirectAttributes.addFlashAttribute("login_error_message", "登录失败!");
            modelAndView.setViewName("redirect:/");

        }
        return modelAndView;
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(ModelAndView modelAndView, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) {
        httpServletRequest.getSession().removeAttribute("user");
        redirectAttributes.addFlashAttribute("tip_message", "注销成功!");
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

}