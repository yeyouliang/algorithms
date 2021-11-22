package com.yeyouliang.ti;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/19 : 10:26.
 */
public class T5 {
    /**
     * 经典二分查找问题
     * 在一个排序数组中找一个数，返回该数出现的任意位置，如果不存在，返回 -1。
     */
    public static void main(String[] args) {
        int[][][] ints = {
                {{1, 2, 2, 4, 5, 5}, {0}},
                {{1, 2, 2, 4, 5, 5}, {1}},
                {{1, 2, 2, 4, 5, 5}, {2}},
                {{1, 2, 2, 4, 5, 5}, {3}},
                {{1, 2, 2, 4, 5, 5}, {4}},
                {{1, 2, 2, 4, 5, 5}, {5}},
                {{1, 2, 2, 4, 5, 5}, {6}},
                {{1, 2, 2, 4, 5, 5}, {7}},
                {{2, 4}, {3}},
                {{2, 4}, {1}},
                {{2, 4}, {2}},
                {{2, 4}, {3}},
                {{2, 4}, {4}},
                {{2, 4}, {5}},
                {{1}, {0}},
                {{0}, {0}},
                {{1}, {1}},
                {{0}, {1}},
                {{1}, {2}},
                {{0}, {2}},
                {{1, 0, 0, 0, 1}, {0}},
                {{1, 0, 0, 0, 1}, {1}},
                {{1, 0, 0, 0, 1}, {2}},
                {{0, 1, 0, 0, 0, 1}, {1}},
                {{0, 0, 1, 0, 0, 0, 1}, {1}},
                {{1, 0, 0, 0, 1, 0}, {1}},
                {{1, 0, 0, 0, 1, 0, 0}, {1}},
                {{1, 0, 0, 0, 1}, {2}},
                {{0, 1, 0, 0, 0, 1}, {2}},
                {{0, 0, 1, 0, 0, 0, 1}, {2}},
                {{1, 0, 0, 0, 1, 0}, {2}},
                {{1, 0, 0, 0, 1, 0, 0}, {2}},
        };
        for (int[][] string : ints) {
            System.out.println(Arrays.toString(string[0]));
            System.out.println(Arrays.toString(string[1]));
            System.out.println(findPosition(string[0], string[1][0]));
            System.out.println("---------------------------------");
        }
    }

    private static int findPosition(int[] nums, int target) {
        if (nums != null && nums.length > 0) {
            if (nums.length == 1) {
                return nums[0] == target ? 0 : -1;
            } else {
                int a = 0;
                int b = nums.length - 1;
                while (true) {
                    if (a == b) {
                        return nums[a] == target ? a : -1;
                    } else {
                        int c = (b - a) / 2;
                        int d = a + c;
                        if (nums[d] == target) {
                            return d;
                        } else if (nums[d] > target) {
                            b = d;
                        } else {
                            a = d + 1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
