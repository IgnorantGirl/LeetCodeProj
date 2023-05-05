package com.hui.Top150;

import java.util.Arrays;

public class TwoSum167 {
    public static void main(String[] args) {
        // 1,2,5,7
        System.out.println(Arrays.toString(twoSum(new int[]{1,2,5,7},12)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int cur = numbers[left] + numbers[right];
            if (cur > target) {
                right--;
            } else if (cur < target) {
                left++;
            } else {
                return new int[]{left, right};
            }
        }
        return null;
    }
}
