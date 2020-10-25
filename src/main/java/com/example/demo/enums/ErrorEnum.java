package com.example.demo.enums;

/**
 * @author cui
 */

public enum ErrorEnum {

    /**
     *系统异常
     */
    SYS_ERROR(1001, "系统异常"),

    /**
     * 参数不能为空
     */
    BASE(1002, "参数不能为空");

    private Integer code;

    private String msg;

    ErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
