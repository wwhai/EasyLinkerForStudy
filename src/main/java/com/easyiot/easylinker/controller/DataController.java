package com.easyiot.easylinker.controller;

import com.alibaba.fastjson.JSONObject;
import com.easyiot.easylinker.model.ClientData;
import com.easyiot.easylinker.service.ClientDataService;
import com.easyiot.easylinker.service.SimpleHttpClientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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


    /**
     * 数据从外部进来
     *
     * @return
     */
    @PostMapping("/in")
    public JSONObject in(@RequestBody @Valid DataParam dataParam) {
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

    @Data
    static class DataParam {
        @NotNull
        String clientId;
        @NotNull
        String value;
    }
}
