package com.yeyouliang.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by YYL on 2021/6/19 : 22:30.
 */
public class MatchGrade {
    /**
     * 歌星大奖赛
     * 歌星大奖赛中，有10个评委为参赛的选手打分，分数为1～100分。选手最后得分为：去掉一个最高分和一个最低分后其余8个分数的平均值。请编程实现上述计分功能
     */
    public static void main(String[] args) {
        int num = 10;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < num; i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("请输入第" + (i + 1) + "个分数：");
                int a = Integer.valueOf(br.readLine());
                count += a;
                min = Math.min(min, a);
                max = Math.max(max, a);
            } catch (IOException e) {
                return;
            }
        }
        int fen = count - min - max;
        System.out.println(fen);
        System.out.println(fen / (num - 2));
    }
}
