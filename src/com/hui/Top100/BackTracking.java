package com.hui.Top100;

import java.util.ArrayList;
import java.util.List;

public class BackTracking {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    /**
     * 46.全排列
     * 树递归遍历的思想：除了根结点和叶子结点以外，每一个结点做的事情其实是一样的，即从已经选择了一些树的前提下，在剩下没有选择的数中 依次选择一个数
     * 回溯的思想：执行深度优先遍历，从较深层的结点返回到较浅层结点的时候，需要做「状态重置」，即「回到过去」、「恢复现场」 -- 与制造现场相互对称即可
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 非叶子节点的路径
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        // 深度遍历
        dfs(nums, 0, len, used, path, res);
        return res;
    }

    private static void dfs(int[] nums, int depth, int len, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        // 终止条件：一个排列中的数字已经选够了 即树的深度与 数量相匹配
        // 参数传递是 值传递，对象类型变量在传参的过程中，复制的是变量的地址。这些地址被添加到 res 变量，但实际上指向的是同一块内存地址，因此我们会看到 666 个空的列表对象。
        // 解决的方法很简单，在 res.add(path); 这里需要做一次拷贝
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, depth + 1, len, used, path, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
