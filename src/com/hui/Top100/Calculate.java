package com.hui.Top100;

import java.util.Stack;

/**
 * 227.计算器Ⅱ
 */
public class Calculate {

    public static void main(String[] args) {
        System.out.println(calculate("  3 / 2  "));
    }

    public static int calculate(String s) {
        int res = 0;
        char[] charArray = s.trim().toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isDigit(charArray[i]) && charArray[i] != '+' && charArray[i] != '-' && charArray[i] != '*' && charArray[i] != '/') {
                continue;
            }

            if (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                char top = stack.pop();
                switch (top) {
                    case '*':
                        res = res + stack.pop() * Integer.valueOf(charArray[i]);
                        break;
                    case '/':
                        res = res + stack.pop() / Integer.valueOf(charArray[i]);
                        break;
                }
            }
            stack.push(charArray[i]);
        }
        return res;
    }
}
