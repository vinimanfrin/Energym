package com.globalsolution.energym.services.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class NotificarResponseErrorConsumidor {

    @RabbitListener(queues = {"notificar-response-erro-queue"})
    public void receive(@Payload Message message) {
        String payload = String.valueOf(message.getPayload());
        System.out.println("Erro ao notificar o praticante sobre sua nova conquista: " + payload);
    }
}
