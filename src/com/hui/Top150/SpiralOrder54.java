package com.hui.Top150;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder54 {
    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(array));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rows = matrix.length;
        int column = matrix[0].length;
        int left = 0,top = 0,right = column-1,bottom = rows-1;
        while(true){
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if(++top>bottom) break;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if(--right<left) break;
            for (int i = right; i >=left; i--) {
                res.add(matrix[bottom][i]);
            }
            if(--bottom<top) break;
            for (int i = bottom; i >=top; i--) {
                res.add(matrix[i][left]);
            }
            if(++left>right) break;
        }
        return res;
    }
}
