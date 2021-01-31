package com.eg.fcloud.entity;

import lombok.Data;

/**
 * @Author: CAOPING
 * @Date: 2021/1/29 10:58
 * @Description:
 */
@Data
public class Response<T> {
    private static final int SUCCESS = 200;

    //状态码
    private int status;
    //返回信息
    private String message;
    //返回结果
    private T result;

    public static Response build() {
        return new Response();
    }

    public static Response build(Object result) {
        Response response = new Response();
        response.setResult(result);
        return response;
    }

    public Response success() {
        return success(SUCCESS, "SUCCESS");
    }

    public Response success(final int status) {
        return success(status, "SUCCESS");
    }

    public Response success(final String message) {
        return success(SUCCESS, message);
    }

    public Response success(int status, final String message) {
        this.message = message;
        this.status = status;
        return this;
    }

    public Response fail(final String message) {
        return fail(300, message);
    }

    public Response fail(final int status, final String message) {
        this.message = message;
        this.status = status;
        return this;
    }

    public Response fail(final Exception e) {
        return fail(300, e);
    }

    public Response fail(final int status, final Exception e) {
        String message = e.getMessage();
        if (message == null || message.isEmpty()) {
            message = "some error occurs";
        }
        fail(status, message);
        return this;
    }
}
