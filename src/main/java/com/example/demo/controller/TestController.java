package com.example.demo.controller;

import com.example.demo.retry.TestRetry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName TestController
 * @Description: TODO
 * @Author cui
 * @Date 2020/4/19
 * @Version V1.0
 **/
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private TestRetry testRetry;

    @GetMapping("/a")
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        String a = "Hello Springboot!";
        log.info("打印日志info:{}", a);
        String contextPath = request.getContextPath();
        log.info("contextPath:{}", contextPath);
        return a;
    }

    @GetMapping("/retry")
    public String retry() {
        return testRetry.test("111111","222222");
    }
}
