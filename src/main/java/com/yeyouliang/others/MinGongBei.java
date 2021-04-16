package com.yeyouliang.others;

/**
 * Created by YYL on 2021/4/16 : 19:33.
 */
public class MinGongBei {
    /**
     * 最小公倍数
     * */
    public static void main(String[] args) {
        int a = 12;
        int b = 16;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        if (max % min == 0) {
            System.out.println(max);
        } else {
            int ji = min * max;
            for (int i = 2; i < min; i++) {
                int c = max * i;
                if (c % min == 0) {
                    System.out.println(c);
                    return;
                }
            }
            System.out.println(ji);
        }
    }
}
