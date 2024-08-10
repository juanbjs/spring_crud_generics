package com.guaranitech.demo.exception;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class EntityCreateFailedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private final String message;

    public EntityCreateFailedException(String message) {
        super(message);
        this.message = message;
    }
}
