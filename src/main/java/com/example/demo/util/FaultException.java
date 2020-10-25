package com.example.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author cui
 */
@Data
@AllArgsConstructor
public class FaultException extends RuntimeException {

    private Integer code;

    private String msg;

}