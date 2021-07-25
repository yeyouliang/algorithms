package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/7/24 : 15:14.
 */
public class ChinaBrickStyle {
    /**
     * 宽
     */
    private static int wide = 3;
    /**
     * 高
     */
    private static int high = 2;

    /**
     * 磁砖样式
     * https://blog.csdn.net/weixin_41793113/article/details/89071705
     * 小明家的一面装饰墙原来是 3*10 的小方格。
     * 现在手头有一批刚好能盖住2个小方格的长方形瓷砖。
     * 瓷砖只有两种颜色：黄色和橙色。
     * 小明想知道，对于这么简陋的原料，可以贴出多少种不同的花样来。
     * 小明有个小小的强迫症：忍受不了任何2*2的小格子是同一种颜色。
     * （瓷砖不能切割，不能重叠，也不能只铺一部分。另外，只考虑组合图案，请忽略瓷砖的拼缝）
     * 显然，对于 2*3 个小格子来说，口算都可以知道：一共10种贴法。
     * 但对于 3*10 的格子呢？肯定是个不小的数目，请你利用计算机的威力算出该数字。
     */
    public static void main(String[] args) {
        List<Integer> collect = IntStream.rangeClosed(1, wide * high).boxed().collect(Collectors.toList());
        List<Integer> integers = Stream.generate(() -> 0).limit(wide * high).collect(Collectors.toList());
        int[] count = new int[2];
        cbs(collect, integers, count);
        System.out.println(count[0] + "," + count[1]);
    }

    /**
     * integers值有三种类型：0，1，2。0为初始值，表示未放置
     */
    private static void cbs(List<Integer> collect, List<Integer> integers, int[] count) {
        if (!collect.isEmpty()) {
            Integer a = collect.get(0);
            //判断是否是第三列
            if (a % wide == 0) {
                //第三列只能垂直放，排除右上角
                if (a != wide * high) {
                    for (int i = 1; i < 3; i++) {
                        List<Integer> co1 = new ArrayList<>(collect);
                        List<Integer> in1 = new ArrayList<>(integers);
                        co1.remove(0);
                        co1.remove(Integer.valueOf(a + 3));
                        in1.set(a - 1, i);
                        in1.set(a + 3 - 1, i);
                        cbs(co1, in1, count);
                    }
                }
            } else {
                Integer b = integers.get(a + 1 - 1);
                //判断能否横放
                if (b.equals(0)) {
                    for (int i = 1; i < 3; i++) {
                        List<Integer> co1 = new ArrayList<>(collect);
                        List<Integer> in1 = new ArrayList<>(integers);
                        co1.remove(0);
                        co1.remove(Integer.valueOf(a + 1));
                        in1.set(a - 1, i);
                        in1.set(a + 1 - 1, i);
                        cbs(co1, in1, count);
                    }
                }
                //顶部一行不能垂直放置
                if (a < wide * high - wide) {
                    for (int i = 1; i < 3; i++) {
                        List<Integer> co1 = new ArrayList<>(collect);
                        List<Integer> in1 = new ArrayList<>(integers);
                        co1.remove(0);
                        co1.remove(Integer.valueOf(a + 3));
                        in1.set(a - 1, i);
                        in1.set(a + 3 - 1, i);
                        cbs(co1, in1, count);
                    }
                }
            }
        } else {
            if (check(integers)) {
                System.out.println(integers);
                count[0]++;
            } else {
                count[1]++;
            }
        }
    }

    /**
     * 检查是否有2*2的小格子是同一种颜色
     */
    private static boolean check(List<Integer> integers) {
        boolean falg = true;
        for (int i = 1; i < wide * high - wide; i++) {
            if (i % 3 != 0) {
                Integer a = integers.get(i - 1);
                Integer b = integers.get(i + 1 - 1);
                Integer c = integers.get(i + 3 - 1);
                Integer d = integers.get(i + 4 - 1);
                if (a == 0 || b == 0 || c == 0 || d == 0) {
                    falg = false;
                    break;
                } else {
                    if (a.equals(b) && b.equals(c) && c.equals(d)) {
                        falg = false;
                        break;
                    }
                }
            }
        }
        return falg;
    }
}
