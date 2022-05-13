package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.JMS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@EnableJms
@Service
public class Action {

    @Bean
    @Lazy
    public String SendMessage(String msg) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        try {
            jmsTemplate.convertAndSend("Listener", msg);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Have sent message:" + msg;
    }
}
