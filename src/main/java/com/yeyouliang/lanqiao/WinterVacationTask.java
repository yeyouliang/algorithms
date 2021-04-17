package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/4/15 : 22:26.
 */
public class WinterVacationTask {
    /**
     * 寒假作业
     * 每个方块代表1～13中的某一个数字，但不能重复。
     * | |+| |=| |
     * | |-| |=| |
     * | |×| |=| |
     * | |/| |=| |
     * 比如：
     * 6+7=13
     * 9-8=1
     * 3×4=12
     * 10/2=5
     * 以及：
     * 7+6=13
     * 9-8=1
     * 3×4=12
     * 10/2=5
     * 就算两种解法（加法，乘法交换律后算不同的方案）。你一共找到了多少种方案？
     */
    public static void main(String[] args) {
        List<Integer> origin = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13).collect(Collectors.toList());
        List<Integer> has = new ArrayList<>();
        int[] count = new int[1];
        wvt(origin, has, count);
        System.out.println(count[0]);
    }

    public static void wvt(List<Integer> origin, List<Integer> has, int[] count) {
        if (has.size() == 3) {
            if (has.get(0) + has.get(1) != has.get(2)) {
                return;
            }
        }
        if (has.size() == 6) {
            if (has.get(3) < has.get(4) || has.get(3) - has.get(4) != has.get(5)) {
                return;
            }
        }
        if (has.size() == 9) {
            if (has.get(6) * has.get(7) != has.get(8)) {
                return;
            }
        }
        if (has.size() == 12) {
            if (has.get(9) > has.get(10) && has.get(9) % has.get(10) == 0 && has.get(9) / has.get(10) == has.get(11)) {
                count[0]++;
                System.out.println(has);
            }
            return;
        }
        for (Integer integer : origin) {
            List<Integer> o = new ArrayList<>(origin);
            o.remove(integer);
            List<Integer> h = new ArrayList<>(has);
            h.add(integer);
            wvt(o, h, count);
        }
    }
}
