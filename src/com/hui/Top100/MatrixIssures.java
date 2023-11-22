package com.hui.Top100;

import java.util.Arrays;

public class MatrixIssures {
    static int[][] matrix = null;

    public static void main(String[] args) {
        matrix = new int[][]{{5, 1, 0, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /**
     * 73. 矩阵置零
     * 1. 使用两个变量标记 第一行第一列是否有0
     * 2. 使用第一行第一列 来标记 内部为0的情况
     *
     * @param matrix 矩阵
     */
    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        boolean rowFlag = false;
        boolean columnFlag = false;
        //  1. 使用两个变量标记 第一行第一列是否有0
        for (int j = 0; j < column; j++) {
            if (matrix[0][j] == 0) {
                rowFlag = true;
            }
        }
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                columnFlag = true;
            }
        }
        // 2. 使用第一行第一列 来标记 内部为0的情况
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 3. 遍历第一行第一列为0的情况
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowFlag) {
            for (int j = 0; j < column; j++) {
                matrix[0][j] = 0;
            }
        }

        if (columnFlag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
