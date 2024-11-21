package com.globalsolution.energym.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificadorPraticante {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();
    public void integrar (String message) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "notificar-request-exchange",
                "admin",
                message
        );
    }
}
