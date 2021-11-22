package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/7 : 10:03.
 */
public class PalindromicPrimeNumber {
    /**
     * 回文素数：
     * 回文数就是顺着读和倒着读一样的数(例如：11，121，1991…)，回文素数就是既是回文数又是素数(只能被1和自身整除的数)的数。编程找出11～9999之间的回文素数。
     */
    public static void main(String[] args) {
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                String a = "";
                for (int k = 0; k < i; k++) {
                    a += j;
                }
                if (a.length() == 2) {
                    if (!"00".equals(a)) {
                        if (ppn(Integer.parseInt(a))) {
                            System.out.println(a);
                        }
                    }
                }
                for (int l = 1; l < 10; l++) {
                    String b = l + a + l;
                    int c = Integer.parseInt(b);
                    if (ppn(c)) {
                        System.out.println(c);
                    }
                }
            }
        }
    }

    private static boolean ppn(int num) {
        int a = num / 2;
        for (int i = 2; i <= a; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
