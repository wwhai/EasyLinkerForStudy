package com.easyiot.easylinker.config;


import com.easyiot.easylinker.coap.MyCoapHandler;
import org.eclipse.californium.core.CoapServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * COAP server配置类
 */
@Component
public class COAPConfig {
    @Autowired
    MyCoapHandler myCoapHandler;
    public void startCoapServer(){
        //添加端口
        CoapServer server = new CoapServer(5683);
        //添加Handler
        server.add( myCoapHandler);
        //开启线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("coap server is running");
                server.start();
            }
        });
        thread.start();
    }

}


