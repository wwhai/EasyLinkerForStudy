package com.easyiot.easylinker.coap;

import com.easyiot.easylinker.config.COAPConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 通过springboot runner启动coap线程
 */
@Component
public class MyCoapRunner implements ApplicationRunner {
    @Autowired
    COAPConfig coapConfig;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        coapConfig.startCoapServer();
    }
}
