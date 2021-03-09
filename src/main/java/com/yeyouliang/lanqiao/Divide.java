package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/3/9 : 21:47.
 */
public class Divide {

    /**
     * 用1-9更个数字不重复地套进公式，使公式成立。
     * A+B/C+DEF/GHI=10
     */
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k < 10; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    for (int l = 1; l < 10; l++) {
                        if (i == l || j == l || k == l) {
                            continue;
                        }
                        for (int m = 1; m < 10; m++) {
                            if (i == m || j == m || k == m || l == m) {
                                continue;
                            }
                            for (int n = 1; n < 10; n++) {
                                if (i == n || j == n || k == n || l == n || m == n) {
                                    continue;
                                }
                                for (int o = 1; o < 10; o++) {
                                    if (i == o || j == o || k == o || l == o || m == o || n == o) {
                                        continue;
                                    }
                                    for (int p = 1; p < 10; p++) {
                                        if (i == p || j == p || k == p || l == p || m == p || n == p || o == p) {
                                            continue;
                                        }
                                        for (int q = 1; q < 10; q++) {
                                            if (i == q || j == q || k == q || l == q || m == q || n == q || o == q || p == q) {
                                                continue;
                                            }
                                            int lmn = Integer.valueOf("" + l + m + n);
                                            int opq = Integer.valueOf("" + o + p + q);
                                            int yu = opq % k;
                                            int bc = opq / k;
                                            if (yu == 0) {
                                                if (i * opq + j * bc + lmn == opq * 10) {
                                                    System.out.println("" + i + "," + j + "," + k + "," + lmn + "," + opq);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
