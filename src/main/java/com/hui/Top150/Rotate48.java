package com.hui.Top150;

import java.util.Arrays;

public class Rotate48 {
    static int[][] matrix = null;

    public static void main(String[] args) {
        matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void rotate(int[][] matrix) {
        int rows = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < rows / 2; i++) {
            for (int j = 0; j < (column + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[column - 1 - j][i];
                matrix[column - 1 - j][i] = matrix[rows - 1 - i][column - 1 - j];
                matrix[rows - 1 - i][column - 1 - j] = matrix[j][rows - 1 - i];
                matrix[j][rows - 1 - i] = temp;
            }
        }
    }
}
