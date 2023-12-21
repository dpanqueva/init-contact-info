package com.invexdijin.init.contact.info.infrastructure.exceptions;

public class PaymentIntentWithStatusException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PaymentIntentWithStatusException() {

    }

    public PaymentIntentWithStatusException(String message) {
        super(message);
    }
}