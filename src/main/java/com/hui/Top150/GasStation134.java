package com.hui.Top150;

public class GasStation134 {

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost ={3,4,5,1,2};
        int res = canCompleteCircuit(gas, cost);
        System.out.println(res);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        //总的剩余油量
        int space = 0;
        int minSpace = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < len; i++) {
            space = gas[i] - cost[i] + space;
            if (space < minSpace) {
                minSpace = space;
                minIndex = i;
            }
        }
        return space < 0 ? -1 : (minIndex + 1) % len;
    }
}
