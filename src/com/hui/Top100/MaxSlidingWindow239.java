package com.hui.Top100;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.*;

public class MaxSlidingWindow239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxSlidingWindow2(nums, 3);
        System.out.println(Arrays.toString(res));



    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];

        // 降序排列，数组元素相同时，按其下标降序排列
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1 != o2 ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            // 向队列中添加元素
            queue.offer(new int[]{nums[i], i});
        }
        // 前三个元素的最大值
        res[0] = queue.peek()[0];

        for (int i = k; i < len; i++) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] < i - k + 1) {
                // 如果下标超出了范围  k-3~k
                queue.poll();
            }
            res[i - k + 1] = queue.peek()[0];
        }
        return res;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1 - k, j = 0; j < len; i++, j++) {
            // 队头元素 若不在  (i,j) 范围 就将其移除
            if (i > 0 && deque.peekFirst() == nums[i-1]) {
                deque.removeFirst();
            }
            // 在队列不为null时，保证降序
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            if (i >= 0) {
                // 队列头是最大的
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }
}
