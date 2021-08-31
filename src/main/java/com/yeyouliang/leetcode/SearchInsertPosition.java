package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/3/8 : 21:51.
 */
public class SearchInsertPosition {
    /**
     * 35. 搜索插入位置
     */
    public static void main(String[] args) {
        int[][][] ints = {
                {{1, 3, 5, 6}, {5}},
                {{1, 3, 5, 6}, {2}},
                {{1, 3, 5, 6}, {7}},
                {{1, 3, 5, 6}, {0}},
                {{1}, {0}},
                {{1}, {1}},
                {{1}, {2}},
                {{3, 7}, {2}},
                {{3, 7}, {3}},
                {{3, 7}, {4}},
                {{3, 7}, {7}},
                {{3, 7}, {9}},
                {{-3, 7}, {-5}},
                {{-3, 7}, {-3}},
                {{-3, 7}, {-1}},
                {{-3, 7}, {0}},
                {{-3, 7}, {1}},
                {{-3, 7}, {4}},
                {{-3, 7}, {7}},
                {{-3, 7}, {9}},
                {{1, 5, 8, 16}, {0}},
                {{1, 5, 8, 16}, {1}},
                {{1, 5, 8, 16}, {2}},
                {{1, 5, 8, 16}, {3}},
                {{1, 5, 8, 16}, {4}},
                {{1, 5, 8, 16}, {5}},
                {{1, 5, 8, 16}, {6}},
                {{1, 5, 8, 16}, {8}},
                {{1, 5, 8, 16}, {9}},
                {{1, 5, 8, 16}, {11}},
                {{1, 5, 8, 16}, {16}},
                {{1, 5, 8, 16}, {19}},
                {{1, 5, 8, 16, 33}, {0}},
                {{1, 5, 8, 16, 33}, {1}},
                {{1, 5, 8, 16, 33}, {3}},
                {{1, 5, 8, 16, 33}, {5}},
                {{1, 5, 8, 16, 33}, {7}},
                {{1, 5, 8, 16, 33}, {8}},
                {{1, 5, 8, 16, 33}, {11}},
                {{1, 5, 8, 16, 33}, {16}},
                {{1, 5, 8, 16, 33}, {18}}
        };
        for (int[][] anInt : ints) {
            System.out.println(Arrays.toString(anInt[0]) + "," + anInt[1][0] + ":" + searchInsert(anInt[0], anInt[1][0]));
        }
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int start = 0;
        int end = nums.length - 1;
        while (true) {
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }
            if (end - start == 1) {
                return end;
            }
            int middle = (end - start) / 2;
            if (nums[start + middle] == target) {
                return start + middle;
            } else if (nums[start + middle] > target) {
                end = start + middle;
            } else {
                start += middle;
            }
        }
    }
}
