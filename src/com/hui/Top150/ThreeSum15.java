package com.hui.Top150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public static void main(String[] args) {
        //输入：nums = [-1,0,1,2,-1,-4]
        //输出：[[-1,-1,2],[-1,0,1]]
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            // 注意此处为if
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[i] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[left], nums[i], nums[right]));
                    //　注意此处为while
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
