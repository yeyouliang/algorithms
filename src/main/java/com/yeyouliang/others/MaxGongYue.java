package com.yeyouliang.others;

/**
 * Created by YYL on 2021/4/19 : 20:31.
 */
public class MaxGongYue {
    /**
     * 最大公约数
     */
    public static void main(String[] args) {
        int a = 30;
        int b = 56;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        if (max % min == 0) {
            System.out.println(min);
        } else {
            int x = 2;
            int y = min % x;
            int yy = min / x;
            while (true) {
                if (x == min) {
                    break;
                }
                if (y != 0) {
                    if (x > min / 2) {
                        break;
                    }
                } else {
                    if (max % yy == 0) {
                        System.out.println(yy);
                        return;
                    }
                }
                x++;
                y = min % x;
                yy = min / x;
            }
            System.out.println(1);
        }
    }
}
