package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/4/3 : 6:46.
 */
public class DistributeChocolates {
    /**
     * 切巧克力
     * 将若干块巧克力分给k个小朋友，都是正方形且大小相同，能切的正方形的最大边长是多少？
     * */
    public static void main(String[] args) {
        int[][] ints = {{15, 6}, {9, 5}, {9, 5}};
        int k = 10;
        int count = 0;
        for (int[] anInt : ints) {
            count += anInt[0] * anInt[1];
        }
        int yu = (int) Math.sqrt(count / k);
        for (int i = yu; i > 1; i--) {
            int c = 0;
            for (int[] anInt : ints) {
                int a = anInt[0] / 2;
                int b = anInt[1] / 2;
                c += a * b;
            }
            if (c >= k) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(1);
    }
}
