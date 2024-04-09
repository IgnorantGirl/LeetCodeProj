package leetcode.editor.cn;

//两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 1, y = 4
//输出：2
//解释：
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//上面的箭头指出了对应二进制位不同的位置。
// 
//
// 示例 2： 
//
// 
//输入：x = 3, y = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x, y <= 2³¹ - 1 
// 
//
// Related Topics 位运算 👍 736 👎 0

public class HammingDistance {
    public static void main(String[] args) {
        Solution solution = new HammingDistance().new Solution();
        int result = solution.hammingDistance(1, 4);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 逐位比较
         *
         * @param x
         * @param y
         * @return
         */
        public int hammingDistance1(int x, int y) {
            int res = (x & 1) ^ (y & 1);
            for (int i = 1; x != 0 || y != 0; ) {
                x = x >> i;
                y = y >> i;
                // 逐位比较 最后一位
                int a = x & 1, b = y & 1;
                // 异或 同号为假 0，异号为真 1
                res = res + (a ^ b);
            }
            return res;
        }

        /**
         * 右移动统计 1的个数
         *
         * @param x
         * @param y
         * @return
         */
        public int hammingDistance(int x, int y) {
            int temp = x ^ y, res = 0;
            while (temp != 0) {
                res += (temp & 1);
                temp = temp >> 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  