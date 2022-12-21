package com.example.demo;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        OptionalTest test = new OptionalTest();
        Demo demo = new Demo();
        //demo.setDemo2();
        //test.testOptional(demo);









    }

//    public String testOptional(Demo demo) {
//        return Optional.ofNullable(demo).flatMap(Demo::getDemo2)
//                .flatMap(Demo.Demo2::getDemo3)
//                .map(Demo.Demo2.Demo3::getInfo)
//                .orElse("");
//    }

    public static class Demo{
        private Demo2 demo2;

        public Demo2 getDemo2() {
            return demo2;
        }

        public void setDemo2(Demo2 demo2) {
            this.demo2 = demo2;
        }

        public class Demo2{
            private Demo3 demo3;

            public Demo3 getDemo3() {
                return demo3;
            }

            public void setDemo3(Demo3 demo3) {
                this.demo3 = demo3;
            }

            public class Demo3{
                private Info info;

                public Info getInfo() {
                    return info;
                }

                public void setInfo(Info info) {
                    this.info = info;
                }

                public class Info{

                }
            }
        }

    }
}