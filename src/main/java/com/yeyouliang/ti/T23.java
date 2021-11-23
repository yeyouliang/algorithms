package com.yeyouliang.ti;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/11/22 : 22:14.
 */
public class T23 {
    public static void main(String[] args) {
        m1(new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0});
    }

    /**
     * 对10个数进行排序。
     */
    private static void m1(int[] a) {
        List<Integer> list = new ArrayList<>();
        for (int i : a) {
            if (list.isEmpty()) {
                list.add(i);
            } else {
                int b = list.size();
                for (int j = list.size() - 1; j >= 0; j--) {
                    int c = list.get(j);
                    if (c <= i) {
                        list.add(j + 1, i);
                        break;
                    }
                }
                if (b == list.size()) {
                    list.add(0, i);
                }
            }
        }
        System.out.println(list);
    }
}
