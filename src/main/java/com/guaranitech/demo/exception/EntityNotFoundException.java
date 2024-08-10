package com.guaranitech.demo.exception;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class EntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private final String message;

    public EntityNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
