package com.example.j922springproject.model.exception;

import lombok.Getter;

@Getter
public class ClientException extends RuntimeException {
    private final int status;

    public ClientException(String message, int status) {
        super(message);
        this.status = status;
    }
}
