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

    public static void setZeroes2(int[][] matrix) {
        // 使用两个标记变量 来 标记第一行第一列 中是否有0
        boolean flagRows = false, flagColumns = false;
        int rows = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                flagColumns = true;
            }
        }
        for (int j = 0; j < column; j++) {
            if (matrix[0][j] == 0) {
                flagRows = true;
            }
        }
        // 使用第一行第一列 作为改行该列 是否有0的标记
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 遍历第一行第一列为0 的情况   将该行 该列 都置0
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (flagColumns) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRows) {
            for (int j = 0; j < column; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
