package com.globalsolution.energym.services.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class NotificarResponseSucessoConsumidor {

    @RabbitListener(queues = {"notificar-response-sucesso-queue"})
    public void receive(@Payload Message message) {
        String payload = String.valueOf(message.getPayload());
        System.out.println("Praticante notificado com sucesso!" + payload);
    }
}
