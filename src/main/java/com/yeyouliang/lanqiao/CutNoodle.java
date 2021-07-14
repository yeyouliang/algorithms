package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/7/13 : 21:09.
 */
public class CutNoodle {
    /**
     * 切面条
     * 题目描述
     * 一根高筋拉面，中间切一刀，可以得到2根面条。
     * 如果先对折1次，中间切一刀，可以得到3根面条。
     * 如果连续对折2次，中间切一刀，可以得到5根面条。
     * 那么，连续对折10次，中间切一刀，会得到多少面条呢？
     * */
    public static void main(String[] args) {
        int wan = 1;
        int num = 3;
        int end = 10;
        for (int i = 2; i <= end; i++) {
            int w = wan * 2;
            num = num+(w - wan) * 2;
            wan = w;
        }
        System.out.println(num);
    }
}
