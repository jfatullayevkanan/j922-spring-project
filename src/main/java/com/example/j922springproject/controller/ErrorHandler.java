package com.example.j922springproject.controller;

import com.example.j922springproject.model.exception.ClientException;
import com.example.j922springproject.model.exception.ExceptionDto;
import com.example.j922springproject.model.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionDto handle(NotFoundException exception) {
        log.error("ActionLog.handle.error NotFoundException handled");

        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setCode(exception.getMessage());

        return exceptionDto;
    }

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<ExceptionDto> handle(ClientException ex) {
        ExceptionDto response = new ExceptionDto(ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(response);
    }
//
//    @ExceptionHandler(IOException.class)
//    ExceptionDto handle(IOException exception) {
//        log.error("ActionLog");
//        return new ExceptionDto(exception.getMessage());
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public List<ExceptionDto> handle(MethodArgumentNotValidException exception) {
        List<ExceptionDto> errors = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(e -> errors.add(new ExceptionDto(e.getDefaultMessage())));
        return errors;
    }
}
