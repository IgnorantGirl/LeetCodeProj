package com.hui.Top100;

import java.sql.Array;
import java.util.*;

public class DoublePointer {


    public static void main(String[] args) {
        // 测试移动零
        int[] nums = {0, 1, 0, 3, 126};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 283.移动零
     * 思想：
     * 1.左右指针 移动
     * 2.左指针位0，右指针非0时，进行交换； 否则二者移动
     *
     * @param nums 传入待移动零数组 [0,1,0,3,126]
     * @return
     */
    public static void moveZeros(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 1;
        while (left < right && right < len) {
            if (nums[left] == 0 && nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right++;
            } else if (nums[left] == 0 && nums[right] == 0) {
                right++;
            } else {
                left++;
                right++;
            }
        }
    }


    /**
     * 15.三数之和  nums[i] + nums[j] + nums[k] == 0
     * 思想：
     * 1.依次遍历 固定一个数 并和左 右指针(last) 依次寻找满足条件的数值
     * 2.左右指针，当和 >0时， r--； 和<0时，l++；满足条件则 加入list
     * 3.注意处理重复数字的情况
     *
     * @param nums 数组 [-1,0,1,2,-1,-4]
     * @return 满足条件的list
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] < nums[i - 1]) continue;
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int target = nums[i] + nums[left] + nums[right];
                if (target < 0) {
                    left++;
                } else if (target > 0) {
                    right--;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(temp);
                    while (left < right && nums[left + 1] == nums[left]) left++;
                    while (left < right && nums[right - 1] == nums[right]) right--;
                    left++;
                    right--;

                }
            }
        }
        return res;
    }


    /**
     * 11.盛水最多的容器
     * 思想：
     * 1.左右指针（first last）相继移动
     * 2.临时变量存 左右指针之间的最大盛水量
     * 3.哪面容器小，则移动哪面
     *
     * @param height 每个容器的高度 [1,8,6,2,5,4,8,3,7]
     * @return 最大盛水量
     */
    public static int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int res = 0;
        int count = 0;
        while (left < right) {
            count = (right - left) * Math.min(height[left], height[right]);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    /**
     * 42.接雨水
     * 思想：
     * 1.使用两个数组存左右两端的最大高度
     * 2.比较两端最大值，取小的一段，大于当前高度 则能存水
     *
     * @param height 柱子高度 [0,1,0,2,1,0,1,3,2,1,2,1]
     * @return 最多接的雨水量
     */
    public static int trap(int[] height) {
        int len = height.length;
        int[] heightLeft = new int[len];
        int[] heightRight = new int[len];
        int sum = 0;
        for (int i = 1; i < len; i++) {
            heightLeft[i] = Math.max(heightLeft[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            heightRight[i] = Math.max(heightRight[i + 1], height[i]);
        }
        for (int i = 0; i < len; i++) {
            int minHeight = Math.min(heightLeft[i], heightRight[i]);
            if (minHeight > height[i]) {
                sum = sum + (minHeight - height[i]);
            }
        }
        return sum;
    }

}
