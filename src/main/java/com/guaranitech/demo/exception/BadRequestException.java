package com.guaranitech.demo.exception;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class BadRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private final String message;

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }
}
