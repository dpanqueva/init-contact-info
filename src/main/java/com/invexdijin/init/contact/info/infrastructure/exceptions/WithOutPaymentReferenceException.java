package com.invexdijin.init.contact.info.infrastructure.exceptions;

public class WithOutPaymentReferenceException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public WithOutPaymentReferenceException() {

    }

    public WithOutPaymentReferenceException(String message) {
        super(message);
    }
}
