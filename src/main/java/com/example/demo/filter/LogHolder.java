package com.example.demo.filter;

import java.util.HashMap;
import java.util.Map;
import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author cuixiaoxu
 */
public class LogHolder {
    public static final String MESSAGE = "message";
    public static final String PAYLOAD = "payload";
    private static final TransmittableThreadLocal<Map<String, String>> messageLocal = new TransmittableThreadLocal();

    public LogHolder() {
    }

    public static String getMessage(String key) {
        Map<String, String> map = messageLocal.get();
        return map == null ? null : map.get(key);
    }

    public static void setMessage(String key, String message) {
        Map<String, String> map = messageLocal.get();
        if (map == null) {
            map = new HashMap();
        }

        ((Map)map).put(key, message);
        messageLocal.set(map);
    }

    public static void remove(){
        messageLocal.remove();
    }
}
