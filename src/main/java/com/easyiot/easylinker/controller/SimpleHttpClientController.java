package com.easyiot.easylinker.controller;

import com.easyiot.easylinker.model.SimpleHttpClient;
import com.easyiot.easylinker.service.SimpleHttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/simpleHttpClient")
public class SimpleHttpClientController {
    @Autowired
    SimpleHttpClientService simpleHttpClientService;

    /**
     * 设备列表
     *
     * @param modelAndView
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/list")
    public ModelAndView list(ModelAndView modelAndView, HttpServletRequest httpServletRequest) {
        if (httpServletRequest.getParameter("page") != null && httpServletRequest.getParameter("size") != null) {
            int page = Integer.parseInt(httpServletRequest.getParameter("page"));
            int size = Integer.parseInt(httpServletRequest.getParameter("size"));
            if (page <= 0) page = 0;
            if (size <= 0) size = 20;
            Page<SimpleHttpClient> simpleHttpClientPage = simpleHttpClientService.list(PageRequest.of(page, size));
            modelAndView.addObject("clientPage", simpleHttpClientPage);
        } else {
            Page<SimpleHttpClient> simpleHttpClientPage = simpleHttpClientService.list(PageRequest.of(0, 20));
            modelAndView.addObject("clientPage", simpleHttpClientPage);
        }
        modelAndView.setViewName("simpleHttp/list");
        return modelAndView;
    }


    /**
     * 设备详情
     *
     * @param modelAndView
     * @param httpServletRequest
     * @return
     */

    @RequestMapping(value = "/detail")
    public ModelAndView detail(ModelAndView modelAndView, HttpServletRequest httpServletRequest) {
        //clientId
        long clientId = Long.parseLong(httpServletRequest.getParameter("clientId"));
        if (clientId != 0) {
            modelAndView.addObject("client", simpleHttpClientService.findOneById(clientId));
        }
        modelAndView.setViewName("simpleHttp/detail");
        return modelAndView;

    }
}
