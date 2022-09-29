package com.msagiroglu.backendspringboot.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String name, String text, String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("m.sagiro042@gmail.com");
        message.setTo("m.sagiro042@gmail.com");
        message.setSubject(name);
        message.setText(text + " Email: " + email);
        emailSender.send(message);
    }
}
