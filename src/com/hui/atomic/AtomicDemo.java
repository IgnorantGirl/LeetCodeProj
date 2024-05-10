package com.hui.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

    public static void main(String[] args) {
        AtomicInteger num = new AtomicInteger(0);
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(num.incrementAndGet() + " current:"+Thread.currentThread());
                }
            }).start();
        }
    }
}
