package leetcode.editor.cn;  //整数数组 nums 按升序排列，数组中的值 互不相同 。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 2915 👎 0


public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        System.out.println(solution.search(new int[]{3, 1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search2(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return -1;
            }
            // 左右指针
            int left = 0, right = len - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                // 比较left与target值
                if (nums[0] > target) {
                    // 在右半边找 再看下中间值与left的关系
                    if (nums[mid] >= nums[0]) {
                        // 将其至成最小值 变成有序数组 方便左右指针移动
                        nums[mid] = Integer.MIN_VALUE;
                    }
                } else {
                    // 在左半边找
                    if (nums[mid] < nums[0]) {
                        // 将其至成最大值 变成有序数组 方便 左右指针移动
                        nums[mid] = Integer.MAX_VALUE;
                    }
                }

                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }


        public int search(int[] nums, int target) {
            int len = nums.length;
            int left = 0;
            int right = len - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                // 比较target与left的值
                if (nums[left] > target) {
                    // 说明target在后半段，再比较与mid的关系
                    if (nums[mid] >= nums[left]) {
                        // 置为最小值 变有序数组
                        nums[mid] = Integer.MIN_VALUE;
                    }
                } else {
                    // 说明在前半段
                    if (nums[mid] < nums[left]) {
                        nums[mid] = Integer.MAX_VALUE;
                    }
                }
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}