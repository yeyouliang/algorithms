package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/10/20 : 20:29.
 */
public class ThreeDivisors {
    /**
     * 1952. 三除数
     * */
    public static void main(String[] args) {
        /*int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9,100,10000};
        for (int anInt : ints) {
            System.out.println(anInt+":"+isThree(anInt));
        }*/
        for (int i = 1; i < 10000; i++) {
            if (isThree(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isThree(int n) {
        if (n > 3) {
            breakOut:
            for (int i = 2; i <= 100; i++) {
                if (i * i == n) {
                    for (int j = 2; j < i; j++) {
                        if (i * i % j == 0) {
                            break breakOut;
                        }
                    }
                    return true;
                } else if (i * i > n) {
                    break;
                }
            }
        }
        return false;
    }
}
