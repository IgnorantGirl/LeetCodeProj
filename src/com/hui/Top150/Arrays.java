package com.hui.Top150;

public class Arrays {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1, 4};
        int res = jump2(arr);
        System.out.println(res);
        System.out.println(jump(arr));
        System.out.println(jump2_1(arr));
    }

    public static boolean jump(int[] nums) {
        int len = nums.length;
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    public static boolean jump_1(int[] nums) {
        int rightMost = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, nums[i] + i);
                if (rightMost >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int jump2(int[] nums) {
        int pos = nums.length - 1;
        int steps = 0;
        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (nums[i] + i >= pos) {
                    pos = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public static int jump2_1(int[] nums) {
        int step = 0;
        int end = 0;
        int maxPosition = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
