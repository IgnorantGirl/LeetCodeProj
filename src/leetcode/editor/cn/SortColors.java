package leetcode.editor.cn;

//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1773 👎 0

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        int[] nums = new int[]{2, 0, 1, 2, 2, 1};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int len = nums.length;
            if (len < 2) {
                return;
            }
            int index0 = 0, index1 = 0;
            for (int i = 0; i < len; i++) {
                int num = nums[i];
                nums[i] = 2;
                if (num < 2) {
                    nums[index1++] = 1;
                }
                if (num < 1) {
                    nums[index0++] = 0;
                }
            }
        }

        public void sortColors2(int[] nums) {
            int len = nums.length;
            if (len < 2) {
                return;
            }
            int index0 = 0, i = 0, index2 = len - 1;
            while (i <= index2) {
                // 0~index0  存0
                if (nums[i] == 0) {
                    swap(i, index0,nums);
                    index0++;
                    i++;
                } else if (nums[i] == 1) {
                    // index0 ~ i 存1
                        i++;
                    } else {
                        // i~index2 存2
                        swap(i, index2,nums);
                        index2--;
                    }
            }
        }

        public void swap(int i, int j,int[] nums) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  