package com.example.demo.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author cui
 */
@Data
@ToString
@NoArgsConstructor
public class GlobalResponse<T> {

    //private Integer status;

    private boolean success = false;

    private Integer errorCode;

    private String errorMsg;

    private T data;

    public GlobalResponse(T data, boolean success) {
        this.success = success;
        this.data = data;
    }

    public static <T> GlobalResponse<T> success(T data) {
        return new GlobalResponse<>(data, true);
    }

    public static <T> GlobalResponse<T> fail(String errorMsg) {
        GlobalResponse<T> resp = new GlobalResponse<T>();
        resp.setErrorCode(-1);
        resp.setErrorMsg(errorMsg);
        resp.setSuccess(false);
        return resp;
    }

    public static <T> GlobalResponse<T> fail(Integer errorCode, String errorMsg) {
        GlobalResponse<T> resp = new GlobalResponse<T>();
        resp.setErrorCode(errorCode);
        resp.setErrorMsg(errorMsg);
        resp.setSuccess(false);
        return resp;
    }

}