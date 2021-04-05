package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/4/5 : 16:05.
 */
public class Some {
    /**
     * 小明想知道，满足以下条件的正整数序列的数量：
     * 1. 第一项为 n
     * 2. 第二项不超过 n
     * 3. 从第三项开始，每一项小于前两项的差的绝对值。
     * 请计算，对于给定的 n，有多少种满足条件的序列。
     */
    public static void main(String[] args) {
        int n = 20;
        for (int i = n - 2; i > 1; i--) {
            som(n, i, Arrays.asList(n, i));
        }
    }

    public static void som(int one, int two, List<Integer> list) {
        if (list.size() > 2) {
            System.out.println(list);
            if (list.get(list.size() - 1) == 1) {
                return;
            }
        }
        int diff = one - two;
        for (int i = 1; i < diff && i < two; i++) {
            Integer last = list.get(list.size() - 1);
            List<Integer> li = new ArrayList<>(list);
            li.add(i);
            som(last, i, li);
        }
    }
}
