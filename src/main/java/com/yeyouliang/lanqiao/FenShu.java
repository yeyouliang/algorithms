package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/3/31 : 22:11.
 */
public class FenShu {
    /**
     * 分数相加
     * 1/1 + 1/2 + 1/4 + 1/8 + 1/16 + ....
     * 每项是前一项的一半，如果一共有20项,
     * 求这个和是多少，结果用分数表示出来。
     * 分子分母要求互质。
     */
    public static void main(String[] args) {
        int b = 1;
        List<List<Integer>> lli = new ArrayList<>();
        List<Integer> li = Arrays.asList(1, 1);
        lli.add(li);
        for (int i = 1; i < 6; i++) {
            b *= 2;
            List<List<Integer>> lists = new ArrayList<>();
            for (List<Integer> list : lli) {
                lists.add(Arrays.asList(list.get(0) * 2, list.get(1) * 2));
            }
            lists.add(Arrays.asList(1, b));
            lli = lists;
        }
        int u = 0;
        int d = lli.get(0).get(1);
        for (List<Integer> list : lli) {
            u += list.get(0);
        }
        System.out.println(u + "," + d);
        System.out.println(Arrays.toString(chu(u,d)));
    }

    public static int[] chu(int a, int b) {
        int[] re = null;
        if (a == 1 || b == 1) {
            return new int[]{a, b};
        } else {
            int min = Math.min(a, b);
            for (int i = 2; i <= min; i++) {
                if (a % i == 0 && b % i == 0) {
                    re = new int[]{a / i, b / i};
                    System.out.println("---");
                    break;
                }
            }
            if (re == null) {
                return new int[]{a, b};
            } else {
                return chu(re[0], re[1]);
            }
        }
    }
}
