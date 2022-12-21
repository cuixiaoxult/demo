package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.example.demo.util.ReceiptStrUtils;
import com.example.demo.vo.AccountDetail;
import org.apache.commons.lang.StringEscapeUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
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

        //List<String> list1 = new ArrayList<>();
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//        List<String> list2 = new ArrayList<>();
//        //list2.add("1");
//        //list2.add("2");
//        //list2.add("3");
//        boolean bool = list1.retainAll(list2);
//        System.out.println(list1);

        //String s = "{\"Service Provider\": \"#Airtime_Provider+'\\n'+#Mobile Number+'\\n': \"#Mobile_Number\"}";
        //String ss= "{\\"Receiver\\": \\"#counterpartyFullName+\'\\\\n\'+#counterpartyMobile\\"}"
        //String tmp = "{\"type\":\"Commission withdrawal\"}";

        //Map<String, String> extraInfoConfigMap = JSON.parseObject(tmp, LinkedHashMap.class, Feature.OrderedField);
        //String tmp2 ="[\n    {\n        "extra": "Commission Withdraw",\n        "title": "Commission",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/logo/subtitle/commissionwithdraw.png",\n        "extraInfo": "{\"Sender\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": "CASH_OUT_COMMISSION",\n        "flowType": [\n            "IN"\n        ],\n        "serviceType": "CASH_OUT"\n    },\n    {\n        "extra": "Commission Withdraw",\n        "title": "Commission",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/logo/subtitle/commissionwithdraw.png",\n        "extraInfo": "{\"Receiver\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": "CASH_OUT_COMMISSION",\n        "flowType": [\n            "OUT"\n        ],\n        "serviceType": "CASH_OUT"\n    },\n    {\n        "extra": "Deposit",\n        "title": "Deposit",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-cashin.png",\n        "extraInfo": "{\"Bank\": \"#traderFullName\"}",\n        "businessType": "DIRECT",\n        "flowType": [\n            "IN"\n        ],\n        "serviceType": "CASH_IN"\n    },\n    {\n        "extra": "Transfer",\n        "title": "Transfer",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-transfer.png",\n        "extraInfo": "{\"Sending Institution\": \"#traderFullName\",\"Sender\": \"#fromAccountIdentification\"}",\n        "businessType": "NFS",\n        "flowType": [\n            "IN"\n        ],\n        "serviceType": "CASH_IN"\n    },\n    {\n        "extra": "Transfer",\n        "title": "Transfer",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-transfer.png",\n        "extraInfo": "{\"Receiving Institution\": \"#institutionName\",\"Receiver\":\"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": "ACTransfer",\n        "flowType": [\n            "OUT"\n        ],\n        "serviceType": "AC_TRANSFER"\n    },\n    {\n        "extra": "Deposit",\n        "title": "Deposit",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-cashin.png",\n        "extraInfo": "{\"Sender\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "IN"\n        ],\n        "serviceType": "CASH_IN"\n    },\n    {\n        "extra": "Deposit",\n        "title": "Deposit",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-cashout.png",\n        "extraInfo": "{\"Receiver\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "OUT"\n        ],\n        "serviceType": "CASH_IN"\n    },\n    {\n        "extra": "Withdraw",\n        "title": "Withdraw",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-cashin.png",\n        "extraInfo": "{\"Sender\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "IN"\n        ],\n        "serviceType": "CASH_OUT"\n    },\n    {\n        "extra": "Withdraw",\n        "title": "Withdraw",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-cashout.png",\n        "extraInfo": "{\"Receiver\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "OUT"\n        ],\n        "serviceType": "CASH_OUT"\n    },\n    {\n        "extra": "Transfer",\n        "title": "Transfer",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-transfer.png",\n        "extraInfo": "{\"Sender\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "IN"\n        ],\n        "serviceType": "AA_TRANSFER"\n    },\n    {\n        "extra": "Transfer",\n        "title": "Transfer",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-transfer.png",\n        "extraInfo": "{\"Receiver\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "OUT"\n        ],\n        "serviceType": "AA_TRANSFER"\n    },\n    {\n        "extra": "Transfer",\n        "title": "Transfer",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-transfer.png",\n        "extraInfo": "{\"Sender\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "IN"\n        ],\n        "serviceType": "AC_TRANSFER"\n    },\n    {\n        "extra": "Transfer",\n        "title": "Transfer",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-transfer.png",\n        "extraInfo": "{\"Receiver\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "OUT"\n        ],\n        "serviceType": "AC_TRANSFER"\n    },\n  {\n        "extra":"Airtime",\n        "title":"Airtime",\n        "iconUrl":"https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/payment/payment-airtime.png",\n        "extraInfo":"{\"Service Provider\": \"#Airtime_Provider\",\\n \"Mobile Number\": \"#Mobile_Number\"}",\n        "businessType":"ACQ_AIRTIME",\n        "flowType":[\n            "OUT"\n        ],\n        "serviceType":"ACQUIRING"\n    },\n    {\n        "extra":"TV",\n        "title":"TV",\n        "iconUrl":"https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/payment/payment-tv.png",\n        "extraInfo":"{\"Service Provider\": \"#TV_Provider\",\\n \"Account Number\": \"#Account_Number\"}",\n        "businessType":"ACQ_TV",\n        "flowType":[\n            "OUT"\n        ],\n        "serviceType":"ACQUIRING"\n    },\n    {\n        "extra":"Electricity",\n        "title":"Electricity",\n        "iconUrl":"https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/payment/payment-electricity.png",\n        "extraInfo":"{\"Service Provider\": \"#Electricity_Provider\",\\n \"Meter Number\": \"#Meter_Number\"}",\n        "businessType":"ACQ_ELECTRICITY",\n        "flowType":[\n            "OUT"\n        ],\n        "serviceType":"ACQUIRING"\n    }\n]";

        //String tmp = StringEscapeUtils.unescapeJavaScript(s);
        //System.out.println("tmp:" + tmp);

        //Map<String, String> extraInfoConfigMap = JSON.parseObject(tmp,LinkedHashMap.class, Feature.OrderedField);
        //System.out.println(extraInfoConfigMap);

