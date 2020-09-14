package com.yeyouliang.number;

import org.junit.Test;

/**
 * Created by YYL on 2020/9/13.
 */
public class Nine {

    /*
    * 请看下面的算式：(ABCD - EFGH) * XY = 900每个字母代表一个0~9的数字，不同字母代表不同数字，首位不能为0。
    * 比如，(5012 - 4987) * 36 就是一个解。请找到另一个解，并提交该解中 ABCD 所代表的整数。
    * */
    @Test
    public void nine() {
        int[] ints = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        for (int i = 1; i <= 9; i++) {//1
            for (int j = 0; j <= 9; j++) {//2
                if (i == j || 900 % (i * 10 + j) != 0) {
                    continue;
                }
                ints[i] = 0;
                ints[j] = 0;
                for (int k = 1; k <= 9; k++) {//3
                    if (ints[k] == 0) {
                        continue;
                    }
                    ints[k] = 0;
                    for (int l = 0; l <= 9; l++) {//4
                        if (ints[l] == 0) {
                            continue;
                        }
                        ints[l] = 0;
                        for (int m = 0; m <= 9; m++) {//5
                            if (ints[m] == 0) {
                                continue;
                            }
                            ints[m] = 0;
                            for (int n = 0; n <= 9; n++) {//6
                                if (ints[n] == 0) {
                                    continue;
                                }
                                ints[n] = 0;
                                for (int o = 1; o <= 9; o++) {//7
                                    if (ints[o] == 0) {
                                        continue;
                                    }
                                    ints[o] = 0;
                                    for (int p = 0; p <= 9; p++) {//8
                                        if (ints[p] == 0) {
                                            continue;
                                        }
                                        ints[p] = 0;
                                        for (int q = 0; q <= 9; q++) {//9
                                            if (ints[q] == 0) {
                                                continue;
                                            }
                                            ints[q] = 0;
                                            for (int r = 0; r <= 9; r++) {//10
                                                if (ints[r] == 0) {
                                                    continue;
                                                }
                                                if ((i * 10 + j) * ((k * 1000 + l * 100 + m * 10 + n) - (o * 1000 + p * 100 + q * 10 + r)) == 900) {
                                                    System.out.println("" + k + l + m + n + ("," + o + p + q + r)+(","+i+j));
                                                }
                                            }
                                            ints[q] = -1;
                                        }
                                        ints[p] = -1;
                                    }
                                    ints[o] = -1;
                                }
                                ints[n] = -1;
                            }
                            ints[m] = -1;
                        }
                        ints[l] = -1;
                    }
                    ints[k] = -1;
                }
                ints[i] = -1;
                ints[j] = -1;
            }
        }
    }
}
