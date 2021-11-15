package com.yeyouliang.leetcode;

import java.util.*;

/**
 * Created by YYL on 2021/10/19 : 15:07.
 */
public class FindTheTownJudge {
    /**
     * 997. 找到小镇的法官
     * */
    public static void main(String[] args) {
        int[][][] ints = {
                {{2}},
                {{2}, {1, 2}},
                {{3}, {1, 3}, {2, 3}},
                {{3}, {1, 3}, {2, 3}, {3, 1}},
                {{3}, {1, 2}, {2, 3}},
                {{4}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}},
        };
        for (int[][] string : ints) {
            int[][] trust = new int[string.length - 1][2];
            System.arraycopy(string, 1, trust, 0, string.length - 1);
            System.out.println(findJudge(string[0][0], trust));
        }
    }

    private static int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
        if (trust.length > 0) {
            Set<Integer> a = new HashSet<>();
            Map<Integer, Integer> b = new HashMap<>();
            for (int[] ints : trust) {
                int x = ints[0];
                int y = ints[1];
                a.add(x);
                int c = 1;
                if (b.containsKey(y)) {
                    c = b.get(y) + 1;
                }
                b.put(y, c);
            }
            for (Integer integer : b.keySet()) {
                int d = b.get(integer);
                if (d == n - 1 && !a.contains(integer)) {
                    return integer;
                }
            }
        }
        return -1;
    }
}
