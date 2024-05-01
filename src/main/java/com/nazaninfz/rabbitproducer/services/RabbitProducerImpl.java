package com.nazaninfz.rabbitproducer.services;

import com.nazaninfz.messagingsharedmodel.models.request.RequestObject;
import com.nazaninfz.messagingsharedmodel.models.response.ResponseObject;
import com.nazaninfz.producer.interfaces.Producer;
import com.nazaninfz.rabbitproducer.exceptions.RabbitProducerSendMessageException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitProducerImpl implements Producer {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(RequestObject requestObject) {
        log.info("send message by rabbit called, request object: {}", requestObject);
        try {
            rabbitTemplate.convertAndSend(
                    requestObject.getExchange(),
                    requestObject.getRoutingKey(),
                    requestObject);
        } catch (Exception e) {
            log.error("exception in send message by rabbit", e);
            throw new RabbitProducerSendMessageException(e);
        }
    }

    @Override
    public ResponseObject sendAndReceiveMessage(RequestObject requestObject) {
        log.info("send message and receive by rabbit called, request object: {}", requestObject);
        try {
            return (ResponseObject) rabbitTemplate.convertSendAndReceive(
                    requestObject.getExchange(),
                    requestObject.getRoutingKey(),
                    requestObject);
        } catch (Exception e) {
            log.error("exception in send message and receive by rabbit", e);
            throw new RabbitProducerSendMessageException(e);
        }
    }
}
