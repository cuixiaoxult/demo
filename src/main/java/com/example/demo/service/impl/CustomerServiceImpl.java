package com.example.demo.service.impl;

import com.example.demo.service.AbstractCustomer;
import com.example.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class CustomerServiceImpl extends AbstractCustomer implements CustomerService {

    private static String testValue;

    @Override
    public void find() throws ExecutionException, InterruptedException {
        //test();
        testValue = UUID.randomUUID().toString();
        log.info(testValue);
        Thread.sleep(5000);
        log.info(testValue);
    }
}
