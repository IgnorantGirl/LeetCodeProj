package com.hui.Top150;

public class Rain42 {
    public static void main(String[] args) {
        int[] rains = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(rain1(rains));
    }

    public static int rain(int[] height) {
        int len = height.length;
        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            int max_left = 0;
            for (int j = 0; j < i; j++) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            for (int j = i + 1; j < len; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            int min = Math.min(max_left, max_right);
            if ((min - height[i]) > 0) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public static int rain1(int[] height) {
        int len = height.length;
        int sum = 0;
        int[] max_left = new int[len];
        int[] max_right = new int[len];
        for (int i = 1; i < len - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = len-2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if ((min - height[i]) > 0) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}
