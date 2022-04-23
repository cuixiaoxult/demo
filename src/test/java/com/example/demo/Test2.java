package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import org.apache.commons.lang.StringEscapeUtils;

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

//        List<String> list1 = new ArrayList<>();
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
        String tmp = "{\"type\":\"Commission withdrawal\"}";

        Map<String, String> extraInfoConfigMap = JSON.parseObject(tmp,LinkedHashMap.class, Feature.OrderedField);
        //String tmp2 ="[\n    {\n        "extra": "Commission Withdraw",\n        "title": "Commission",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/logo/subtitle/commissionwithdraw.png",\n        "extraInfo": "{\"Sender\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": "CASH_OUT_COMMISSION",\n        "flowType": [\n            "IN"\n        ],\n        "serviceType": "CASH_OUT"\n    },\n    {\n        "extra": "Commission Withdraw",\n        "title": "Commission",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/logo/subtitle/commissionwithdraw.png",\n        "extraInfo": "{\"Receiver\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": "CASH_OUT_COMMISSION",\n        "flowType": [\n            "OUT"\n        ],\n        "serviceType": "CASH_OUT"\n    },\n    {\n        "extra": "Deposit",\n        "title": "Deposit",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-cashin.png",\n        "extraInfo": "{\"Bank\": \"#traderFullName\"}",\n        "businessType": "DIRECT",\n        "flowType": [\n            "IN"\n        ],\n        "serviceType": "CASH_IN"\n    },\n    {\n        "extra": "Transfer",\n        "title": "Transfer",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-transfer.png",\n        "extraInfo": "{\"Sending Institution\": \"#traderFullName\",\"Sender\": \"#fromAccountIdentification\"}",\n        "businessType": "NFS",\n        "flowType": [\n            "IN"\n        ],\n        "serviceType": "CASH_IN"\n    },\n    {\n        "extra": "Transfer",\n        "title": "Transfer",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-transfer.png",\n        "extraInfo": "{\"Receiving Institution\": \"#institutionName\",\"Receiver\":\"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": "ACTransfer",\n        "flowType": [\n            "OUT"\n        ],\n        "serviceType": "AC_TRANSFER"\n    },\n    {\n        "extra": "Deposit",\n        "title": "Deposit",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-cashin.png",\n        "extraInfo": "{\"Sender\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "IN"\n        ],\n        "serviceType": "CASH_IN"\n    },\n    {\n        "extra": "Deposit",\n        "title": "Deposit",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-cashout.png",\n        "extraInfo": "{\"Receiver\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "OUT"\n        ],\n        "serviceType": "CASH_IN"\n    },\n    {\n        "extra": "Withdraw",\n        "title": "Withdraw",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-cashin.png",\n        "extraInfo": "{\"Sender\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "IN"\n        ],\n        "serviceType": "CASH_OUT"\n    },\n    {\n        "extra": "Withdraw",\n        "title": "Withdraw",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-cashout.png",\n        "extraInfo": "{\"Receiver\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "OUT"\n        ],\n        "serviceType": "CASH_OUT"\n    },\n    {\n        "extra": "Transfer",\n        "title": "Transfer",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-transfer.png",\n        "extraInfo": "{\"Sender\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "IN"\n        ],\n        "serviceType": "AA_TRANSFER"\n    },\n    {\n        "extra": "Transfer",\n        "title": "Transfer",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-transfer.png",\n        "extraInfo": "{\"Receiver\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "OUT"\n        ],\n        "serviceType": "AA_TRANSFER"\n    },\n    {\n        "extra": "Transfer",\n        "title": "Transfer",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-transfer.png",\n        "extraInfo": "{\"Sender\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "IN"\n        ],\n        "serviceType": "AC_TRANSFER"\n    },\n    {\n        "extra": "Transfer",\n        "title": "Transfer",\n        "iconUrl": "https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/transactions/transactions-transfer.png",\n        "extraInfo": "{\"Receiver\": \"#counterpartyFullName+'\\n'+#counterpartyMobile\"}",\n        "businessType": null,\n        "flowType": [\n            "OUT"\n        ],\n        "serviceType": "AC_TRANSFER"\n    },\n  {\n        "extra":"Airtime",\n        "title":"Airtime",\n        "iconUrl":"https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/payment/payment-airtime.png",\n        "extraInfo":"{\"Service Provider\": \"#Airtime_Provider\",\\n \"Mobile Number\": \"#Mobile_Number\"}",\n        "businessType":"ACQ_AIRTIME",\n        "flowType":[\n            "OUT"\n        ],\n        "serviceType":"ACQUIRING"\n    },\n    {\n        "extra":"TV",\n        "title":"TV",\n        "iconUrl":"https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/payment/payment-tv.png",\n        "extraInfo":"{\"Service Provider\": \"#TV_Provider\",\\n \"Account Number\": \"#Account_Number\"}",\n        "businessType":"ACQ_TV",\n        "flowType":[\n            "OUT"\n        ],\n        "serviceType":"ACQUIRING"\n    },\n    {\n        "extra":"Electricity",\n        "title":"Electricity",\n        "iconUrl":"https://owallet-prod-public.oss-eu-west-1.aliyuncs.com/images/app/zambia/payment/payment-electricity.png",\n        "extraInfo":"{\"Service Provider\": \"#Electricity_Provider\",\\n \"Meter Number\": \"#Meter_Number\"}",\n        "businessType":"ACQ_ELECTRICITY",\n        "flowType":[\n            "OUT"\n        ],\n        "serviceType":"ACQUIRING"\n    }\n]";

        //String tmp = StringEscapeUtils.unescapeJavaScript(s);
        System.out.println("tmp:" + tmp);

        //Map<String, String> extraInfoConfigMap = JSON.parseObject(tmp,LinkedHashMap.class, Feature.OrderedField);
        System.out.println(extraInfoConfigMap);
    }

}