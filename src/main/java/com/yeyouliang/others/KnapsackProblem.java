package com.yeyouliang.others;

/**
 * Created by YYL on 2021/4/8 : 21:46.
 */
public class KnapsackProblem {
    /**
     *背包问题，动态规划
     * */
    public static void main(String[] args) {
        int bk = 4;
        int[] z = {3, 4, 1};
        int[] v = {200, 150, 300};
        int[][] a = new int[z.length + 1][bk + 1];
        for (int j = 1; j < z.length + 1; j++) {//可选择的物品
            for (int i = 1; i < bk + 1; i++) {//背包的容量
                if (z[j - 1] <= i) {
                    int diff = i - z[j - 1];
                    a[j][i] = Math.max(v[j - 1] + a[j - 1][diff], a[j - 1][i]);
                }else {
                    a[j][i]=a[j-1][i];
                }
            }
        }
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt+",");
            }
            System.out.println();
        }
    }
}
