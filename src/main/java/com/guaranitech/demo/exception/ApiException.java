package com.guaranitech.demo.exception;

import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiException {

    private String errorMessage;
    private Integer statusCode;
    private ZonedDateTime zonedDateTime;
}
