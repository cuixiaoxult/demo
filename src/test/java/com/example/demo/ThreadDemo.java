package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo {
    public static void main(String[] args) {
        // 1. 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Future<String>> futures = new ArrayList<>();
        for (Integer key : list) {
            // 2. 提交任务
            Future<String> future = executorService.submit(() -> {
                // 睡眠一秒，模仿处理过程
                //Thread.sleep(10000L);
                System.out.println("********" + Thread.currentThread().getName() + "结果" + key);
                return Thread.currentThread().getName() + "结果" + key;
            });
            futures.add(future);
        }

        // 3. 获取结果
        for (Future<String> future : futures) {
            try {
                String result = future.get();
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
