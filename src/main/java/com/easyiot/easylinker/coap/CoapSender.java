package com.easyiot.easylinker.coap;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class CoapSender {
    /**
     * 测试发送
     * @throws URISyntaxException
     */
    public void coapMessageSender() throws URISyntaxException {
        URI uri = new URI("coap://localhost:5683/testcoap");
        CoapClient coapClient = new CoapClient(uri);
        CoapResponse coapResponse = coapClient.post("this is a coap client test",
                MediaTypeRegistry.TEXT_PLAIN);
        if (coapResponse!=null){
            System.out.println("#coapsender_method: "+coapResponse.getCode());
            System.out.println("#coapsender_responesText: "+coapResponse.getResponseText());
            System.out.println("#coapsender_respones: "+ Utils.prettyPrint(coapResponse));
        }

    }

    /**
     * 发送payload到指定uri
     * @param uril
     * @param payload
     * @throws URISyntaxException
     */
    public void coapMessageSender(String uril,String payload) throws URISyntaxException{
        URI uri = new URI("coap://localhost:5683/"+uril);
        CoapClient coapClient = new CoapClient(uri);
        CoapResponse coapResponse = coapClient.post(payload,
                MediaTypeRegistry.TEXT_PLAIN);
        if (coapResponse!=null){
            System.out.println("#coapsender_method: "+coapResponse.getCode());
            System.out.println("#coapsender_responesText: "+coapResponse.getResponseText());
            System.out.println("#coapsender_respones: "+ Utils.prettyPrint(coapResponse));
        }
    }
}
