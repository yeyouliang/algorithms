package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/6/26 : 22:29.
 */
public class StrungNecklace {
    /**
     * 手链样式
     * 小明有3颗红珊瑚，4颗白珊瑚，5颗黄玛瑙。
     * 他想用它们串成一圈作为手链，送给女朋友。
     * 现在小明想知道：如果考虑手链可以随意转动或翻转，一共可以有多少不同的组合样式呢？
     * */
    public static void main(String[] args) {
        List<String> origin = Arrays.asList("A", "B", "B", "B", "C","C");
        List<String> pool = new ArrayList<>();
        int[] count = new int[3];
        sn(origin, "", pool, count);
        System.out.println(count[0] + "," + (count[2] - count[1]) + "," + count[2]);
    }

    public static void sn(List<String> origin, String result, List<String> pool, int[] count) {
        if (origin.isEmpty()) {
            if (!pool.contains(result)) {
                if (!pool.contains(new StringBuffer(result).reverse().toString())) {
                    count[0]++;
                }
                pool.add(result);
            } else {
                //遇到相同的次数
                count[1]++;
            }
            //全部
            count[2]++;
            return;
        }
        for (String s : origin) {
            String re = result + s;
            List<String> or = new ArrayList<>(origin);
            or.remove(s);
            sn(or, re, pool, count);
        }
    }
}
