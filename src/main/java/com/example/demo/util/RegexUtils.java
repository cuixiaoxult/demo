package com.example.demo.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    /**
     * 填充模板值
     * @param tagerStr
     * @param param
     * @return
     */
    public static String getContent(String tagerStr, Map<String, Object> param) {
        Pattern pattern = Pattern.compile("\\{(.*?)}");
        if (param == null || param.size() == 0){
            return tagerStr;
        }
        try {
            Matcher matcher = pattern.matcher(tagerStr);
            while (matcher.find()) {
                String key = matcher.group();
                String keyclone = key.substring(1, key.length() - 1).trim();
                Object value = param.get(keyclone);
                if (value != null){
                    tagerStr = tagerStr.replace(key, value.toString());
                }
            }
        }catch (Exception e){
            return null;
        }
        return tagerStr;
    }

    /**
     * 校验是否数字
     * @param s
     * @return
     */
    public static boolean checkNumber(String s){
        Pattern p = Pattern.compile("\\d+");
        // 返回\d+
        System.out.println(p.pattern());
        // p.pattern()返回\d+， 这里为true，只有当全部满足则为true
        return Pattern.matches(p.pattern(), s);
    }


    public static String[] split(String s){
        Pattern p = Pattern.compile("[a-z]+");
        return p.split(s);
    }


    public static void main(String[] args) {
        String str = "This is your unique account number: (virtualName){virtualId} O pay Digital Services";
        Map<String, Object> param = new HashMap<>();
        param.put("amount",12594);
        param.put("amount",12594);
        param.put("dueDate","2023-07-05");
        param.put("virtualName","paycom/o pay");
        param.put("virtualId","5534261937");
        param.put("day",2);
//        String sms = getContent(str,param);
//        System.out.println(sms);

        String s = "2223b";
        //System.out.println(checkNumber(s));

        Arrays.stream(split("我爱java哈哈")).forEach(System.out::println);
    }
}
