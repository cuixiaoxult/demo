package com.example.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Long t1 = 0L;
//        for (int i=0;i<10;i++){
//            Long start = System.currentTimeMillis();
//            CompletableFutureTest completableFutureTest = new CompletableFutureTest();
//            completableFutureTest.getSupplyAsyncSingle();
//            long tt = System.currentTimeMillis() - start;
//            t1 = t1+tt;
//            //System.out.println("总耗时：" + (System.currentTimeMillis() - start)+"ms");
//        }
//        System.out.println("总耗时t1：" + t1+"ms");
//        System.out.println("*****************************");
//        Long t2 = 0L;
//        for (int i=0;i<10;i++){
//            Long start = System.currentTimeMillis();
//            CompletableFutureTest completableFutureTest = new CompletableFutureTest();
//            completableFutureTest.getThenCombine();
//            long tt = System.currentTimeMillis() - start;
//            t2 = t2+tt;
//        }
//        System.out.println("总耗时t2：" + t2+"ms");
        //Long start = System.currentTimeMillis();
        CompletableFutureTest completableFutureTest = new CompletableFutureTest();
        //String result = completableFutureTest.getSupplyAsyncSingle();
        //String result = completableFutureTest.getThenCombine();
//        System.out.println("cf1结果->" + result+":"+(System.currentTimeMillis() - start)+"ms");
//        //System.out.println("耗时：" + (System.currentTimeMillis() - start)+"ms");
//        //等待任务执行完成
////        System.out.println("cf1结果->" + cf1.get()+":"+(System.currentTimeMillis() - start)+"ms");
////        System.out.println("cf2结果->" + cf2.get()+":"+(System.currentTimeMillis() - start)+"ms");
////        System.out.println("cf3结果->" + cf3.get()+":"+(System.currentTimeMillis() - start)+"ms");
        //System.out.println("总耗时：" + (System.currentTimeMillis() - start)+"ms");
        //CompletableFuture<Integer> future= completableFutureTest.getCompletableFuture();
