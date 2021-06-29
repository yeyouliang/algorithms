package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/6/29 : 21:13.
 */
public class TurnCoin {
    /**
     * 翻硬币
     * 小明正在玩一个“翻硬币”的游戏。
     * 桌上放着排成一排的若干硬币。我们用  *  表示正面，用  o  表示反面（是小写字母，不是零）。
     * 比如，可能情形是：**oo***oooo
     * 如果同时翻转左边的两个硬币，则变为：oooo***oooo
     * 现在小明的问题是：如果已知了初始状态和要达到的目标状态，每次只能同时翻转相邻的两个硬币,那么对特定的局面，最少要翻动多少次呢？
     * 我们约定：把翻动相邻的两个硬币叫做一步操作。
     * 输入
     * 两行等长的字符串，分别表示初始状态和要达到的目标状态。每行的长度< 1000
     * 输出
     * 一个整数，表示最小操作步数。
     * 样例输入
     * *o**o***o***
     * *o***o**o***
     * 样例输出
     * 1
     */
    public static void main(String[] args) {
        String before = "o***oo";
        String after = "o*o*o*";
        int length = before.length();
        int count = 0;
        while (!before.equals(after)) {
            int start = 0;
            while (start < length) {
                String be = before.substring(start, start + 1);
                String af = after.substring(start, start + 1);
                if (!be.equals(af)) {
                    int index = -1;
                    for (int i = start + 1; i < length; i++) {
                        if (af.equals(before.substring(i, i + 1))) {
                            index = i;
                            break;
                        }
                    }
                    count += index - start;
                    before = before.substring(0, start) + af + before.substring(start + 1, index) + be + before.substring(index + 1);
                    break;
                }
                start++;
            }
        }
        System.out.println(count);
    }
}
