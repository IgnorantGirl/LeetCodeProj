package com.hui.Top150;

public class MaxArea11 {
    public static void main(String[] args) {
        // 1,8,6,2,5,4,8,3,7
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int i = 0, j = len - 1;
        int res = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                res = Math.max(res, (j - i) * height[i++]);
            } else {
                res = Math.max(res, (j - i) * height[j--]);
            }
        }
        return res;
    }
}
