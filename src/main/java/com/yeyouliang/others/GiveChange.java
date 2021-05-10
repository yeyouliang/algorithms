package com.yeyouliang.others;

/**
 * Created by YYL on 2021/4/11 : 10:54.
 */
public class GiveChange {
    /**
     * 找零
     * 纸币有四种：10,50,100,500，对指定面额纸币进行找零，总数不超过15张。有多少种组合？
     * */
    public static void main(String[] args) {
        int[] ints = {1, 2, 4};
        int num = 3;
        int[] count = new int[1];
        gc(ints, num, count);
        System.out.println(count[0]);
    }

    public static void gc(int[] ints, int num, int[] count) {
        if (num < 1) {
            if (num == 0) {
                count[0]++;
            }
            return;
        }
        for (int anInt : ints) {
            if (anInt <= num) {
                gc(ints, num - anInt, count);
            }
        }
    }
}
