package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/3/24 : 21:05.
 */
public class PascalsTriangle {
    /**
     * 输入: 5
     * 输出:
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     */
    public static void main(String[] args) {
        List<List<Integer>> ill = generate(10);
        for (List<Integer> il : ill) {
            for (Integer i : il) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lli = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> integers = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (i < 3 || j == 0 || j == i - 1) {
                    integers.add(1);
                } else {
                    List<Integer> last = lli.get(lli.size() - 1);
                    integers.add(last.get(j - 1) + last.get(j));
                }
            }
            lli.add(integers);
        }
        return lli;
    }
}
