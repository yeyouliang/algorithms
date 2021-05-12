package com.yeyouliang.lanqiao;

import java.util.*;

/**
 * Created by YYL on 2021/5/12 : 19:50.
 */
public class DistributeExamRoom {
    /**
     * 分考场
     * 问题描述
     * 　　n个人参加某项特殊考试。
     * 　　为了公平，要求任何两个认识的人不能分在同一个考场。
     * 　　求是少需要分几个考场才能满足条件。
     * 输入格式
     * 　　第一行，一个整数n(1<n<100)，表示参加考试的人数。
     * 　　第二行，一个整数m，表示接下来有m行数据
     * 　　以下m行每行的格式为：两个整数a，b，用空格分开 (1<=a,b<=n) 表示第a个人与第b个人认识。
     * 输出格式
     * 　　一行一个整数，表示最少分几个考场。
     * 样例输入
     * 5
     * 8
     * 1 2
     * 1 3
     * 1 4
     * 2 3
     * 2 4
     * 2 5
     * 3 4
     * 4 5
     * 样例输出
     * 4
     * 样例输入
     * 5
     * 10
     * 1 2
     * 1 3
     * 1 4
     * 1 5
     * 2 3
     * 2 4
     * 2 5
     * 3 4
     * 3 5
     * 4 5
     * 样例输出
     * 5
     * */
    public static void main(String[] args) {
        //int[][] ints = {{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {2, 5}, {3, 4}, {4, 5}};
        int[][] ints = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {3, 4}, {3, 5}, {4, 5}};
        Set<Integer> set = new HashSet<>();
        //求出每个人认识的所有人
        Map<Integer, List<Integer>> mil = new HashMap<>();
        for (int[] anInt : ints) {
            int one = anInt[0];
            int two = anInt[1];
            set.add(one);
            set.add(two);
            List<Integer> list;
            if (mil.containsKey(one)) {
                list = mil.get(one);
            } else {
                list = new ArrayList<>();
            }
            list.add(two);
            mil.put(one, list);
            list = new ArrayList<>();
            if (mil.containsKey(two)) {
                list = mil.get(two);
            }
            list.add(one);
            mil.put(two, list);
        }
        //考场及该考场内的人
        List<List<Integer>> lists = new ArrayList<>();
        for (Integer in : set) {
            boolean flag = false;
            for (List<Integer> list : lists) {
                //需要对考场内的每个人进行比较是否互相认识
                int count = 0;
                for (Integer inte : list) {
                    List<Integer> list1 = mil.get(inte);
                    if (!list1.contains(in)) {
                        count++;
                    }
                }
                //只有都不互相认识，才把当前这个人加入到该考场中，并退出
                if (count == list.size()) {
                    list.add(in);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(in);
                lists.add(list1);
            }
        }
        System.out.println(lists.size());
    }
}
