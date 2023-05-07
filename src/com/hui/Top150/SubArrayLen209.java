package com.hui.Top150;

public class SubArrayLen209 {
    public static void main(String[] args) {
        // [2,3,1,2,4,3]  2
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        // in　进入sum的元素；out 移出sum的元素
        int in =0,out =0,res = Integer.MAX_VALUE;
        while (in<nums.length){
            sum = sum + nums[in];
            while (sum>=target){
                res = Math.min(res,in-out+1);
                sum = sum-nums[out++];
            }
            in++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
