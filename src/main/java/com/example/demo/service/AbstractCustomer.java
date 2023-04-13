package com.example.demo.service;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AbstractCustomer {

    private ExecutorService executorService = Executors.newFixedThreadPool(3,new CustomizableThreadFactory(UUID.randomUUID().toString()));

    protected void test() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return "result1";
        }, executorService);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            return "result2";
        }, executorService);
        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf3 do something....");
            return "result3";
        }, executorService);
        CompletableFuture<String> cf4 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf4 do something....");
            return "result4";
        }, executorService);
        System.out.println("结果1->" + cf1.get());
        System.out.println("结果2->" + cf2.get());
        System.out.println("结果3->" + cf3.get());
        System.out.println("结果4->" + cf4.get());
    }
}
