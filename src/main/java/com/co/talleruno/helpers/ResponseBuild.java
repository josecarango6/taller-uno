package com.co.talleruno.helpers;

import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.*;

@Component
public class ResponseBuild {

    public Response success() {
        return Response.builder()
                .data(CREATED.getReasonPhrase())
                .code(CREATED.value()).build();
    }

    public Response success(Object data) {
        return Response.builder()
                .data(data)
                .code(CREATED.value()).build();
    }

    public Response failed() {
        return Response.builder()
                .data(BAD_REQUEST.getReasonPhrase())
                .code(BAD_REQUEST.value()).build();
    }

    public Response failedTaskNotFound() {
        return Response.builder()
                .data(NOT_FOUND.getReasonPhrase())
                .code(NOT_FOUND.value()).build();
    }

    public Response failed(Object data) {
        return Response.builder()
                .data(data)
                .code(BAD_REQUEST.value()).build();
    }



}
