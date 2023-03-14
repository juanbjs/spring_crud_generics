package com.guaranitech.demo.exception;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class EntityNotFoundException extends RuntimeException {

    private final String message;

    public EntityNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
