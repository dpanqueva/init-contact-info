package com.invexdijin.init.contact.info.infrastructure.exceptions;

public class WithPaymentReferenceException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public WithPaymentReferenceException() {

    }

    public WithPaymentReferenceException(String message) {
        super(message);
    }
}
