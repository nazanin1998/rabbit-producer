package com.nazaninfz.rabbitproducer.exceptions;

import static com.nazaninfz.rabbitproducer.exceptions.RabbitExceptionEnum.RABBIT_SEND_MESSAGE_EXCEPTION;

public class RabbitProducerSendMessageException extends RabbitProducerGeneralException {
    public RabbitProducerSendMessageException(Throwable e) {
        super(RABBIT_SEND_MESSAGE_EXCEPTION, e);
    }
}
