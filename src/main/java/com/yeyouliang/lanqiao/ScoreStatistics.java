package com.yeyouliang.lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/7/2 : 21:26.
 */
public class ScoreStatistics {
    /**
     * 分数统计
     * 给定一个百分制成绩T，将其划分为如下五个等级之一：
     * 90~100为A，80~89为B，70~79为C，60~69为D，0~59为E
     * 现有若干百分制成绩（成绩个数不超过1000个），请你统计五个等级段的人数，并找出人数最多的那个等级段，按照从大到小的顺序输出该段中所有人成绩（保证人数最多的等级只有一个）。
     * 输入
     * 第一行是成绩的个数 n
     * 第二行是学生的成绩，若干0~100的正整数，用空格隔开
     * 输出
     * 第一行为5个正整数，分别表示A,B,C,D,E五个等级段的人数
     * 第二行一个正整数，表示人数最多的等级段中人数
     * 接下来一行若干个用空格隔开的正整数，表示人数最多的那个等级中所有人的分数，按从大到小的顺序输出。
     * 样例输入
     * 10
     * 100  80  85  77  55  61  82  90  71  60
     * 样例输出
     * 2 3 2 2 1
     * 3
     * 85 82 80
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String num = bufferedReader.readLine();
        String line = bufferedReader.readLine();
        String[] split = line.split(" ");
        //String[] split = {"100", "80", "85", "77", "55", "61", "82", "90", "71", "60"};
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        List<Integer> e = new ArrayList<>();
        List<List<Integer>> lli = Stream.of(a, b, c, d, e).collect(Collectors.toList());
        int max = 0;
        int index = -1;
        for (String s : split) {
            int score = Integer.parseInt(s);
            if (score < 60) {
                e.add(score);
            } else if (score < 70) {
                d.add(score);
            } else if (score < 80) {
                c.add(score);
            } else if (score < 90) {
                b.add(score);
            } else {
                a.add(score);
            }
        }
        for (int i = 0; i < lli.size(); i++) {
            int size = lli.get(i).size();
            System.out.print(size);
            System.out.print(" ");
            if (size > max) {
                max = size;
                index = i;
            }
        }
        System.out.println();
        System.out.println(max);
        List<Integer> list = lli.get(index);
        list.sort((o1, o2) -> Objects.equals(o1, o2) ? 0 : (o1 < o2 ? 1 : -1));
        list.forEach(integer -> System.out.print(integer + " "));
    }
}
