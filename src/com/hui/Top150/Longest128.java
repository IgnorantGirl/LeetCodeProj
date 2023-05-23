package com.hui.Top150;

import java.util.HashSet;
import java.util.Set;

public class Longest128 {
    public static void main(String[] args) {
        //int[] 0,3,7,2,5,8,4,6,0,1  / 100,4,200,1,3,2
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!sets.contains(num - 1)) {
                count = 0;
                while (sets.contains(num)) {
                    count++;
                    num++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
