package com.hui.Top150;

public class Arrays {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1, 4};
        int res = jump2(arr);
        System.out.println(res);
    }

    public static boolean jump(int[] nums) {
        int k = nums[0];
        for (int i = 1; i < nums.length; i++) {

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
}
