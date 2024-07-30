package com.hui.Top150;

import java.util.HashSet;
import java.util.Set;

public class ValidSudo36 {
    public static void main(String[] args) {
        //输入：board =
        //[["5","3",".",".","7",".",".",".","."]
        //,["6",".",".","1","9","5",".",".","."]
        //,[".","9","8",".",".",".",".","6","."]
        //,["8",".",".",".","6",".",".",".","3"]
        //,["4",".",".","8",".","3",".",".","1"]
        //,["7",".",".",".","2",".",".",".","6"]
        //,[".","6",".",".",".",".","2","8","."]
        //,[".",".",".","4","1","9",".",".","5"]
        //,[".",".",".",".","8",".",".","7","9"]]
        //输出：true
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] column = new int[9][9];
        int[][][] square = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if(c !='.'){
                    int index = board[i][j]-'0'-1;
                    rows[i][index]++;
                    column[j][index]++;
                    square[i/3][j/3][index]++;
                    if(rows[i][index]>1 || column[j][index]>1 ||square[i/3][j/3][index]>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku1(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> column = new HashSet<>();
            Set<Character> square = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                char rowsChar = board[i][j];
                if(rowsChar!='.'){
                    if(rows.contains(rowsChar)){
                        return false;
                    }else {
                        rows.add(rowsChar);
                    }
                }

                char columnChar = board[j][i];
                if(columnChar!='.'){
                    if(column.contains(columnChar)){
                        return false;
                    }else {
                        column.add(columnChar);
                    }
                }
                char squareChar = board[i/3*3+j/3][i%3*3+j%3];
                if(squareChar!='.'){
                    if(square.contains(squareChar)){
                        return false;
                    }else {
                        square.add(squareChar);
                    }
                }
            }
        }
        return true;
    }
}
