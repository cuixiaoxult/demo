package com.example.demo.lambda;

/**
 * Lambda 语法形式为 () -> {}，其中 () 用来描述参数列表，{} 用来描述方法体，-> 为 lambda 运算符 ，读作 (goes to)
 */
public class LambdaDemo {

    public static void main(String[] args) {

        //无参无返回
        NoReturnNoParam noReturnNoParam = () -> System.out.println("NoReturnNoParam");
        noReturnNoParam.method();

        //一个参数无返回
        NoReturnOneParam noReturnOneParam = (int a) -> {
            System.out.println("NoReturnOneParam param:" + a);
        };
        noReturnOneParam.method(6);
//
//        //多个参数无返回
//        NoReturnMultiParam noReturnMultiParam = (int a, int b) -> {
//            System.out.println("NoReturnMultiParam param:" + "{" + a +"," + + b +"}");
//        };
//        noReturnMultiParam.method(6, 8);
//
//        //无参有返回值
//        ReturnNoParam returnNoParam = () -> {
//            System.out.print("ReturnNoParam");
//            return 1;
//        };
//
//        int res = returnNoParam.method();
//        System.out.println("return:" + res);
//
//        //一个参数有返回值
//        ReturnOneParam returnOneParam = (int a) -> {
//            System.out.println("ReturnOneParam param:" + a);
//            return 1;
//        };
//
//        int res2 = returnOneParam.method(6);
//        System.out.println("return:" + res2);
//
//        //多个参数有返回值
//        ReturnMultiParam returnMultiParam = (int a, int b) -> {
//            System.out.println("ReturnMultiParam param:" + "{" + a + "," + b +"}");
//            return 1;
//        };
//
//        int res3 = returnMultiParam.method(6, 8);
//        System.out.println("return:" + res3);
    }
}
