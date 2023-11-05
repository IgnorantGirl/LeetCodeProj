package com.hui.Top100;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive41 {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive1(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        int len = nums.length;
        int res = 1;
        for (int num : nums) {
            sets.add(num);
        }
        // 防止{1，2} {1}的情况，该情况应该返回 3 、2 所以多遍历一次
        for (int i = 0; i < len + 1; i++) {
            if (!sets.contains(i + 1)) {
                res = i + 1;
                break;
            }
        }
        return res;
    }

    public static int firstMissingPositive1(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 置换
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }

        return len + 1;
    }
}
