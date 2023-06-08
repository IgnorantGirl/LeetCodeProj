package com.hui.Top150;

import java.util.Arrays;

public class Zeros73 {
    static int[][] matrix = null;

    public static void main(String[] args) {
        matrix = new int[][]{{5, 1, 0, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int column = matrix[0].length;
        int[] rowsArray = new int[rows];
        int[] columnArray = new int[column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rowsArray[i] = 1;
                    columnArray[j] = 1;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (rowsArray[i] == 1 || columnArray[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
