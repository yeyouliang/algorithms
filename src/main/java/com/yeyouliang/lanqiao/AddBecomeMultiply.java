package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/3/18 : 21:00.
 */
public class AddBecomeMultiply {
    /**
     * 加法变乘法
     * 我们都知道：1+2+3+ ... + 49 = 1225
     * 现在要求你把其中两个不相邻的加号变成乘号，使得结果为2015
     * 比如：
     * 1+2+3+4+5+6...+10*11+12+...+27*28+29+...+49= 2015 就是符合要求的答案。
     * 请你寻找另外一个可能的答案，并把位置靠前的那个乘号左边的数字提交（对于示例，就是提交10）。
     */
    public static void main(String[] args) {
        int before = 1225;
        int after = 2015;
        int diff = after - before;
        for (int i = 0; i < 46; i++) {
            for (int j = i + 2; j < 48; j++) {
                int change1 = (i + 1) * (i + 2) - (i + 1) - (i + 2);
                int change2 = (j + 1) * (j + 2) - (j + 1) - (j + 2);
                if (diff == change1 + change2) {
                    System.out.println(i + 1);
                }
            }
        }
    }
}
