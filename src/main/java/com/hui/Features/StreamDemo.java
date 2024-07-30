package com.hui.Features;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("周杰伦");
        list.add("王力宏");
        list.add("陶喆");
        list.add("林俊杰");
        // 1.filter 过滤元素 例：筛选出带有“王”的字符串
        // filter() 方法接收的是一个 Predicate（Java 8 新增的一个函数式接口，接受一个输入参数返回一个布尔值结果）类型的参数，因此，我们可以直接将一个 Lambda 表达式传递给该方法
        Stream<String> stream = list.stream().filter(element -> element.contains("王"));
        // forEach() 方法接收的是一个 Consumer（Java 8 新增的一个函数式接口，接受一个输入参数并且无返回的操作）类型的参数
        // 类名 :: 方法名是 Java 8 引入的新语法，System.out 返回 PrintStream 类
        stream.forEach(System.out::println);


        // 2.map 映射  例：把 Stream<String> 的流转成一个 Stream<Integer> 的流 并输出
        // map() 方法接收的是一个 Function（Java 8 新增的一个函数式接口，接受一个输入参数 T，返回一个结果 R）类型的参数，此时参数 为 String 类的 length 方法
        Stream<Integer> streamMap = list.stream().map(String::length);
        streamMap.forEach(System.out::println);

        // 3.match 匹配
        // 3.1 anyMatch()，只要有一个元素匹配传入的条件，就返回 true。
        // 3.2 allMatch()，如果全部匹配，则返回 true；只要有一个元素不匹配传入的条件，就返回 false。
        // 3.3 noneMatch()，如果全部不匹配，则返回 true；只要有一个元素匹配传入的条件，就返回 false。
        boolean anyMatch = list.stream().anyMatch(element -> element.contains("喆"));
        boolean allMatch = list.stream().allMatch(element -> element.length() > 1);
        boolean noneMatch = list.stream().noneMatch(element -> element.endsWith("杰"));
        System.out.println("anyMatch:" + anyMatch + " allMatch:" + allMatch + " noneMatch:" + noneMatch);

        // 4.reduce 组合 主要作用是把 Stream 中的元素组合起来
        Integer[] ints = {0, 1, 2, 3};
        // int[] 不行
        List<Integer> intList = Arrays.asList(ints);
        // 只有一个参数 即运算规则
        Optional<Integer> optional = intList.stream().reduce((a, b) -> a + b);
        Optional<Integer> optional1 = intList.stream().reduce(Integer::sum);
        System.out.println(optional.orElse(0));
        System.out.println(optional1.orElse(0));
        // 两个参数， 起始值+运算规则 此时返回的类型和起始值类型一致
        int reduce = intList.stream().reduce(6, Integer::sum);
        System.out.println(reduce);

        // 5.collect 将流转换回集合/数组
        // Collectors 是一个收集器的工具类，内置了一系列收集器实现
        // 比如说 toList() 方法将元素收集到一个新的 java.util.List 中；
        // 比如说 toCollection() 方法将元素收集到一个新的 java.util.ArrayList 中；
        // 比如说 joining() 方法将元素收集到一个可以用分隔符指定的字符串中
        String[] strArray = list.stream().toArray(String[]::new);  // stream-->数组
        System.out.println(Arrays.toString(strArray));
        List<Integer> backList = list.stream().map(String::length).collect(Collectors.toList());
        System.out.println(backList);
        List<String>  strList = list.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(strList);
        String str = list.stream().collect(Collectors.joining(","));
        System.out.println(str);
    }
}
