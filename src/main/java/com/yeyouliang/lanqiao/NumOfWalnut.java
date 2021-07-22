package com.yeyouliang.lanqiao;

import java.util.Arrays;

/**
 * Created by YYL on 2021/7/22 : 21:02.
 */
public class NumOfWalnut {
    /**
     * 核桃的数量
     * 问题描述
     * 小张是软件项目经理，他带领3个开发组。工期紧，今天都在加班呢。为鼓舞士气，小张打算给每个组发一袋核桃（据传言能补脑）。他的要求是：
     * 1. 各组的核桃数量必须相同
     * 2. 各组内必须能平分核桃（当然是不能打碎的）
     * 3. 尽量提供满足1,2条件的最小数量（节约闹革命嘛）
     * 输入格式
     * 输入包含三个正整数a, b, c，表示每个组正在加班的人数，用空格分开（a,b,c<30）
     * 输出格式
     * 输出一个正整数，表示每袋核桃的数量。
     * 样例输入1
     * 2 4 5
     * 样例输出1
     * 20
     * 样例输入2
     * 3 1 1
     * 样例输出2
     * 3
     */
    public static void main(String[] args) {
        int[] ints = {3, 1, 1};
        for (int i = ints.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j + 1];
                    ints[j + 1] = ints[j];
                    ints[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(ints));
        int a = 0, b = 0, c = 0;
        if (ints[2] % ints[1] == 0) {
            a = ints[0];
            b = 1;
            c = ints[2];
        } else if (ints[1] % ints[0] == 0 || ints[2] % ints[0] == 0) {
            a = 1;
            b = ints[1];
            c = ints[2];
        }
        int num = a * b * c;
        System.out.println(num);
    }
}
