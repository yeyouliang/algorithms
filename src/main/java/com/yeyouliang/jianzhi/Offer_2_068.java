package com.yeyouliang.jianzhi;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/30 : 20:40.
 */
public class Offer_2_068 {
    /**
     * 剑指 Offer II 068. 查找插入位置
     */
    public static void main(String[] args) {
        int[][][] ints = {
                {{1}, {0}},
                {{0}, {0}},
                {{-1}, {0}},
                {{0}, {1}},
                {{1}, {1}},
                {{1}, {2}},
                {{1, 3}, {0}},
                {{1, 3}, {1}},
                {{1, 3}, {2}},
                {{1, 3}, {3}},
                {{1, 3}, {4}},
                {{1, 3, 5}, {0}},
                {{1, 3, 5}, {1}},
                {{1, 3, 5}, {2}},
                {{1, 3, 5}, {3}},
                {{1, 3, 5}, {4}},
                {{1, 3, 5}, {5}},
                {{1, 3, 5}, {6}},
                {{1, 3, 5, 7}, {0}},
                {{1, 3, 5, 7}, {1}},
                {{1, 3, 5, 7}, {2}},
                {{1, 3, 5, 7}, {3}},
                {{1, 3, 5, 7}, {4}},
                {{1, 3, 5, 7}, {5}},
                {{1, 3, 5, 7}, {6}},
                {{1, 3, 5, 7}, {7}},
                {{1, 3, 5, 7}, {8}},
                {{2, 4, 6, 8, 10}, {1}},
                {{2, 4, 6, 8, 10}, {2}},
                {{2, 4, 6, 8, 10}, {3}},
                {{2, 4, 6, 8, 10}, {4}},
                {{2, 4, 6, 8, 10}, {5}},
                {{2, 4, 6, 8, 10}, {6}},
                {{2, 4, 6, 8, 10}, {7}},
                {{2, 4, 6, 8, 10}, {8}},
                {{2, 4, 6, 8, 10}, {9}},
                {{2, 4, 6, 8, 10}, {10}},
                {{2, 4, 6, 8, 10}, {11}},
        };
        for (int[][] string : ints) {
            System.out.println(Arrays.toString(string[0]) + "--" + Arrays.toString(string[1]) + "--" + searchInsert(string[0], string[1][0]));
            System.out.println("---------------------------------");
        }
    }

    private static int searchInsert(int[] nums, int target) {
        int a = 0;
        int b = nums.length - 1;
        while (true) {
            int c = b - a;
            if (c == 0) {
                if (nums[a] == target) {
                    return a;
                } else if (nums[a] < target) {
                    return a + 1;
                } else {
                    if (a == 0) {
                        return 0;
                    } else {
                        return a - 1;
                    }
                }
            }
            int d = c / 2;
            int e = a + d;
            if (nums[e] == target) {
                return e;
            }else {
                if (c==1){
                    if (target>=nums[b]){
                        a=b;
                    }else {
                        b=a;
                    }
                }else {
                    if (nums[e] < target) {
                        a = e;
                    } else {
                        b = e;
                    }
                }
            }
        }
    }
}
