package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/2/3 : 21:20.
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] ints = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length = ints.length;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if (ints[i] == ints[j]) {
                    if (j != length - 1) {
                        for (int k = j; k < length - 1; k++) {
                            ints[k] = ints[k + 1];
                        }
                        ints[length - 1] = ints[0];
                    }
                }
            }
        }
        System.out.println(Arrays.toString(ints));
        if (ints[0] == ints[length - 1]) {
            ints[length - 1] = 1;
            for (int i = 1; i < ints.length - 1; i++) {
                if (ints[0] == ints[i]) {
                    ints[length - 1] += 1;
                }
            }
            System.out.println(length - ints[length - 1]);
        } else {
            System.out.println(length);
        }
    }
}
