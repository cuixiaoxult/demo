package com.example.demo.service.impl;

import com.example.demo.service.AbstractCustomer;
import com.example.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class CustomerServiceImpl extends AbstractCustomer implements CustomerService {

    private static String testValue;

    @Override
    public void find() throws ExecutionException, InterruptedException {
        //test();
        testValue = UUID.randomUUID().toString();
        log.info("测试值开始 testValue:{}",testValue);
        Thread.sleep(5000);
        log.info("测试值结束 testValue:{}",testValue);
    }
}
