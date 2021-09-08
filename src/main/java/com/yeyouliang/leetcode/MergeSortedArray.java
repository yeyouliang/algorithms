package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/9/8 : 19:51.
 */
public class MergeSortedArray {
    /**
     * 88. 合并两个有序数组
     * */
    public static void main(String[] args) {
        int[][][] ints = {
                {{1, 2, 3, 0, 0, 0}, {3}, {2, 5, 6}, {3}},
                {{1, 2, 3, 0, 0, 0}, {3}, {4, 5, 6}, {3}},
                {{1, 2, 9, 0, 0, 0}, {3}, {4, 5, 6}, {3}},
                {{1, 8, 9, 0, 0, 0}, {3}, {4, 5, 6}, {3}},
                {{7, 8, 9, 0, 0, 0}, {3}, {4, 5, 6}, {3}},
                {{1, 4, 7, 0, 0, 0}, {3}, {2, 5, 8}, {3}},
                {{2, 5, 8, 0, 0, 0}, {3}, {1, 4, 7}, {3}},
                {{1, 2, 5, 8, 0, 0, 0}, {4}, {1, 4, 7}, {3}},
                {{2, 4, 4, 5, 8, 0, 0, 0}, {5}, {1, 4, 7}, {3}},
                {{1, 4, 4, 5, 8, 0, 0, 0}, {5}, {1, 4, 7}, {3}},
                {{1}, {1}, {}, {0}},
                {{0}, {0}, {1}, {1}},
        };
        for (int[][] anInt : ints) {
            System.out.println(Arrays.toString(anInt[0]) + "--" + anInt[1][0] + "--" + Arrays.toString(anInt[2]) + "--" + anInt[3][0]);
            merge(anInt[0], anInt[1][0], anInt[2], anInt[3][0]);
        }
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i]=nums2[i];
            }
        } else if (n != 0) {
            int a = m - 1;
            int b = n - 1;
            int c = m + n - 1;
            while (true) {
                if (a < 0) {
                    for (int i = 0; i <= c; i++) {
                        nums1[i] = nums2[i];
                    }
                    break;
                }
                if (b < 0) {
                    break;
                }
                if (nums1[a] > nums2[b]) {
                    nums1[c] = nums1[a];
                    a--;
                } else {
                    nums1[c] = nums2[b];
                    b--;
                }
                c--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}
