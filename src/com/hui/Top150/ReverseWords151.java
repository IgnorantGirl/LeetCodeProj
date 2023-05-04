package com.hui.Top150;

public class ReverseWords151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("  a  good   example  "));
    }

    public static String reverseWords(String s) {
        String[] strArray = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = strArray.length - 1; i >= 0; i--) {
            if (strArray[i].equals("")) continue;
            builder.append(strArray[i].trim());
            if (i != 0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
