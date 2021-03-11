package com.yeyouliang.lanqiao;

import java.util.Arrays;

/**
 * Created by YYL on 2021/3/11 : 19:57.
 */
public class ExchangeBottle {
    /**
     * 有N个瓶子，编号 1 ~ N，放在架子上。
     * 比如有5个瓶子：
     * 2 1 3 5 4
     * 要求每次拿起2个瓶子，交换它们的位置。
     * 经过若干次后，使得瓶子的序号为：
     * 1 2 3 4 5
     * 对于这么简单的情况，显然，至少需要交换2次就可以复位。
     * 如果瓶子更多呢？你可以通过编程来解决。
     */
    public static void main(String[] args) {
        int[] ints = {5, 4, 3, 2, 1};
        print(0, ints, 0);
    }

    public static void print(int index, int[] ints, int count) {
        if (index == ints.length) {
            System.out.println(Arrays.toString(ints) + "," + count);
            return;
        }
        if (ints[index] != index + 1) {
            int tmp = ints[ints[index] - 1];
            ints[ints[index] - 1] = ints[index];
            ints[index] = tmp;
            print(index, ints, ++count);
        } else {
            print(index + 1, ints, count);
        }
    }
}
