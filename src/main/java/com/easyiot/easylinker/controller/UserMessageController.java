package com.easyiot.easylinker.controller;

import com.easyiot.easylinker.model.User;
import com.easyiot.easylinker.model.UserMessage;
import com.easyiot.easylinker.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/userMessage")
public class UserMessageController {
    @Autowired
    UserMessageService userMessageService;

    @RequestMapping(value = "/list")
    public ModelAndView list(ModelAndView modelAndView, HttpServletRequest httpServletRequest) {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user == null) {
            modelAndView.setViewName("userMessage/list");
            return modelAndView;

        } else {
            int state;
            try {
                state = Integer.parseInt(httpServletRequest.getParameter("state"));
            } catch (Exception e) {
                state = 0;
            }


            if (httpServletRequest.getParameter("page") != null && httpServletRequest.getParameter("size") != null) {
                int page = Integer.parseInt(httpServletRequest.getParameter("page"));
                int size = Integer.parseInt(httpServletRequest.getParameter("size"));
                if (page <= 0) page = 0;
                if (size <= 0) size = 20;
                Page<UserMessage> userMessagePage = userMessageService.list(user.getId(), state, PageRequest.of(page, size));
                modelAndView.addObject("userMessagePage", userMessagePage);
                modelAndView.addObject("noReadMessageCount", userMessagePage.getContent().size());

            } else {
                Page<UserMessage> userMessagePage = userMessageService.list(user.getId(), state, PageRequest.of(0, 20));
                modelAndView.addObject("userMessagePage", userMessagePage);
                modelAndView.addObject("noReadMessageCount", userMessagePage.getContent().size());

            }
            modelAndView.setViewName("userMessage/list");
            return modelAndView;

        }

    }

    /**
     * 标记已读
     * @param modelAndView
     * @param httpServletRequest
     * @return
     */

    @RequestMapping(value = "/markRead")
    public ModelAndView markRead(ModelAndView modelAndView, HttpServletRequest httpServletRequest) {
        long id;
        try {
            id = Integer.parseInt(httpServletRequest.getParameter("id"));
        } catch (Exception e) {
            id = 0;
        }
        UserMessage userMessage = userMessageService.findOneById(id);
        if (userMessage != null) {
            userMessage.setState(0);
            userMessageService.update(userMessage);
        }
        modelAndView.setViewName("redirect:/userMessage/list?state=1");
        return modelAndView;

    }

}
