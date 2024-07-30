package com.hui.Sorts;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 10, 8, 22, 34, 5, 12, 28, 21, 11};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        int midVal = nums[(left+right)/2];
        while (l < r) {
            while (nums[l]<midVal){
                l++;
            }
            while (nums[r]>midVal){
                r--;
            }
            if(l>=r) break;
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            if(nums[l] == midVal) r--;
            if(nums[r] == midVal) l++;
        }
        if(l == r) {
            l++;r--;
        }
        if (left < l) quickSort(nums, left, r);
        if (right > r) quickSort(nums, l, right);
    }
}
