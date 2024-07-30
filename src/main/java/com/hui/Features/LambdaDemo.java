package com.hui.Features;

import java.util.concurrent.atomic.AtomicInteger;

public class LambdaDemo {
     static int limit1 = 10;


    public static void main(String[] args) {
        final AtomicInteger limit = new AtomicInteger(10);
        final int [] limits = {10};
        Runnable r = () -> {
            int li = 5; // 由于limit已经被定义过，故会报错
            // limit = 6;// 重新对limit赋值 也会报错；因为Lambda 表达式中使用的变量必须是 final 的
            // 解决方法1：把 limit 变量声明为 static， 此时limit在main方法外部
            limit1 = 6;
            // 解决方法2：把 limit 变量声明为 AtomicInteger
            // AtomicInteger 可以确保 int 值的修改是原子性的，可以使用 set() 方法设置一个新的 int 值，get() 方法获取当前的 int 值
            limit.set(20);
            // 解决方法3：使用数组  在声明数组的时候设置为 final，但更改 int 的值时却修改的是数组的一个元素
            limits[0] = 5;
        };

        new LambdaDemo().work();
    }

    public void work(){
        // this 为 main() 方法中通过 new 关键字创建的 LambdaDemo 对象
        System.out.printf("this = %s%n", this);

        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                // this 为 work() 方法中通过 new 关键字创建的 Runnable 对象
                System.out.printf("this = %s%n", this);
            }
        };

        new Thread(r).start();
        // Lambda 表达式中的 this 关键字 和其所在的类实例相同  和 1）中的相同  LambdaDemo 对象
        new Thread(() -> System.out.printf("this = %s%n", this)).start();
    }
}
