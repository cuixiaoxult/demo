package com.example.demo.lambda;

/**
 * @FunctionalInterface 修饰函数式接口的，要求接口中的抽象方法只有一个。这个注解往往会和 lambda 表达式一起出现。
 * 该注解主要用于编译检查，没有实际含义
 */
@FunctionalInterface
public interface NoReturnNoParam {
    /**无参无返回值*/
    void method();
}
