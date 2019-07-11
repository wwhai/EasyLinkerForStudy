package com.easyiot.easylinker.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SimpleMail {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendSimpleMail() {
        int i=10;
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //发件人邮箱
        mailMessage.setFrom("");
        //收件人邮箱
        mailMessage.setTo("");
        //主题
        mailMessage.setSubject("皇家澳门赌场");
        //内容
        mailMessage.setText("HELLO THANK U! ARE YOU OK?");
        javaMailSender.send(mailMessage);

    }
}
