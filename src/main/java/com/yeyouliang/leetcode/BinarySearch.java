package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/8/18 : 19:59.
 */
public class BinarySearch {
    /**
     * 704. 二分查找
     * */
    public static void main(String[] args) {
        System.out.println(search(new int[]{5}, -5));
    }

    private static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (true) {
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }
            if (end - start <= 1) {
                return -1;
            }
            int half = (end - start) / 2;
            if (nums[start + half] == target) {
                return start + half;
            } else if (nums[start + half] < target) {
                start += half;
            } else {
                end = start + half;
            }
        }
    }
}
