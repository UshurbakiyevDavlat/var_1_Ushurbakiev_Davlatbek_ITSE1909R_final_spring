package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.JMS;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@EnableJms
@Service
public class Action {



    @Bean
    public boolean SendMessage() {
        JmsTemplate jmsTemplate = new JmsTemplate();

        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
        try {
            jmsTemplate.convertAndSend("Listener", "Hello");
        } catch (Exception exception) {
            return false;
        }
        return true;
    }
}
