package com.example.demo.service.impl;

import com.example.demo.service.AbstractCustomer;
import com.example.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class CustomerServiceImpl extends AbstractCustomer implements CustomerService {

    @Override
    public void find() throws ExecutionException, InterruptedException {
        test();
    }
}
