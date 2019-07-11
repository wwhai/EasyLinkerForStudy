package com.easyiot.easylinker.controller;

import com.alibaba.fastjson.JSONObject;
import com.easyiot.easylinker.amq.AmqService;
import com.easyiot.easylinker.coap.CoapSender;
import com.easyiot.easylinker.mail.SimpleMail;
import com.easyiot.easylinker.model.ClientData;
import com.easyiot.easylinker.mqttServer.MqttServer;
import com.easyiot.easylinker.service.ClientDataService;
import com.easyiot.easylinker.service.SimpleHttpClientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.messaging.MessageHandler;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;

/**
 * 数据上传控制器
 */
@RestController
@RequestMapping("/data/api")
public class DataController {
    @Autowired
    ClientDataService clientDataService;
    @Autowired
    SimpleHttpClientService simpleHttpClientService;
    @Autowired
    AmqService amqService;
    @Autowired
    Queue queue;
    @Autowired
    @Qualifier("queue2")
    Queue queue2;
    @Autowired
    MqttServer.MqttGateway mqttGateway;
    @Autowired
    CoapSender coapSender;
    @Autowired
    SimpleMail simpleMail;
    /**
     * 数据从外部进来
     *
     * @return
     */
    @PostMapping("/in")
    public JSONObject in(@RequestBody   @Valid DataParam dataParam) {
        System.out.println("#"+dataParam);
        if (dataParam.value.length() > 1024) {
            JSONObject error = new JSONObject();
            error.put("state", 0);
            error.put("message", "数据格式过大!");
            return error;
        }
        if (simpleHttpClientService.findOneByClientId(dataParam.getClientId()) != null) {
            ClientData clientData = new ClientData();
            clientData.setClientId(dataParam.getClientId());
            clientData.setValue(dataParam.getValue());
            clientDataService.save(clientData);
            JSONObject msg = new JSONObject();
            msg.put("state", 1);
            msg.put("message", "数据提交成功!");
            return msg;
        } else {
            JSONObject msg = new JSONObject();
            msg.put("state", 0);
            msg.put("message", "设备不存在!");
            return msg;
        }


    }


    /**
     * 获取数据
     *
     * @param clientId
     * @param page
     * @param size
     * @return
     */

    @GetMapping("/dataList/{clientId}/{page}/{size}")
    @Transactional
    public JSONObject getData(@PathVariable String clientId, @PathVariable int page, @PathVariable int size) {
        JSONObject result = new JSONObject();
        result.put("data", clientDataService.list(clientId, PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"))));

        return result;

    }
    @GetMapping("/amqtest")
    public void amqTest(){
        amqService.sendMessage("this a test!");
    }
    @GetMapping("/amqtest2")
    public void amqTest2(){
        amqService.sendMessage(this.queue2,"this a test send to queue!");
    }
    @GetMapping("/send2mqtt")
    public void mqttSendTest(){
        mqttGateway.sendMessage("this a mqtt's sending message test");
    }
    @GetMapping("/send2coap")
    public void coapSendTest(@RequestParam(name = "payload") String payload) throws URISyntaxException {
        coapSender.coapMessageSender("testcoap",payload);
        // coapSender.coapMessageSender(); 测试方法
    }
    @GetMapping("/sendmail")
    public void sendMail(){
        simpleMail.sendSimpleMail();
    }

    @Data
    static class DataParam {
        @NotNull
        String clientId;
        @NotNull
        String value;
    }
}
