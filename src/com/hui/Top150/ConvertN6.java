package com.hui.Top150;

import java.util.ArrayList;
import java.util.List;

public class ConvertN6 {
    public static void main(String[] args) {
        //　正确结果　PAHNAPLSIIGYIR
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        // 变换行数的标识
        int flag = -1;
        StringBuilder res = new StringBuilder();
        List<StringBuilder> rowList = new ArrayList<>();
        //　向list里面添加　指定行数的StringBuilder,用于拼接每一行的string
        for (int i = 0; i < numRows; i++) {
            rowList.add(new StringBuilder());
        }
        for (int i = 0, n = 0; i < s.length(); i++, n += flag) {
            rowList.get(n).append(s.charAt(i));
            if (n == 0 || n == rowList.size() - 1) {
                flag = -flag;
            }
        }
        for (StringBuilder builder : rowList) {
            res.append(builder);
        }
        return res.toString();
    }
}
