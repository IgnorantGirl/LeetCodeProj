package com.hui.Top150;

public class Candy135 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 3, 2, 1};
        int candy = candy(nums);
        System.out.println(candy);
        System.out.println(candy1(nums));
    }

    //　抽象左右规则
    public static int candy(int[] ratings) {
        int len = ratings.length;
        int[] candyNums = new int[len];
        int res = 0;
        //　左规则
        for (int i = 0; i < len; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                candyNums[i] = candyNums[i - 1] + 1;
            } else {
                candyNums[i] = 1;
            }
        }
        //　右规则
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (i < len - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            res = res + Math.max(candyNums[i], right);
        }
        return res;
    }

    // 递增递减处理
    public static int candy1(int[] ratings) {
        int len = ratings.length;
        // 递增递减标识
        int inc = 0, dec = 0;
        int pre = 1;
        int res = 1;
        for (int i = 1; i < len; i++) {
            //递增
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                res += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                res += dec;
                pre = 1;
            }
        }
        return res;
    }
}
