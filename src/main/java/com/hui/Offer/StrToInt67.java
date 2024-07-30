package com.hui.Offer;

public class StrToInt67 {
    public static void main(String[] args) {
        System.out.println(strToInt("   -42"));
    }

    public static int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        int len = chars.length;
        int index = 0;
        if (len == 0) return 0;
        // 去除前缀的空格
        while (index < len && chars[index] == ' ') {
            // 找到非空格的索引位置
            index++;
        }
        if (index == len) return 0;
        // 判断是否带有正负号
        boolean isNegative = false;
        if (chars[index] == '-') {
            index++;
            isNegative = true;
        } else if (chars[index] == '+') {
            index++;
        }
        int res = 0;

        // 遍历字符
        for (int i = index; i < chars.length; i++) {
            char c = chars[i];
            // 不合法字符
            if (c < '0' || c > '9') {
                break;
            }
            // 特殊情况处理
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10)) {
                return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            res = res * 10 + (c - '0');
        }
        return isNegative ? -res : res;
    }
}
