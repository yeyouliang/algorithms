package com.yeyouliang.ti;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/11/22 : 18:34.
 */
public class T12 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int anInt : ints) {
            System.out.println(anInt + ":" + m1(anInt));
        }
    }

    /**
     * 1,1,2,3,5,8,13,21
     * 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
     */
    private static int m1(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int a = 1;
        while (a < n) {
            List<Integer> newList = new ArrayList<>();
            for (Integer integer : list) {
                if (integer < 3) {
                    newList.add(integer + 1);
                    if (integer == 2) {
                        newList.add(1);
                    }
                } else {
                    newList.add(1);
                    newList.add(3);
                }
            }
            list = newList;
            a++;
        }
        return list.size();
    }
}
