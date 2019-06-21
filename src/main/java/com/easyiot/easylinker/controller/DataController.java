package com.easyiot.easylinker.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.easyiot.easylinker.model.ClientData;
import com.easyiot.easylinker.service.ClientDataService;
import com.easyiot.easylinker.service.SimpleHttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    public JSONObject in(@RequestBody String body) {
        if (body.length() > 1024) {
            JSONObject error = new JSONObject();
            error.put("state", 0);
            error.put("message", "数据格式过大!");
            return error;
        }
        try {
            JSONObject data = JSON.parseObject(body);
            if (StringUtils.hasText(data.getString("value")) && data.getLong("clientId") != null) {
                if (simpleHttpClientService.findOneById(data.getLong("clientId")) == null) {
                    JSONObject error = new JSONObject();
                    error.put("state", 4);
                    error.put("message", "此客户端不存在!");
                    return error;
                }
                ClientData clientData = new ClientData();
                clientData.setClientId(data.getLong("clientId"));
                clientData.setValue(data.getString("value"));
                clientDataService.save(clientData);
                JSONObject msg = new JSONObject();
                msg.put("state", 1);
                msg.put("message", "数据提交成功!");
                return msg;

            } else {
                JSONObject error = new JSONObject();
                error.put("state", 2);
                error.put("message", "数据关键字段缺失!");
                return error;
            }


        } catch (Exception e) {
            JSONObject error = new JSONObject();
            error.put("state", 3);
            error.put("message", "数据格式必须是JSON!");
            return error;
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
        JSONObject result=new JSONObject();
        result.put("data",clientDataService.list(clientId, PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"))));

        return result;

    }

}
