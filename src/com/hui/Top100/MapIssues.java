package com.hui.Top100;

import java.util.*;

public class MapIssues {

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    /**
     * 128.最长子序列
     * 思路：
     * 1. 使用无重复集合存取数组
     * 2. 遍历集合，若不存在当前数字前面的数字，则从当前数字开始 +1遍历
     * 3. 遍历若无连续数字，则更新结果指
     *
     * @param nums [100,4,200,1,3,2]
     * @return 最长子序列长度
     */
    public static int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len == 1 || len == 0) return len;
        Set<Integer> sets = new HashSet<>();
        int res = 1;
        for (int i = 0; i < len; i++) {
            sets.add(nums[i]);
        }
        for(int i=0;i<sets.size();i++){
            int count= 1;
            if(!sets.contains(nums[i]-1)){
                while (sets.contains(nums[i]+1)){
                    count++;
                    nums[i]++;
                }
            }
            res = Math.max(res,count);
        }
        return res;
    }

    /**
     * 49.字母异位词分组
     * 思想：
     * 1.使用map 以 字典序的字母为key,同为异位词的为values
     * 2.遍历strs, 当无key 时，则创建新的key 和list；存在key时，则直接加入里面即可
     * @param strs ["eat", "tea", "tan", "ate", "nat", "bat"]
     * @return 分组后的list
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> maps = new HashMap<>();
        int len = strs.length;
        for(int i=0;i<len;i++){
            char[] charsArray = strs[i].toCharArray();
            Arrays.sort(charsArray);
            if(!maps.containsKey(String.valueOf(charsArray))){
                maps.put(String.valueOf(charsArray),new ArrayList<>());
            }
            maps.get(String.valueOf(charsArray)).add(strs[i]);
        }
        for(String str:maps.keySet()){
            res.add(maps.get(str));
        }
        return res;
    }
}
