package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PhoneVerifyResultMessage {

    private Long id;

    private String userId;

    private String applyNo;

    private String score;

    private String applyDt;

    private String reason;
}
