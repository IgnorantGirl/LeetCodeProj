package leetcode.editor.cn;

//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 双指针 👍 2468 👎 0

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] nums = {1, 3, 2};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            int a = -1, b = len - 1;
            for (int i = len - 1; i > 0; i--) {
                // 从后向前找到 较小的数
                if (nums[i] > nums[i - 1]) {
                    a = i - 1;
                    break;
                }
            }
            // 从a+1——len中 找比nums[a]较大一点的数
            for (int i = a + 1; a != -1 && i < len; i++) {
                if (nums[i] > nums[a]) {
                    b = i;
                }
            }

            // 交换a、b
            if (a != -1) {
                int temp = nums[a];
                nums[a] = nums[b];
                nums[b] = temp;
            }
            // a+1 —— len 肯定为降序 故交换 该区间的元素
            swap(a + 1, len, nums);
        }

        public void swap(int start, int end, int[] nums) {
            int count = (end + start) / 2;
            for (int i = start, j = 0; i < count; i++, j++) {
                int temp = nums[i];
                nums[i] = nums[end - 1 - j];
                nums[end - 1 - j] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  