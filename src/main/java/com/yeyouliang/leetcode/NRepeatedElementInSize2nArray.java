package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/10/18 : 10:47.
 */
public class NRepeatedElementInSize2nArray {
    /**
     * 961. 在长度 2N 的数组中找出重复 N 次的元素
     * */
    public static void main(String[] args) {
        int[][] ints = {
                {1, 2, 3, 3},
                {2, 1, 2, 5, 3, 2},
                {5, 1, 5, 2, 5, 3, 5, 4},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + repeatedNTimes(anInt));
        }
    }

    private static int repeatedNTimes(int[] nums) {
        int a = -1;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.contains(num)) {
                a = num;
                break;
            } else {
                list.add(num);
            }
        }
        return a;
    }
}
