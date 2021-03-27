package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/3/27 : 9:53.
 */
public class BuildingBlock {
    /**
     * 搭积木
     * 一共有10块积木，每个积木上有一个数字，0～9.
     * 搭积木规则：每个积木放到其他两个积木的上面，并且一定比下面的两个积木数字小。最后搭成4层的金字塔形，必须用完所有的积木。
     * 案例：
     *    0
     *   3 1
     *  7 5 2
     * 9 8 6 4
     */
    public static void main(String[] args) {
        int[] count = {0};
        bb(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0), new ArrayList<>(), count);
        System.out.println(count[0]);
    }

    public static void bb(List<Integer> start, List<Integer> changed, int[] count) {
        if (start.size() == 0) {
            System.out.println(changed);
            count[0]++;
            return;
        }
        int size = changed.size();
        List<Integer> index = new ArrayList<>();
        if (size == 0) {
            index.add(-1);
        } else if (size == 1 || size == 2) {
            index.add(0);
        } else if (size == 3) {
            index.add(1);
        } else if (size == 4) {
            index.add(1);
            index.add(2);
        } else if (size == 5) {
            index.add(2);
        } else if (size == 6) {
            index.add(3);
        } else if (size == 7) {
            index.add(3);
            index.add(4);
        } else if (size == 8) {
            index.add(4);
            index.add(5);
        } else if (size == 9) {
            index.add(5);
        }
        for (Integer integer : start) {
            for (Integer i : index) {
                if (i != -1 && changed.get(i) > integer) {
                    return;
                }
            }
            List<Integer> st = new ArrayList<>(start);
            st.remove(integer);
            List<Integer> ch = new ArrayList<>(changed);
            ch.add(integer);
            bb(st, ch, count);
        }
    }
}
