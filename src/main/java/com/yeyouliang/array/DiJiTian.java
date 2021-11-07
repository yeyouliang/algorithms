package com.yeyouliang.array;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/7 : 9:45.
 */
public class DiJiTian {
    /**
     * 输入年月日，计算该日期是这一年的第几天。
     * */
    public static void main(String[] args) {
        int[][] ints = {
                {2021, 1, 1},
                {2021, 1, 18},
                {2021, 2, 1},
                {2021, 2, 19},
                {2021, 2, 28},
                {2021, 3, 1},
                {2000, 3, 1},
                {1993, 7, 1},
                {2008, 8, 8},
                {2021, 11, 7},
                {1980, 11, 28},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + djt(anInt));
        }
    }

    private static int djt(int[] ints) {
        int count = 0;
        int a = ints[0];
        int b = ints[1];
        int c = ints[2];
        for (int i = 1; i < b; i++) {
            if (i == 2) {
                if (isRunNian(a)) {
                    count += 29;
                } else {
                    count += 28;
                }
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                count += 30;
            } else {
                count += 31;
            }
        }
        count += c;
        return count;
    }

    private static boolean isRunNian(int nian) {
        return nian % 400 == 0 || (nian % 4 == 0 && nian % 100 != 0);
    }
}