//        Integer s1 = future1.get();
//        System.out.println("总耗时1 s1："+s1 + (System.currentTimeMillis() - start)+"ms");
        completableFutureTest.thenCombine();

    }

    /*************************************1创建异步任务**************************************/

    /**
     * 1.supplyAsync是创建带有返回值的异步任务
     * 默认线程池（ForkJoinPool.commonPool()）的方法
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void supplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf do something....");
            return "result";
        });
        //等待任务执行完成
        System.out.println("结果->" + cf.get());
    }

    /**
     * 1.1自定义线程池的重载方法
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void supplyAsyncAndExecutor() throws ExecutionException, InterruptedException {
        // 自定义线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf do something....");
            return "result";
        }, executorService);
        //等待子任务执行完成
        System.out.println("结果->" + cf.get());
    }

    /**
     * 2.runAsync是创建带有返回值的异步任务
     * 默认线程池（ForkJoinPool.commonPool()）的方法
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void runAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() ->
                System.out.println(Thread.currentThread() + " cf do something....")
        );
        //等待任务执行完成
        System.out.println("结果->" + cf.get());
    }

    /**
     * 2.1自定义线程池的重载方法
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void runAsyncAndExecutor() throws ExecutionException, InterruptedException {
        // 自定义线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out.println("do something....");
        }, executorService);

        //等待任务执行完成
        System.out.println("结果->" + cf.get());
    }

    /*************************************2异步回调处理**************************************/

    /**
     * 1.thenApply和thenApplyAsync
     * thenApply 表示某个任务执行完成后执行的动作，即回调方法，会将该任务的执行结果即方法返回值作为入参传递到回调方法中，带有返回值。
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void thenApplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "thenApplyAsync cf1 do something....");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.thenApplyAsync((result) -> {
            System.out.println(Thread.currentThread().getName() + "thenApplyAsync cf2 do something....");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            result += 2;
            return result;
        });
        //等待任务1执行完成
        System.out.println("thenApplyAsync cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("thenApplyAsync cf2结果->" + cf2.get());
    }

    /**
     * 2.thenAccept和thenAcceptAsync
     * thenAccep表示某个任务执行完成后执行的动作，即回调方法，会将该任务的执行结果即方法返回值作为入参传递到回调方法中，无返回值。
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void thenAccept() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Void> cf2 = cf1.thenAcceptAsync((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
        });

        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
    }

    /**
     * 3.thenRun和thenRunAsync
     * thenRun表示某个任务执行完成后执行的动作，即回调方法，无入参，无返回值
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void thenRun() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Void> cf2 = cf1.thenRunAsync(() -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
        });

        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
    }

    /**
     * 4.whenComplete和whenCompleteAsync
     * whenComplete是当某个任务执行完成后执行的回调方法，会将执行结果或者执行期间抛出的异常传递给回调方法，如果是正常执行则异常为null，回调方法对应的CompletableFuture的result和该任务一致，如果该任务正常执行，则get方法返回执行结果，如果是执行异常，则get方法抛出异常。
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void whenComplete() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " cf1 do something....");
            //int a = 1/0;
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.whenCompleteAsync((result, e) -> {
            result = result + 2;
            System.out.println("上个任务结果：" + result);
            System.out.println("上个任务抛出异常：" + e);
            System.out.println(Thread.currentThread().getName() + " cf2 do something....");
        });

//        //等待任务1执行完成
//        System.out.println("cf1结果->" + cf1.get());
//        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
    }

    /**
     * 5.handle和handleAsync
     * 跟whenComplete基本一致，区别在于handle的回调方法有返回值。
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void handle() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " cf1 do something....");
            // int a = 1/0;
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.handleAsync((result, e) -> {
            System.out.println(Thread.currentThread().getName() + " cf2 do something....");
            System.out.println("上个任务结果：" + result);
            System.out.println("上个任务抛出异常：" + e);
            return result + 2;
        });
        System.out.println("aaaa");
        //等待任务2执行完成
        System.out.println("cf2结果->" + Thread.currentThread() + cf2.get());
    }

    /*************************************3多任务组合处理**************************************/

    /**
     * 1.thenCombine、thenAcceptBoth 和runAfterBoth
     * 这三个方法都是将两个CompletableFuture组合起来处理，只有两个任务都正常完成时，才进行下阶段任务。
     * 区别：thenCombine会将两个任务的执行结果作为所提供函数的参数，且该方法有返回值；thenAcceptBoth同样将两个任务的执行结果作为方法入参，但是无返回值；runAfterBoth没有入参，也没有返回值。注意两个任务中只要有一个执行异常，则将该异常信息作为指定任务的执行结果。
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void thenCombine() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
//            try {
//                System.out.println(Thread.currentThread().getName() + " cf1 do something....");
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + " cf1 任务完成....");
            return 1;
        });

        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
//            try {
//                System.out.println(Thread.currentThread().getName() + " cf2 do something....");
//                Thread.sleep(30);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + " cf2 任务完成....");
            return 2;
        });

        CompletableFuture<Integer> cf3 = cf1.thenCombine(cf2, (a, b) -> {
            System.out.println(Thread.currentThread().getName() + " cf3 do something....");
            return a + b;
        });
        System.out.println("zhuliucheng");
        System.out.println("cf3结果->" + Thread.currentThread().getName() + cf3.get());
    }

    public void thenAcceptBoth() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            return 2;
        });

        CompletableFuture<Void> cf3 = cf1.thenAcceptBoth(cf2, (a, b) -> {
            System.out.println(Thread.currentThread() + " cf3 do something....");
            System.out.println(a + b);
        });

        System.out.println("cf3结果->" + cf3.get());
    }

    public void runAfterBoth() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            return 2;
        });

        CompletableFuture<Void> cf3 = cf1.runAfterBoth(cf2, () -> {
            System.out.println(Thread.currentThread() + " cf3 do something....");
        });

        System.out.println("cf3结果->" + cf3.get());
    }


    /**
     * 2.applyToEither、acceptEither和runAfterEither
     * 这三个方法和上面一样也是将两个CompletableFuture组合起来处理，当有一个任务正常完成时，就会进行下阶段任务。
     * 区别：applyToEither会将已经完成任务的执行结果作为所提供函数的参数，且该方法有返回值；acceptEither同样将已经完成任务的执行结果作为方法入参，但是无返回值；runAfterEither没有入参，也没有返回值。
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void applyToEither() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " cf1 do something....");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " cf1 任务完成....");
            return "cf1 任务完成";
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " cf2 do something....");
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " cf2 任务完成....");
            return "cf2 任务完成";
        });

        CompletableFuture<String> cf3 = cf1.applyToEither(cf2, (result) -> {
            System.out.println("接收到" + result);
            System.out.println(Thread.currentThread().getName() + " cf3 do something....");
            return "cf3 任务完成";
        });
        System.out.println("cf3结果->" + Thread.currentThread().getName() + cf3.get());
    }


    /**
     * 3.allOf / anyOf
     * allOf：CompletableFuture是多个任务都执行完成后才会执行，只要有一个任务执行异常，则返回的CompletableFuture执行get方法时会抛出异常，如果都是正常执行，则get返回null。
     * anyOf ：CompletableFuture是多个任务返回最先执行完成的任务的结果。
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void allOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread() + " cf1 do something....");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cf1 任务完成");
            return "cf1 任务完成";
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread() + " cf2 do something....");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cf2 任务完成");
            return "cf2 任务完成";
        });

        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread() + " cf3 do something....");
                Thread.sleep(300);
                //int a = 1/0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cf3 任务完成");
            return "cf3 任务完成";
        });
        CompletableFuture<Void> cfAll = CompletableFuture.allOf(cf1, cf2, cf3);
        //CompletableFuture<Object> anyOf = CompletableFuture.anyOf(cf1, cf2, cf3);
        System.out.println("cfAll结果->" + cfAll.get());
    }









    public CompletableFuture<Integer> getCompletableFuture() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " getCompletableFuture do something....");
            int a = 1 / 0;
            return a;
        });
    }

    public String getSupplyAsyncSingle() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            //System.out.println(Thread.currentThread() + " cf1 do something....");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "result1";
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            //System.out.println(Thread.currentThread() + " cf2 do something....");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "result2";
        });
        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> {
            //System.out.println(Thread.currentThread() + " cf3 do something....");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "result3";
        });
        return sum(cf1.get(), cf2.get(), cf3.get());
    }

    public String getThenCombine() throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            //System.out.println(Thread.currentThread() + " cf1 do something....");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "result1";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            //System.out.println(Thread.currentThread() + " cf2 do something....");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "result2";
        }), CompletableFutureTest::sum).thenCombine(CompletableFuture.supplyAsync(() -> {
            //System.out.println(Thread.currentThread() + " cf3 do something....");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "result3";
        }), String::concat).get();
    }

    public static String sum(String a, String b) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return a.concat(b);
    }

    public static String sum(String a, String b, String c) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return a.concat(b).concat(c);
    }

}
