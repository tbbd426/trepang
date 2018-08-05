package com.github.trepang.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.trepang.controller.support.JsonResult;

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
}
