package com.example.demo;

import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;

public class Test2 {
    public static void main(String[] args){
        /*int a=3;
        int b=2;
        System.out.println("a 和b 与的结果是："+(a|b));
        System.out.println("a 和b 与的结果-2是："+(a|b-2));
        int c= (a|b)-2;
        System.out.println("c结果-2是："+c);*/
        //DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
        //String localTime = df.format(LocalTime.now());
        //System.out.println(localTime);
        //List<String> targetGoodsNoList = new ArrayList<>();
        //List<String> list = Collections.emptyList();
        //targetGoodsNoList.addAll(list);
        //System.out.println(targetGoodsNoList);

        //LocalDateTime now = LocalDateTime.now();
        //Integer week = now.getDayOfWeek().getValue();
        //System.out.println(week);

        //LocalDate localDate = LocalDate.now();
        //LocalDateTime startTime = localDate.of(localDate.getYear(), 1, 1).atStartOfDay();
        //System.out.println(startTime);
        //String [] str = new String[]{"1","2"};
        //String strJson = JSON.toJSONString(str);
        //System.out.println(strJson);
        //List<String> list = JSON.parseArray(strJson,String.class);
        //System.out.println(String.join(",", list));
        //
        //Calendar calendar = Calendar.getInstance();
        //calendar.setTime(new Date());
        //calendar.set(12, calendar.get(12) - 0);
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String date =  df.format(calendar.getTime());
        //System.out.println(date);

        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        List<String> list2 = new ArrayList<>();
        //list2.add("1");
        //list2.add("2");
        //list2.add("3");
        boolean bool = list1.retainAll(list2);
        System.out.println(list1);
    }

}