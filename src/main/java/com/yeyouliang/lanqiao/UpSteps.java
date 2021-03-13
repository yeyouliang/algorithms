package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/3/13 : 13:49.
 */
public class UpSteps {
    /**
     * 题目标题: 第39级台阶
     * 小明刚刚看完电影《第39级台阶》，离开电影院的时候，他数了数礼堂前的台阶数，恰好是39级!
     * 站在台阶前，他突然又想着一个问题：
     * 如果我每一步只能迈上1个或2个台阶。先迈左脚，然后左右交替，最后一步是迈右脚，也就是说一共要走偶数步。那么，上完39级台阶，有多少种不同的上法呢？
     * 请你利用计算机的优势，帮助小明寻找答案。
     */
    public static void main(String[] args) {
        upSteps(0, 6, 0, new ArrayList<>());
    }

    public static void upSteps(int current, int end, int count, List<Integer> list) {
        if (current == end) {
            if (count % 2 == 0) {
                System.out.println(Arrays.toString(list.toArray()));
            }
            return;
        }
        if (current + 1 <= end) {
            int cu = current + 1;
            int co = count + 1;
            List<Integer> li = new ArrayList<>(list);
            li.add(1);
            upSteps(cu, end, co, li);
        }
        if (current + 2 <= end) {
            int cu = current + 2;
            int co = count + 1;
            List<Integer> li = new ArrayList<>(list);
            li.add(2);
            upSteps(cu, end, co, li);
        }
    }
}
