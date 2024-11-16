package com.example.Tutorial10.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse extends RuntimeException {

    String message;
    Object object;

    public ApiResponse(String message, Object object) {
        super(message);
        this.object = object;
    }
}
