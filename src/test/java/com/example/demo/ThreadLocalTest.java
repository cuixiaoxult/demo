package com.example.demo;

import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.util.List;

public class ThreadLocalTest {

    private static final int HASH_INCREMENT = 0x61c88647;

    private List<String> messages = Lists.newArrayList();

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();

        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        //magicHash(16); //初始大小16
        //magicHash(32); //扩容一倍
//        ThreadLocalTest.add("一枝花算不算浪漫");
//        System.out.println(holder.get().messages);
//        ThreadLocalTest.clear();
        /**********************************/
        Thread t = new Thread(()->test("abc",false));
        t.start();
        t.join();
        System.out.println("--gc后--");
        Thread t2 = new Thread(() -> test("def", true));
        t2.start();
        t2.join();
    }

    private static void magicHash(int size) {
        int hashCode = 0;
        for (int i = 0; i < size; i++) {
            hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            System.out.print((hashCode & (size - 1)) + " ");
        }
        System.out.println();
    }

    private static void test(String s, boolean isGC) {
        try {
            //new ThreadLocal<>().set(s);
            ThreadLocal<Object> threadLocal = new ThreadLocal<>();
            threadLocal.set(s);
            if (isGC) {
                System.gc();
            }
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object threadLocalMap = field.get(t);
            Class<?> tlmClass = threadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(threadLocalMap);
            for (Object o : arr) {
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.println(String.format("弱引用key:%s,值:%s", referenceField.get(o), valueField.get(o)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
