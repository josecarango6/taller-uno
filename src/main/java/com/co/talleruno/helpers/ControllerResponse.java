package com.co.talleruno.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ControllerResponse<T> {

    public ResponseEntity buildResponse(@Nullable T data, HttpStatus status) {
        return new ResponseEntity<>(data, status);
    }
}
