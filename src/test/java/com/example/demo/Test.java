/*
package com.example.demo;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //System.out.println(3);
        */
/*List<Order> list = new ArrayList<>();
        List<Order> list1 = new ArrayList<>();
        Order order = new Order();
        order.setId(5);
        order.setType(110);
        order.setOrderName("za");
        order.setOrderNo("123456");
        list.add(order);
        Order order1 = new Order();
        order1.setId(5);
        order1.setType(5);
        order1.setOrderName("bc");
        order1.setOrderNo("123456");
        list.add(order1);
        Order order2 = new Order();
        order2.setId(3);
        order2.setType(9);
        order2.setOrderName("ac");
        order2.setOrderNo("123456");
        list.add(order2);
        Order order3 = new Order();
        order3.setId(5);
        order3.setType(5);
        order3.setOrderName("bc");
        order3.setOrderNo("123456");
        list1.add(order3);
        Order order4 = new Order();
        order4.setId(5);
        order4.setType(6);
        order4.setOrderName("za");
        order4.setOrderNo("123456");
        list1.add(order4);

        List<Order> result = list.stream().filter(t->list1.stream().anyMatch(t2->t2.getOrderName().equals(t.getOrderName()) && t2.getOrderNo().equals(t.getOrderNo()))).collect(Collectors.toList());

        List<Integer> ids = list.stream().filter(t->list1.stream().anyMatch(t2->t2.getOrderName().equals(t.getOrderName()) && t2.getOrderNo().equals(t.getOrderNo()))).map(Order::getId).distinct().collect(Collectors.toList());

        //另参考https://blog.csdn.net/Draymond_feng/article/details/108304165
        //去重
        System.out.println("=====>同时根据photographerName和deviceCode两个属性进行去重 start");

        ArrayList<Order> distinctByNameAndCode = list.stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(userOrder -> userOrder.getOrderNo() + userOrder.getOrderName()))),
                                ArrayList::new
                        )
                );
        distinctByNameAndCode.forEach(System.out::println);*//*


        System.out.println("=====>同时根据photographerName和deviceCode两个属性进行去重 end");

        */
/*Map<Integer, List<Order>> map = list.stream().collect(Collectors.groupingBy(Order::getType));
        map.forEach((key,value)->{
            if (CollectionUtils.isEmpty(value)) {
                return;
            }
            System.out.println(value);
        });*//*

        */
/*List<Order> orders = list.stream().sorted(Comparator.comparing(Order::getOrderName,String.CASE_INSENSITIVE_ORDER)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(orders));
        System.out.println("***************华丽丽的分割线****************");
        List<Order> orders1 = list.stream().sorted(Comparator.comparing(Order::getOrderName,String.CASE_INSENSITIVE_ORDER)).skip(0).limit(2).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(orders1));*//*

        List<Integer> cat = new ArrayList<>();
        cat.add(9);
        cat.add(12);
        cat.add(14);
        String categoryCode = String.format("%s#", StringUtils.join(cat, "#"));
        //String categoryCode = StringUtils.join(cat, "#");
        System.out.println(categoryCode);
        System.out.println("***************aaa****************");
        List<String> vendorNos = new ArrayList<>();
        vendorNos.add("a");
        vendorNos.add("b");
        vendorNos.add("c");
        String vendorNosStr = JSON.toJSONString(vendorNos);
        System.out.println(vendorNosStr);
        List<String> vendorNosList = JSONArray.parseArray(vendorNosStr,String.class);
        System.out.println(vendorNosList);

        String strTest = "崔晓旭";
        strTest = URLEncoder.encode(strTest, "UTF-8");//转码
        System.out.println("encode:"+strTest);
        strTest = URLDecoder.decode(strTest,"UTF-8");//解码
        System.out.println("decode:"+strTest);

        System.out.println("***************bbbb***************");
        int flag = 0;
        Integer operationType = flag == 0 ? 3 : 1;
        System.out.println("operationType:"+operationType);

        */
/*List<StoreGroupInfo> storeGroupInfoList =  storeGroupInfos.stream().filter(item -> v.stream().map(e -> e.getStoreGroupTypeNo() + "|" + e.getStoreGroupNo())
                .collect(Collectors.toList()).contains(item.getStoreGroupTypeNo() + "|" + item.getStoreGroupNo())).collect(Collectors.toList());
*//*


        //List<TransferWarehouseO2ODetailDto> newTransfer = transferWarehouseO2ODetailDtoList.stream().filter(m -> !wlTransferWarehouseDList.stream().map(d -> d.getProviderPackId()).collect(Collectors.toList()).contains(m.getProviderPackId())).collect(Collectors.toList());

        final String[] names = {"Zebe", "Hebe", "Hebe","Mary", "July", "David"};
        Stream<String> stream1 = Stream.of(names);
        Stream<String> stream2 = Stream.of(names);
        Stream<String> stream3 = Stream.of(names);
        // 拼接成 [x, y, z] 形式
        String result1 = stream1.distinct().collect(Collectors.joining(", ", "[", "]"));
        // 拼接成 x | y | z 形式
        String result2 = stream2.collect(Collectors.joining(" | ", "", ""));
        // 拼接成 x -> y -> z] 形式
        String result3 = stream3.collect(Collectors.joining(" -> ", "", ""));
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

    }


}*/
