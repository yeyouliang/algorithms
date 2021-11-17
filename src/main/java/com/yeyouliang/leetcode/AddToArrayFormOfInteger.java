package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by YYL on 2021/10/18 : 17:33.
 */
public class AddToArrayFormOfInteger {
    /**
     * 989. 数组形式的整数加法
     * */
    public static void main(String[] args) {
        int[][][] ints = {
                {{9, 9}, {9}},
                {{0}, {911}},
                {{0}, {0}},
                {{0}, {10}},
                {{1, 2, 0, 0}, {34}},
                {{1, 2, 0, 0}, {344}},
                {{1, 2, 0, 0}, {3443}},
                {{2, 7, 4}, {181}},
                {{2, 1, 5}, {806}},
                {{9}, {0}},
                {{9}, {9}},
                {{9}, {99}},
                {{0}, {2}},
                {{1, 0, 0, 0, 1}, {0}},
                {{1, 0, 0, 0, 9}, {1}},
                {{1, 0, 0, 0, 9}, {9}},
                {{1, 0, 0, 0, 9}, {99}},
                {{1, 0, 0, 0, 9}, {999}},
                {{1, 9, 9, 9, 9}, {1}},
                {{1, 9, 9, 9, 9}, {9}},
                {{9, 9, 9, 9, 9}, {9}},
                {{9, 9, 9, 9, 9}, {99}},
                {{9, 9, 9, 9, 9}, {999}},
                {{1, 0, 0, 9, 9}, {1}},
                {{1, 0, 0, 0, 1}, {2}},
                {{1, 0, 0, 0, 1, 0}, {1}},
        };
        for (int[][] string : ints) {
            System.out.println(Arrays.toString(string[0]));
            System.out.println(Arrays.toString(string[1]));
            System.out.println(addToArrayForm(string[0], string[1][0]));
            System.out.println("----------------------------------------");
        }
    }

    private static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        String a = String.valueOf(k);
        int b = 0;
        int c = num.length - 1;
        for (int j = a.length() - 1; j >= 0; j--) {
            int d = Integer.parseInt(a.substring(j, j + 1));
            int e = c < 0 ? 0 : num[c];
            int f = b + d + e;
            if (f > 9) {
                list.add(f - 10);
                b = 1;
            } else {
                list.add(f);
                b = 0;
            }
            c--;
        }
        if (c >= 0) {
            for (int i = c; i >= 0; i--) {
                int g = b + num[i];
                if (g > 9) {
                    list.add(0);
                    b = 1;
                } else {
                    list.add(g);
                    b = 0;
                }
            }
        }
        if (b > 0) {
            list.add(1);
        }
        Collections.reverse(list);
        return list;
    }
}
