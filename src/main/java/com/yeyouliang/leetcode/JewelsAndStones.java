package com.yeyouliang.leetcode;

import java.util.Arrays;

/**
 * Created by YYL on 2021/10/17 : 20:05.
 */
public class JewelsAndStones {
    /**
     * 771. 宝石与石头
     * */
    public static void main(String[] args) {
        String[][] strings = {
                {"aA", "aAAbbbb"},
                {"z", "ZZ"},
        };
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string) + ":" + numJewelsInStones(string[0], string[1]));
        }
    }

    private static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (String s : jewels.split("")) {
            if (!stones.isEmpty()) {
                while (stones.contains(s)) {
                    int index = stones.indexOf(s);
                    stones = stones.substring(0, index) + stones.substring(index + 1, stones.length());
                    count++;
                }
            } else {
                break;
            }
        }
        return count;
    }
}
