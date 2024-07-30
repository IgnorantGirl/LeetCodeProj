package com.hui.Top150;


public class Roman12_13 {
    public static void main(String[] args) {
        System.out.println(roman2int("MCMXCIV"));
        System.out.println(int2roman(1994));
        System.out.println(int2roman2(1994));
    }

    public static int roman2int(String roman) {
        int sum = 0;
        int preNum = transformInt(roman.charAt(0));
        for (int i = 1; i < roman.length(); i++) {
            int num = transformInt(roman.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private static int transformInt(char charAt) {
        int res = -1;
        switch (charAt) {
            case 'M':res = 1000;break;
            case 'D':res = 500;break;
            case 'C':res = 100;break;
            case 'L':res = 50;break;
            case 'X':res = 10;break;
            case 'V':res = 5;break;
            case 'I':res = 1;break;
        }
        return res;
    }


    public static String int2roman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<values.length;i++){
            int value = values[i];
            String symbol = symbols[i];
            while (num>=value){
              builder.append(symbol);
              num -=value;
            }
            if(num == 0){
                break;
            }
        }
        return builder.toString();
    }

    public static String int2roman2(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuilder builder = new StringBuilder();
        builder.append(thousands[num / 1000]);
        builder.append(hundreds[(num % 1000) / 100]);
        builder.append(tens[(num % 100) / 10]);
        builder.append(ones[(num % 10)]);
        return builder.toString();
    }
}
