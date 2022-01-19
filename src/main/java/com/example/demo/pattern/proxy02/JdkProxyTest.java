package com.example.demo.pattern.proxy02;

import com.example.demo.pattern.proxy01.UserDao;
import com.example.demo.pattern.proxy01.UserDaoImpl;

/**
 * @author cui
 * @date 2021年10月09日 16:15
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        //实例化目标对象
        UserDao userDao = new UserDaoImpl();
        //实例化InvocationHandler
        MyInvocationHandler dynamicProxyHandler = new MyInvocationHandler(userDao);
        //根据目标对象生成代理对象
        UserDao proxy = (UserDao) dynamicProxyHandler.getProxy();
        //调用代理对象的方法
        proxy.save();
    }
}