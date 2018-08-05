package com.github.trepang.controller.support;

import lombok.Data;

/**
 * @author tianbing
 */
@Data
public class JsonResult<T> {

    public static final String OK = "ok";

    public static final String FAIL = "fail";

    private String status;

    private String errMsg;

    private T data;

    public JsonResult(T data) {
        this.status = OK;
        this.data = data;
    }

    public JsonResult(String status, String message) {
        this.status = status;
        this.errMsg = message;
    }
}
