package com.invexdijin.init.contact.info.infrastructure.exceptions;

public class AttemptsLimitException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public AttemptsLimitException() {

    }

    public AttemptsLimitException(String message) {
        super(message);
    }
}
