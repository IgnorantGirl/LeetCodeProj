package leetcode.editor.cn;  //给你一个整数数组 nums，请你将该数组升序排列。
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 981 👎 0


import java.util.Arrays;

public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
        System.out.println(Arrays.toString(solution.insertSort(new int[]{5, 6, 8, 9, 1, 2, 7})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 快速排序
         *
         * @param nums
         * @return
         */
        public int[] sortArray(int[] nums) {
            if (nums == null) {
                return null;
            }
            int len = nums.length;
            if (len == 1) {
                return nums;
            }
            int left = 0, right = len - 1;
            quickSort(nums, left, right);

            return nums;
        }

        public void quickSort1(int[] nums, int left, int right) {

            int l = left, r = right;
            int target = nums[(left + right) / 2];
            while (l < r) {
                while (nums[r] > target) {
                    r--;
                }
                while (nums[l] < target) {
                    l++;
                }
                if (l >= r) {
                    break;
                }
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                if (nums[l] == target) r--;
                if (nums[r] == target) l++;
            }

            if (l == r) {
                l++;
                r--;
            }
            if (r < right) {
                quickSort(nums, left, r);
            }
            if (l > left) {
                quickSort(nums, l, right);
            }
        }


        public void quickSort(int[] nums, int left, int right) {
            int l = left, r = right;
            int target = nums[(l + r) / 2];
            while (l < r) {
                while (nums[r] > target) {
                    r--;
                }
                while (nums[l] < target) {
                    l++;
                }
                if (l >= r) {
                    break;
                }
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                if (nums[r] == target) l++;
                if (nums[l] == target) r--;
            }
            if (l == r) {
                l++;
                r--;
            }
            if (r < right) {
                quickSort(nums, left, r);
            }
            if (l > left) {
                quickSort(nums, l, right);
            }
        }

        public int[] insertSort(int[] nums) {
            if (nums == null) return nums;
            int len = nums.length;
            for (int i = 1; i < len; i++) {
                // 先记录nums[i]的值，后续以此进行比较
                int temp = nums[i];
                int j = i;
                // 将大于nums[i]的值 往后挪动
                while (j > 0 && nums[j - 1] > temp) {
                    nums[j] = nums[j - 1];
                    j--;
                }
                nums[j] = temp;
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}