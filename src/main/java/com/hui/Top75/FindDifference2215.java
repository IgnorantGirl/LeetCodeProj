package com.hui.Top75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDifference2215 {

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
            if (!set1.contains(nums2[i]) && !list.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }
        res.add(list);
        list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!set2.contains(nums1[i]) && !list.contains(nums1[i])) {
                list.add(nums1[i]);
            }
        }
        res.add(0, list);
        return res;

    }

    public static List<List<Integer>> findDifference1(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                list.add(num);
            }
        }
        res.add(list);
        list = new ArrayList<>();
        for (int num : set2) {
            if (!set1.contains(num)) {
                list.add(num);
            }
        }
        res.add(list);

        return res;
    }
}
