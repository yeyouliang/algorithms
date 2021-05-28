package com.yeyouliang.array;

/**
 * Created by YYL on 2021/5/22 : 14:39.
 */
public class SearchMax {
    /**
     * 用递归方法求一个整数数组的最大元素
     * */
    public static void main(String[] args) {
        int[] ints = {0, 16, 2, 3, 4, 5, 10, 7, 8, 9};
        System.out.println(sm(ints, 0, ints[0]));
    }

    public static int sm(int[] ints, int index, int max) {
        if (index == ints.length) {
            return max;
        } else {
            return sm(ints, index + 1, Math.max(max, ints[index]));
        }
    }
}
