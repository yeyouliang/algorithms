package com.yeyouliang.others;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by YYL on 2021/5/12 : 19:49.
 */
public class OneSquareEqualTwoRectangle {
    /**
     * 正方形和长方形的面积
     * 长度相同的三条绳子，其中一条围成一个正方形，另外两条围成长方形。正方形和两个长方形的面积相同。求从1到500长度的绳子中符合要求的有多少？（等比例放大的不算）
     * */
    public static void main(String[] args) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 4; i <= 500; i += 4) {
            if (!set.contains(i)) {
                int j = 6;
                int diff = i - j;
                boolean flag = false;
                while (diff >= 6 && j < diff) {
                    int a = i;
                    while (a <= 500) {
                        set.add(a);
                        a += i;
                        flag = true;
                    }
                    j += 2;
                    diff = i - j;
                }
                if (flag) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
