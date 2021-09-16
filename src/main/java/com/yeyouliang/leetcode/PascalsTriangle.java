package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/3/24 : 21:05.
 */
public class PascalsTriangle {
    /**
     * 118. 杨辉三角
     * */
    public static void main(String[] args) {
        System.out.println(generate(3));
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lli = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        lli.add(a);
        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(1);
        if (numRows != 1) {
            lli.add(b);
            if (numRows != 2) {
                while (numRows > 2) {
                    List<Integer> list = lli.get(lli.size() - 1);
                    List<Integer> newList = new ArrayList<>();
                    newList.add(1);
                    for (int i = 1; i < list.size(); i++) {
                        int sum = list.get(i - 1) + list.get(i);
                        newList.add(sum);
                    }
                    newList.add(1);
                    lli.add(newList);
                    numRows--;
                }
            }
        }
        return lli;
    }
}
