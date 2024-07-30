package com.hui.Top150;

import java.util.ArrayList;
import java.util.List;

public class FullJustify68 {

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words1 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        System.out.println(fullJustify(words1, 16));

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        List<String> res = new ArrayList<>();
        int right = 0;
        while (true) {
            int sumLen = 0;  //　统计这一行的单词长度之和
            int left = right; //　当前行的第一个单词在words中的位置
            //　right指针终究要小于words的长度len，并且　每一行的长度总和要小于给定的　最大宽度maxWidth
            while (right < len && (sumLen + words[right].length() + right - left) <= maxWidth) {
                sumLen = sumLen + words[right++].length();
            }

            // 最后一行特殊处理
            if (right == len) {
                StringBuilder builder = new StringBuilder();
                builder.append(join(words, left, right, " "));
                builder.append(blank(maxWidth - builder.length()));
                res.add(builder.toString());
                return res;
            }
            // 空格数量
            int spaceNums = maxWidth - sumLen;
            // 一行存的单词个数
            int wordsNums = right - left;


            //　一行只有一个单词的情况处理
            if (wordsNums == 1) {
                StringBuilder builder = new StringBuilder(words[left]);
                builder.append(blank(maxWidth - words[left].length()));
                res.add(builder.toString());
                continue;
            }
            //　一般情况
            //　平均两单词之间的空格数量
            int avgSpace = (spaceNums) / (wordsNums - 1);
            int extraSpace = spaceNums % (wordsNums - 1);
            StringBuilder builder = new StringBuilder();
            builder.append(join(words, left, left + extraSpace + 1, blank(avgSpace + 1)));
            builder.append(blank(avgSpace));
            builder.append(join(words, left + extraSpace + 1, right, blank(avgSpace)));
            res.add(builder.toString());
        }
    }

    private static String blank(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    private static String join(String[] words, int left, int right, String space) {
        StringBuilder builder = new StringBuilder(words[left]);
        for (int i = left + 1; i < right; i++) {
            builder.append(space);
            builder.append(words[i]);
        }
        return builder.toString();
    }
}
