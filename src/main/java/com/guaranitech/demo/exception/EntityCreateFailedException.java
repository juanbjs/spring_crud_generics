package com.guaranitech.demo.exception;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class EntityCreateFailedException extends RuntimeException {

    private final String message;

    public EntityCreateFailedException(String message) {
        super(message);
        this.message = message;
    }
}
