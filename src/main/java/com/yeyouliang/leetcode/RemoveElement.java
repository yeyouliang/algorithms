package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/2/2 : 20:44.
 */
public class RemoveElement {
    public static void main(String[] args) {//​LeetCode刷题实战27：移除元素
        int target = 2;
        int[] ints = {0, 1, 2, 2, 3, 0, 4, 2};
        int length = ints.length;
        for (int i = length - 1; i >= 0; i--) {
            if (target == ints[i]) {
                if (i != length - 1) {
                    for (int j = i + 1; j < length; j++) {
                        ints[j - 1] = ints[j];
                    }
                    ints[length - 1] = target;
                }
            }
        }
        System.out.println(Arrays.toString(ints));
        if (ints[length - 1] == target) {
            ints[length - 1] = 1;
            for (int i = length - 2; i >= 0; i--) {
                if (ints[i] == target) {
                    ints[length - 1] += 1;
                }
            }
            System.out.println(length - ints[length - 1]);
        } else {
            System.out.println(length);
        }
    }
}
