package leetcode.editor.cn;  //给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7059 👎 0

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 7};

        double res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;

            int total = len1 + len2;
            if (total % 2 == 1) {
                // 奇数情况
                return getKElement(nums1, nums2, total / 2 + 1);
            } else {
                // 偶数情况
                double n1 = getKElement(nums1, nums2, total / 2);
                double n2 = getKElement(nums1, nums2, total / 2+1);

                return (getKElement(nums1, nums2, total / 2) + getKElement(nums1, nums2, total / 2 + 1)) / 2.0;
            }
        }

        // 寻找第k小的数
        public double getKElement(int[] nums1, int[] nums2, int k) {
            int m = nums1.length;
            int n = nums2.length;
            int index1 = 0, index2 = 0;

            while (true) {
                // 边界条件
                if (index1 == m) {
                    return nums2[index2 + k - 1];
                }
                if (index2 == n) {
                    return nums1[index1 + k - 1];
                }
                // k=1时，就找第一个小的数
                if (k == 1) {
                    return Math.min(nums1[index1], nums2[index2]);
                }

                int half = k / 2;
                // 新的下标 需要考虑数组越界的情况
                //int num1 = nums1[index1+half-1];
                //int num2 = nums2[index2+half-1];
                int newIndex1 = Math.min(index1 + half, m) - 1;
                int newIndex2 = Math.min(index2 + half, n) - 1;
                if (nums1[newIndex1] <= nums2[newIndex2]) {
                    // num1<=num2满足时，说明nums1前面k/2-1个都比第k个小
                    // k去掉 移除的元素个数
                    k = k - (newIndex1 - index1 + 1);
                    index1 = newIndex1 + 1;
                } else {
                    k = k - (newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  
