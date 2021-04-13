package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/4/13 : 22:10.
 */
public class Jiao {
    public static void main(String[] args) {
        int up = 5;
        int down = 7;
        int one = 1;
        int two = 8;
        int three = 2;
        int four = 3;
        int[] ints = {4, 6, 9, 10, 11, 12};
        for (int i = 0; i < ints.length; i++) {
            int count = up + one + ints[i] + down;
            for (int j = 0; j < ints.length; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < ints.length; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    for (int l = 0; l < ints.length; l++) {
                        if (i == l || j == l || k == l) {
                            continue;
                        }
                        for (int m = 0; m < ints.length; m++) {
                            if (i == m || j == m || k == m || l == m) {
                                continue;
                            }
                            for (int n = 0; n < ints.length; n++) {
                                if (i == n || j == n || k == n || l == n || m == n) {
                                    continue;
                                }
                                int h1 = two + up + ints[j] + ints[k];
                                int p = ints[k] + ints[l] + ints[m] + four;
                                int nn = one + ints[j] + ints[l] + ints[n];
                                int h2 = down + three + ints[m] + ints[n];
                                if (h1 == count && p == count && nn == count && h2 == count) {
                                    System.out.println("" + i + "," + j + "," + k + "," + l + "," + m + "," + n);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
