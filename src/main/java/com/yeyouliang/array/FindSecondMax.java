package com.yeyouliang.array;

/**
 * Created by YYL on 2021/5/18 : 21:08.
 */
public class FindSecondMax {
    /**
     * 找出数组中第二大的数
     */
    public static void main(String[] args) {
        //int[] ints = {-1, 1, -3, 4, 1, 2, -5, 4, -2};
        int[] ints = {7, 3, 19, 40, 4, 7, 1};
        one(ints);
    }

    public static void one(int[] ints) {
        int vice = Math.min(ints[0], ints[1]);
        int master = Math.max(ints[0], ints[1]);
        for (int i = 2; i < ints.length; i++) {
            if (ints[i] > master) {
                vice = master;
                master = ints[i];
            } else if (ints[i] != master) {
                if (vice == master) {
                    vice = ints[i];
                } else {
                    if (vice < ints[i]) {
                        vice = ints[i];
                    }
                }
            }
        }
        System.out.println(vice);
    }
}
