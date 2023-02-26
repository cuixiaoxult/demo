package com.example.demo.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class TestRetry {
    int a = 0;

    @Retryable(value = {RuntimeException.class}, maxAttempts = 5, backoff = @Backoff(delay = 1000, multiplier = 2))
    public String test(String applyNo, String userId) {
        log.info("test start");
        a++;
        System.out.println(a + " - " + System.currentTimeMillis());
        log.info("test time:{}", LocalDateTime.now());
        if (a < 10) {
            a = 1 / 0;
            log.info("test RuntimeException:未满足条件");
            //throw new Exception("未满足条件");
        }
        log.info("test 执行成功");
        return "执行成功";
    }

    @Recover
    public String recoverTest(RuntimeException e) {
        log.info("recoverTest 回调方法 applyNo:{},userId:{} e:{}", e.getMessage());
        return "回调方法" + e.getMessage();
    }
}
