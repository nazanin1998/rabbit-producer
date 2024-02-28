package com.nazaninfz.rabbitproducer.exceptions;

import com.nazaninfz.commons.exception.GeneralException;

import static com.nazaninfz.rabbitproducer.exceptions.RabbitExceptionEnum.RABBIT_GENERAL_EXCEPTION;

public class RabbitProducerGeneralException extends GeneralException {

    public static final String RABBIT_PRODUCER_SERVICE_NAME = "RABBIT_PRODUCER_SERVICE_NAME";
    public static final String RABBIT_PRODUCER_SERVICE_NUM = "1001";

    public RabbitProducerGeneralException(Throwable e) {
        super(RABBIT_PRODUCER_SERVICE_NAME,
                RABBIT_PRODUCER_SERVICE_NUM,
                RABBIT_GENERAL_EXCEPTION.getStatusCode(),
                RABBIT_GENERAL_EXCEPTION.getMessage(),
                e);
    }
    public RabbitProducerGeneralException(RabbitExceptionEnum enums, Throwable e) {
        super(RABBIT_PRODUCER_SERVICE_NAME,
                RABBIT_PRODUCER_SERVICE_NUM,
                enums.getStatusCode(),
                enums.getMessage(),
                enums.getExceptionNumber(),
                e);
    }
}
