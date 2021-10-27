package com.yeyouliang.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/10/27 : 10:15.
 */
public class Offer57_1 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int anInt : ints) {
            int[][] a = findContinuousSequence(anInt);
            System.out.println(anInt + ":" + a.length);
        }
    }

    private static int[][] findContinuousSequence(int target) {
        int[][] ints = new int[0][0];
        if (target > 2) {
            int a;
            if (target % 2 == 0) {
                a = target / 2;
            } else {
                a = target / 2 + 1;
            }
            List<List<Integer>> lli = new ArrayList<>();
            for (int i = a; i > 0; i--) {
                List<Integer> list = new ArrayList<>();
                int b = target;
                int c = i;
                while (true) {
                    list.add(c);
                    b = b - c;
                    if (b == 0) {
                        break;
                    } else if (b < 0) {
                        list.clear();
                        break;
                    }
                    c--;
                    if (c == 0) {
                        list.clear();
                        break;
                    }
                }
                if (list.size() > 1) {
                    lli.add(list);
                }
            }
        }
        return ints;
    }
}
