package com.nazaninfz.rabbitproducer.services;

import com.nazaninfz.messagingsharedmodel.models.TestModel;
import com.nazaninfz.messagingsharedmodel.models.TestModelInner1;
import com.nazaninfz.messagingsharedmodel.models.TestModelInner2;
import com.nazaninfz.messagingsharedmodel.models.request.RequestObject;
import com.nazaninfz.messagingsharedmodel.models.response.ResponseObject;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@AllArgsConstructor
public class Test {
    private final RabbitProducerImpl service;

    public void test() {
        service.sendMessage(new RequestObject()
                .setRequestBody(
                        new TestModel()
                                .setAge(11)
                                .setName("pedram")
                                .setFamilyName("alipour")
                                .setYear(5656))

//                .set(new TypeReference<TestModel>() {
//                })
                .setExchange("test-exchange")
                .setRequestSendDate(new Date())
                .setCommandId(UUID.randomUUID().toString())
                .setSequenceId(UUID.randomUUID().toString())
                .setRoutingKey("routing-key-Test2"));

    }

    @PostConstruct
    public void test2() {
//        System.out.println(new TypeReference<RequestObject<TestModel>>() {
//        } + "");
//        System.out.println(new TypeReference<RequestObject<TestModel>>() {
//        }.getType() + "");
//        System.out.println(new TypeReference<RequestObject<TestModel>>() {
//        }.getType().getTypeName() + "");
//        new Type()
        ResponseObject requestObject = service.sendAndReceiveMessage(new RequestObject()
                .setRequestBody(
                        new TestModel<TestModelInner1<TestModelInner2>>()
                                .setAge(11)
                                .setName("pedram")
                                .setFamilyName("alipour")
                                .setYear(5656)
                                .setT(new TestModelInner1<TestModelInner2>()
                                        .setBabe("fdfs")
                                        .setYy("dss")
                                        .setR(new TestModelInner2()
                                                .setInner2("inner")
                                                .setFdsfsdfes("fszdfs"))))
//                .setRequestBodyTypeRef(new TypeReference<TestModel>() {
//                })
                .setExchange("test-exchange")
                .setRequestSendDate(new Date())
                .setCommandId(UUID.randomUUID().toString())
                .setSequenceId(UUID.randomUUID().toString())
                .setUseCase("TestUseCase")
                .setRoutingKey("routing-key-Test2"));
        System.out.println("fd");
    }
}
