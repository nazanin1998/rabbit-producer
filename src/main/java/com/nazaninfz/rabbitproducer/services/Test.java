package com.nazaninfz.rabbitproducer.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.nazaninfz.messagingsharedmodel.models.TestModel;
import com.nazaninfz.messagingsharedmodel.models.request.RequestObject;
import com.nazaninfz.messagingsharedmodel.models.response.ResponseObject;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.UUID;

@Component
@AllArgsConstructor
public class Test {
    private final RabbitProducerService service;

    public void test() {
        service.sendMessage(new RequestObject<TestModel>()
                .setRequestBody(
                        new TestModel()
                                .setAge(11)
                                .setName("pedram")
                                .setFamilyName("alipour")
                                .setYear(5656))

                .setRequestBodyTypeRef(new TypeReference<TestModel>() {
                })
                .setExchange("test-exchange")
                .setRequestSendDate(new Date())
                .setCommandId(UUID.randomUUID().toString())
                .setSequenceId(UUID.randomUUID().toString())
                .setRoutingKey("routing-key-Test2"));

    }

    @PostConstruct
    public void test2() {
        System.out.println(new TypeReference<RequestObject<TestModel>>() {
        } + "");
        System.out.println(new TypeReference<RequestObject<TestModel>>() {
        }.getType() + "");
        System.out.println(new TypeReference<RequestObject<TestModel>>() {
        }.getType().getTypeName() + "");
        new Type()
//        ResponseObject<?> requestObject = service.sendAndReceiveMessage(new RequestObject<TestModel>()
//                .setRequestBody(
//                        new TestModel()
//                                .setAge(11)
//                                .setName("pedram")
//                                .setFamilyName("alipour")
//                                .setYear(5656))
//                .setRequestBodyTypeRef(new TypeReference<TestModel>() {
//                })
//                .setExchange("test-exchange")
//                .setRequestSendDate(new Date())
//                .setCommandId(UUID.randomUUID().toString())
//                .setSequenceId(UUID.randomUUID().toString())
//                .setRoutingKey("routing-key-Test2"));
//        System.out.println("fd");
    }
}
