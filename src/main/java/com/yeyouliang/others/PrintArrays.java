package com.yeyouliang.others;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/5/16 : 13:54.
 */
public class PrintArrays {
    /**
     * 按要求打印数组的排列情况
     * 问题描述：针对1、2、2、3、4、5这6个数字，写一个函数，打印出所有不同的排列，例如512234、215432等，要求“4”不能在第三位，“3”与“5”不能相连。
     */
    public static void main(String[] args) {
        List<Integer> origin = Stream.of(1, 2, 2, 3, 4, 5).collect(Collectors.toList());
        pa(origin, new ArrayList<>());
    }

    public static void pa(List<Integer> origin, List<Integer> list) {
        if (list.size() == 3 && list.get(2) == 4) {
            System.out.println("====");
            return;
        }
        if (list.size() > 1 && (list.get(list.size() - 1) == 3 || list.get(list.size() - 1) == 5)) {
            if (list.get(list.size() - 2) == 3 || list.get(list.size() - 2) == 5) {
                System.out.println("----");
                return;
            }
        }
        if (origin.isEmpty()) {
            System.out.println(list);
            return;
        }
        for (Integer integer : origin) {
            List<Integer> o = new ArrayList<>(origin);
            o.remove(integer);
            List<Integer> li = new ArrayList<>(list);
            li.add(integer);
            pa(o, li);
        }
    }
}
