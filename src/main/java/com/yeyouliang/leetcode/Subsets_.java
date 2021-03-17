package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/3/15 : 21:34.
 */
public class Subsets_ {//LeetCode 78：子集
    /**
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */
    public static void main(String[] args) {
        int[] in = {1, 2, 3};
        List<List<Integer>> subsets = subsets(in);
        System.out.println(subsets);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lli = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> ill = new ArrayList<>();
            if (lli.size() == 0) {
                List<Integer> add1 = new ArrayList<>();
                List<Integer> add2 = new ArrayList<>();
                add2.add(nums[i]);
                ill.add(add1);
                ill.add(add2);
            } else {
                for (List<Integer> list : lli) {
                    List<Integer> integers = new ArrayList<>(list);
                    if (integers.size() == 0) {
                        List<Integer> add1 = new ArrayList<>();
                        List<Integer> add2 = new ArrayList<>();
                        add2.add(nums[i]);
                        ill.add(add1);
                        ill.add(add2);
                    } else {
                        List<Integer> add1 = new ArrayList<>(integers);
                        integers.add(nums[i]);
                        ill.add(add1);
                        ill.add(integers);
                    }
                }
            }
            lli = ill;
        }
        return lli;
    }
}
