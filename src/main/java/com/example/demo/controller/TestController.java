package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.aop.ThreadPoolExecutorMdcWrapper;
import com.example.demo.retry.TestRetry;
import com.example.demo.service.Customer2Service;
import com.example.demo.service.CustomerService;
import com.example.demo.vo.PhoneVerifyResultMessage;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

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

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Customer2Service customer2Service;

//    @Autowired
//    private Executor optimizeTaskExecutor;

    @GetMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response) throws ExecutionException, InterruptedException {
        String a = "Hello Springboot!";
        log.info("打印日志info:{}", a);
        String contextPath = request.getContextPath();
        log.info("contextPath:{}", contextPath);
        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() ->
                log.info("cf1 do something....:{}", Thread.currentThread())
        );
        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() ->
                log.info("cf2 do something....:{}", Thread.currentThread())
        );
        CompletableFuture<Void> cf3 = CompletableFuture.runAsync(() ->
                log.info("cf3 do something....:{}", Thread.currentThread())
        );
        log.info("打印日志 cf1.get:{}", cf1.get());
        log.info("打印日志 cf2.get:{}", cf2.get());
        log.info("打印日志 cf3.get:{}", cf3.get());
        return a;
    }

    @GetMapping("/a")
    public String hello(HttpServletRequest request, HttpServletResponse response) throws ExecutionException, InterruptedException {
        String a = "Hello Springboot!";
        log.info("打印日志info:{}", a);
        String contextPath = request.getContextPath();
        log.info("contextPath:{}", contextPath);
        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() ->
                log.info("cf1 do something....:{}", Thread.currentThread())
        );
        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() ->
                log.info("cf2 do something....:{}", Thread.currentThread())
        );
        CompletableFuture<Void> cf3 = CompletableFuture.runAsync(() ->
                log.info("cf3 do something....:{}", Thread.currentThread())
        );
        log.info("打印日志 cf1.get:{}", cf1.get());
        log.info("打印日志 cf2.get:{}", cf2.get());
        log.info("打印日志 cf3.get:{}", cf3.get());
        return a;
    }

    /**
     * 造数据（测试）
     */
    @PostMapping(value = "/v1/phoneVerify/testPush")
    public void testPush(@RequestBody PhoneVerifyResultMessage phoneVerifyResultMessage) {
        log.info("pushPhoneVerify test");
        List<String> reasons = new ArrayList<>();
        reasons.add("ok");
        phoneVerifyResultMessage.setReason(JSON.toJSONString(reasons));
        String str = JSON.toJSONString(phoneVerifyResultMessage);
        log.info("testPush str:{}", str);
        PhoneVerifyResultMessage message = JSONObject.parseObject(str, PhoneVerifyResultMessage.class);
        List list = JSON.parseObject(message.getReason(), List.class);
        log.info("testPush list:{}", list);
        String reason = Joiner.on(",").join(JSON.parseObject(message.getReason(), List.class));
        log.info("testPush reason:{}", reason);
    }

    @GetMapping("/retry")
    public String retry() {
        return testRetry.test("111111", "222222");
    }

    @PostMapping("/find")
    public void find() throws ExecutionException, InterruptedException {
        customerService.find();
    }

    @PostMapping("/find2")
    public void find2() throws ExecutionException, InterruptedException {
        customer2Service.find();
    }
}
