package leetcode.editor.cn;  //给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 字符串 回溯 矩阵 👍 1807 👎 0


public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            int row = board.length;
            int column = board[0].length;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (dfs(board, words, i, j, 0, row, column)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * 遍历二维数组第[i][j] 是否与 第k个字符 匹配
         *
         * @param board 二维数组
         * @param words 字符数组
         * @param i     二维数组索引i
         * @param j     二维数组索引j
         * @param k     字符数组k
         * @return
         */
        private boolean dfs(char[][] board, char[] words, int i, int j, int k, int row, int column) {
            // 一些特殊case的判断
            if (i >= row || i < 0 || j >= column || j < 0 || k > words.length || board[i][j] != words[k]) {
                return false;
            }
            // 遍历到最后了
            if (k == words.length - 1) {
                return true;
            }
            // 先把board[i][j]置一个值
            board[i][j] = '\0';
            boolean res = dfs(board, words, i + 1, j, k + 1, row, column)
                    || dfs(board, words, i - 1, j, k + 1, row, column)
                    || dfs(board, words, i, j + 1, k + 1, row, column)
                    || dfs(board, words, i, j - 1, k + 1, row, column);
            // 为了回溯 给恢复回来
            board[i][j] = words[k];
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}