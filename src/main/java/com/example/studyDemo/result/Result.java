package com.example.studyDemo.result;

/**
 * @Author: hao wu
 * @Date： 2023/1/9 22:53
 */

import io.swagger.annotations.ApiModel;

/**
 * 统一API响应结果封装
 */
@ApiModel
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.tips();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }
}


