package com.example.demo.util;

/**
 * @author cuixiaoxu
 */
public class ReceiptStrUtils {
    public ReceiptStrUtils() {
    }

    public static String rightSubStr(String s, int index) {
        if (s.length() < index) {
            index = s.length();
        }

        return s.substring(s.length() - index, s.length());
    }

    public static String completeLeftStr(char c, int num, String inStr) {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= num; ++i) {
            sb.append(c);
        }

        return rightSubStr(sb.append(inStr).toString(), num);
    }

    public static String toAcci(String inStr) {
        String s = inStr.toUpperCase();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
