package com.yeyouliang.others;

/**
 * Created by YYL on 2021/4/11 : 10:54.
 */
public class GiveChange {
    /**
     * 找零
     * 纸币有四种：10,50,100,500，对指定面额纸币进行找零，总数不超过15张。有多少种组合？
     */
    public static void main(String[] args) {
        int[] ints = {500, 100, 50, 10};
        int num = 1000;
        int index = 0;
        int time = 0;
        int[] count = new int[1];
        gc(ints, index, num, time, count);
        System.out.println("count:"+count[0]);
    }

    public static void gc(int[] ints, int index, int num, int time, int[] count) {
        if (num == 0 && time <= 15) {
            count[0]++;
            System.out.println(time);
            return;
        }
        if (index == ints.length || time > 15) {
            return;
        }
        for (int i = 0; i < 15; i++) {
            int diff = num - ints[index] * i;
            if (diff >= 0) {
                gc(ints, index + 1, diff, time + i, count);
            } else {
                break;
            }
        }
    }
}
