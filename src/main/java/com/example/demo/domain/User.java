package com.example.demo.domain;

import lombok.Data;

/**
 * @author cuixiaoxu
 */
@Data
public class User {
    private Integer id;

    private String nickname;

    private String password;

    private Integer sex;

    private String birthday;
}
