package com.easyiot.easylinker.coap;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * COAP handler 此处以POST为例 可以增加get等
 */
@Component
public class MyCoapHandler extends CoapResource {
    public MyCoapHandler(@Value("${coap.name}") String name) {
        super(name);
    }

    @Override
    public void handlePOST(CoapExchange exchange) {
        exchange.respond("OK!"+exchange.getRequestText());
        System.out.println("#coap_method:"+exchange.getRequestCode());
        System.out.println(" coap_text:"+exchange.getRequestText());
    }
}

