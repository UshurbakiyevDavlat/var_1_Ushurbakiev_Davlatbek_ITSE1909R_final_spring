package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.JMS;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@EnableJms
@Component
public class Reciever {

    @JmsListener(destination = "Listener")
    public String receiveMessage(String text) {
        return "Recieved - " + text;
    }
}
