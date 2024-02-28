package com.nazaninfz.rabbitproducer.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nazaninfz.messagingsharedmodel.models.request.RequestObject;
import com.nazaninfz.messagingsharedmodel.models.response.ResponseObject;
import com.nazaninfz.rabbitproducer.exceptions.RabbitProducerSendMessageException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitProducerService {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(RequestObject requestObject) {
        log.info("send message by rabbit");
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

    public ResponseObject sendAndReceiveMessage(RequestObject requestObject) {
        log.info("send and receive message by rabbit");
        try {
            ResponseObject responseObject = (ResponseObject) rabbitTemplate.convertSendAndReceive(
                    requestObject.getExchange(),
                    requestObject.getRoutingKey(),
                    requestObject);

            ObjectMapper objectMapper = new ObjectMapper();

//            Object responseBody = objectMapper.getTypeFactory().
//                    responseObject.getResponseBody(),
//                    responseObject.getRequestBodyTypeReference());
            return responseObject;
        } catch (Exception e) {
            log.error("exception in send and receive message by rabbit", e);
            throw new RabbitProducerSendMessageException(e);
        }
    }
}
