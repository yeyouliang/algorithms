package com.yeyouliang.array;

import java.util.Arrays;

/**
 * Created by YYL on 2021/5/21 : 20:54.
 */
public class MoveArrays {
    /**
     * 何把一个数组循环右移k位
     * 假设要把数组序列12345678右移2位变为78123456
     */
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
        int wei = 7;
        int y = wei % ints.length;
        if (y != 0) {
            int[] in = new int[ints.length];
            int index = in.length - 1;
            for (int i = ints.length - wei - 1; i >= 0; i--) {
                in[index--] = ints[i];
            }
            index = wei - 1;
            for (int i = ints.length - 1; i > ints.length - wei - 1; i--) {
                in[index--] = ints[i];
            }
            ints = in;
        }
        System.out.println(Arrays.toString(ints));
    }
}
