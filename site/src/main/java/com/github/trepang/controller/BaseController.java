package com.github.trepang.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.trepang.controller.support.JsonResult;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * @author tianbing
 */
abstract class BaseController {

    private static final ObjectMapper JSON_OBJECT_MAPPER = new ObjectMapper();

    <T> JsonResult<T> ok(T data) {
        return new JsonResult<>(data);
    }

    <T> JsonResult<T> fail(String message) {
        return new JsonResult<>(JsonResult.FAIL, message);
    }

    <T> ResponseEntity responseEntity(T data) {
        HttpHeaders responseHeaders = new HttpHeaders();
        if (data instanceof JsonResult) {
            responseHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        }
        return new ResponseEntity(data, responseHeaders, HttpStatus.OK);
    }
}
