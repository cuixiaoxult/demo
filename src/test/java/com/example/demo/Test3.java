package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

//        String str = "+2348057989581";
//        System.out.println(str.length());

//        int saleManCount = 3;
//        for (int i = 0; i < 6; i++){
//            int index = i % saleManCount;
//            System.out.println(index);
//        }
//        Map<String,String> map = new HashMap<>();
//        map.put(null,"123");
//        map.put("","1234");
//        System.out.println(map);
        //替换字符
//        String str = "\"Hello, world!\"";
//        str = str.trim().replace("\"", "");
//        System.out.println(str);

//        BigDecimal total = new BigDecimal(3);
//        BigDecimal ratio = new BigDecimal("0.6");
//        long size = BigDecimal.ONE.subtract(ratio).multiply(total).setScale(0, RoundingMode.HALF_DOWN).longValue();
//        System.out.println(size);

//        int a = 237;
//        int b = 10;
//        System.out.println(a/b);

//        String params = "userId:662705964272582656老循环贷产品List接口-经过账期过滤后无产品,直接返回空列表,账期:30,60,90,120";
//        String paramsStr = StringUtils.trimToEmpty(params);
//        StringBuilder stb = new StringBuilder();
//        String[] contentParts =paramsStr.split("\n");
//        for(String contentPart : contentParts){
//            stb.append(contentPart).append("\\n");
//        }
//        paramsStr = stb.toString();
//        String tem = "EM【生产环境】%s";
//        String content = String.format("L0033" + " " + tem.replaceAll("&", "\\n"), paramsStr.split(",", -1)) + "\\n" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSSZ");
//        System.out.println(content);

//        BigDecimal a=new BigDecimal(12);
//        int b=a.intValue();
//        System.out.println(b);

//        String a = "abc,dec";
//        String[] arr = a.split(",",1);
//        System.out.println(arr);

//        String k1 = "招标人#投标人#设计单位#施工单位";
//        String[] k = k1.split("#",-1);//需要转义
//        System.out.println(k[0]);
//        System.out.println(k[1]);
        //String input = "abc123def456xyz789";
//        String pattern = "\\d+$";  // 匹配最后连续数字的正则表达式
//        Pattern regexPattern = Pattern.compile(pattern);
//        Matcher matcher = regexPattern.matcher(input);
//
//        if (matcher.find()) {
//            String lastDigits = matcher.group();
//            System.out.println("最后连续数字为：" + lastDigits);
//        } else {
//            System.out.println("字符串中没有最后连续数字。");
//        }
        String source = "abc123def456xyz789?";
        String NUM_SUFFIX_REGEX = "^.*\\d$";
        Pattern NUM_PREFIX_PATTERN = Pattern.compile("(^\\d+)(.*)$");
        String reverse = StringUtils.reverse(source);

        Matcher matcher = NUM_PREFIX_PATTERN.matcher(reverse);
        if (!matcher.find()) {

        }
        String numStr = matcher.group(1);
        reverse = reverse.replaceFirst(numStr, StringUtils.EMPTY);

        String str = StringUtils.reverse(reverse);
        System.out.println(str);

    }
}
