package com.hui.Offer;

public class FindNthDigit44 {

    public static void main(String[] args) {
        System.out.println(findNthDigit(1234));
    }

    public static int findNthDigit(int n){
        int dight = 1;
        int start = 1;
        long count = 9;
        while(n>count){
            n = (int) (n-count);
            dight++;
            start*=10;
            count = (long) start*dight*9;
        }
        int num = start + (n-1)/dight;
        int index = (n-1)%dight;
        while (index<(dight-1)){
            num = num/10;
            dight--;
        }
        return num%10;
       // return Long.toString(num).charAt((n-1)%dight)-'0';
    }
}
