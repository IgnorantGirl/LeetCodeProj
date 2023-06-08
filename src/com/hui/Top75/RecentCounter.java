package com.hui.Top75;

import java.util.ArrayDeque;

public class RecentCounter {

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
        System.out.println(counter.ping(6800));

    }
    ArrayDeque<Integer> deque;
    public RecentCounter() {
    deque = new ArrayDeque<>();
    }

    public int ping(int t){
        deque.offer(t);
        while (deque.peek()<t-3000){
            deque.poll();
        }
        return deque.size();
    }
}
