package com.hui.atomic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

    public static void main(String[] args) {
        Map<String,String> maps = new HashMap<>();
        maps.put(null,"123");
        maps.put(null,"455");
        maps.put("23",null);
        maps.put("12",null);
        for(String key:maps.keySet()){
            System.out.println("key:"+key +" value:" +maps.get(key));
        }

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
