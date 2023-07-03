package com.hui.Offer;

import java.util.Arrays;

public class Exchange21 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1,3,5,2,4,6,8})));;
    }

    public static int[] exchange(int[] nums){
        int i=0,j = nums.length-1;
        while (i<j){
            while(i<j&& (nums[i]&1)==1){
                i++;
            }
            while(i<j&& (nums[j]&1)==0){
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
