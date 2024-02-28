package com.nazaninfz.rabbitproducer.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum RabbitExceptionEnum {
    RABBIT_GENERAL_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, 1, "RABBIT_GENERAL_EXCEPTION"),
    RABBIT_SEND_MESSAGE_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, 2, "RABBIT_SEND_MESSAGE_EXCEPTION"),
    ;
    private final HttpStatus statusCode;
    private final int exceptionNumber;
    private final String message;
}
