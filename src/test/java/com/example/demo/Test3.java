package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.impl.StoreGoodsRecordServiceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test3 {

    public Function<String, Object> setValue(String key){
        return t -> key + "value";
    }

    public static void main(String[] args) {
//        Test3 service = new Test3();
//        String id = "ok";
//        Object b= service.setValue(id).apply(id);
//        String id = "ok";
//        JSONObject map = new JSONObject();
//        map.put("applyNo","12837");
//        map.put("userId","815998614240231424");
//        map.put("score","100");
//        map.put("applyDt","20230302093652");
//
//        ArrayList<Map<String, Object>> list = JSON.parseObject("[{\"name\":\"msg\",\"comment\":\"消息\",\"type\":\"long\"},{\"name\":\"msg\",\"comment\":\"消息\",\"type\":\"long\"}]", ArrayList.class);
//        System.out.println(list);
//        // Object value = cache.get(id, t -> setValue(id).apply(id));
//        String a = "10.02";
//        long l = new BigDecimal(a).setScale(0, RoundingMode.UP).longValue();
//        System.out.println(l);
//        int i = 0;
//        int a = ++i;
//        System.out.println("a的值是:"+a);
//        System.out.println("i的值是:"+i);
//        for (int i = 0; i < 3; i++) {
//            System.out.println("i的值是:"+i);
//        }
        //System.out.println(Arrays.stream("56".split("\\|")).map(Integer::valueOf).collect(Collectors.toList()));

        String str = "+2348057989581";
        System.out.println(str.length());
    }
}
