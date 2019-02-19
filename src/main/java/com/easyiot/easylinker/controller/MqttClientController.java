package com.easyiot.easylinker.controller;

import com.easyiot.easylinker.model.MqttClient;
import com.easyiot.easylinker.service.MqttClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/mqttClient")
public class MqttClientController {
    @Autowired
    MqttClientService mqttClientService;

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
            Page<MqttClient> mqttClientPage = mqttClientService.list(PageRequest.of(page, size));
            modelAndView.addObject("mqttClientPage", mqttClientPage);
        } else {
            Page<MqttClient> mqttClientPage = mqttClientService.list(PageRequest.of(0, 20));
            modelAndView.addObject("mqttClientPage", mqttClientPage);
        }
        modelAndView.setViewName("mqtt/list");
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
            modelAndView.addObject("client", mqttClientService.findOneById(clientId));
        }
        modelAndView.setViewName("mqtt/detail");
        return modelAndView;

    }
}
