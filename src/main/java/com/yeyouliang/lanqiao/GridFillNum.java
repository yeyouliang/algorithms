package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/4/2 : 21:36.
 */
public class GridFillNum {
    /**
     * 方格填数
     * 如下的10个格子，填入0～9的数字。要求：连续的两个数字不能相邻（左右、上下、对角都算相邻）。一共有多少种可能的填数方案？
     *    [][][]
     * [][][][]
     * [][][]
     * */
    public static void main(String[] args) {
        int[] count = {0};
        gfn(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0), new ArrayList<>(), count);
        System.out.println(count[0]);
    }

    public static void gfn(List<Integer> start, List<Integer> changed, int[] count) {
        if (start.size() == 0) {
            System.out.println(changed);
            count[0]++;
            return;
        }
        int size = changed.size();
        List<Integer> index = new ArrayList<>();
        if (size == 0) {
            index.add(-1);
        } else if (size == 1) {
            index.add(0);
        } else if (size == 2) {
            index.add(0);
            index.add(1);
        } else if (size == 3) {
            index.add(0);
            index.add(1);
            index.add(2);
        } else if (size == 4) {
            index.add(2);
            index.add(3);
        } else if (size == 5) {
            index.add(1);
            index.add(3);
        } else if (size == 6) {
            index.add(2);
            index.add(3);
            index.add(4);
            index.add(5);
        } else if (size == 7) {
            index.add(3);
            index.add(5);
            index.add(6);
        } else if (size == 8) {
            index.add(4);
            index.add(6);
            index.add(7);
        } else if (size == 9) {
            index.add(6);
            index.add(7);
            index.add(8);
        }
        for (Integer integer : start) {
            boolean cross=true;
            for (Integer i : index) {
                if (i != -1 && Math.abs(changed.get(i) - integer) < 2) {
                    cross=false;
                    break;
                }
            }
            if (cross){
                List<Integer> st = new ArrayList<>(start);
                st.remove(integer);
                List<Integer> ch = new ArrayList<>(changed);
                ch.add(integer);
                gfn(st, ch, count);
            }
        }
    }
}