//        Map<String, String> map = new ConcurrentHashMap();
//        map.put("asd", "123");
//        map.put("asdf", "1234");
//        System.out.println(map);
//        String mobile = "+1512345";
//        String mo = mobilePrefix(mobile);
//        System.out.println(mo);

//        List<String> list = new ArrayList<>();
//        list.add("otp");
//        list.add("otp1");
//        list.add("otp2");
//        int index = list.indexOf("otp2");
//        boolean flag = index == list.size() - 1;
//        System.out.println(flag);
//        String str = "abc";
//        String stb = str.concat("");
//        System.out.println(getCurrentShortDateStr());
        //System.out.println(generateRequestID("123456",999));
//        String monoAccountInformationData = "{\"meta\":{\"data_status\":\"AVAILABLE\",\"auth_method\":\"mobile_banking\"},\"account\":{\"_id\":\"631839d65cb4d422e2dadf06\",\"institution\":{\"name\":\"GTBank\",\"bankCode\":\"058\",\"type\":\"PERSONAL_BANKING\"},\"name\":\"MICHAEL BENJAMIN CHIDUBEM\",\"accountNumber\":\"0151544265\",\"type\":\"SAVINGS ACCOUNT\",\"balance\":12189981,\"currency\":\"NGN\",\"bvn\":\"9627\"}}";
//        AccountDetail accountDetail = JSONObject.parseObject(monoAccountInformationData, AccountDetail.class);

//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        List<Integer> ids = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            ids.add(i);
//        }
//        for (int i = 0; i < 100; i++) {
//            List<Integer> temp = ids.stream().limit(5L * i + 5L).skip(5L * i).collect(Collectors.toList());
//            if (temp.isEmpty()) {
//                break;
//            }
//            CountDownLatch latch = new CountDownLatch(5);
//            for (Integer integer : temp) {
//                executorService.submit(() -> {
//                    System.out.println("start：" + Thread.currentThread().getName()+"***"+integer);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println("end：" + Thread.currentThread().getName()+"***"+integer);
//                    latch.countDown();
//                });
//            }
//            try {
//                latch.await();
//            } catch (InterruptedException e) {
//            }
//            System.out.println("¥¥¥¥：" + Thread.currentThread().getName()+"***"+i);
//        }
//        System.out.println("线程结束：" + Thread.currentThread().getName());

//        String periodsAmountIntervalStr1 = "{\"22\":[2000,56000],\"57\":[24000,154000]}";
//        String periodsAmountIntervalStr = "\"{\\\"22\\\": [2000, 56000], \\\"57\\\": [24000, 154000]}\"";
//       Map<String,List<Integer>> periodsAmountInterval = JSON.parseObject(periodsAmountIntervalStr1,Map.class);
//        System.out.println(periodsAmountInterval);

//        int a = 9;
//        int b = 10;
//        int c = a/b;
//        System.out.println(c);

        Double dou = new Double(1.1);
        BigDecimal bigDecimal = new BigDecimal(dou);
        System.out.println(bigDecimal);
        System.out.println("******************");
        Long lon = 10000L;
        BigDecimal l = new BigDecimal(lon);
        System.out.println(l);

    }

    public static String mobilePrefix(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return mobile;
        }
        if (mobile.startsWith("+15")) {
            return mobile;
        }
        return "+15".concat(mobile);
    }

    public static String getCurrentShortDateStr() {
        DateTimeFormatter SHORT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        return LocalDateTime.now().format(SHORT_DATE_FORMATTER);
    }

    public static String generateRequestID(String bankCode, Integer id) {
        String ymdhmsStr = getCurrentShortDateStr();
        String serId = ReceiptStrUtils.completeLeftStr('0', 12, String.valueOf(id));
        return String.format("%s%s%s", bankCode, ymdhmsStr, serId);
    }

}