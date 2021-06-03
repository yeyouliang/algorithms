package com.yeyouliang.lanqiao;

import java.util.Arrays;

/**
 * Created by YYL on 2021/6/3 : 22:04.
 */
public class PirateAndGoldCoin {
    /**
     * 海盗与金币
     * 12名海盗在一个小岛上发现了大量的金币，后统计一共有将近5万枚。
     * 登上小岛是在夜里，天气又不好。由于各种原因，有的海盗偷拿了很多，有的拿了很少。
     * 后来为了“均贫富”，头目提出一个很奇怪的方案：
     * 每名海盗都把自己拿到的金币放在桌上。然后开始一个游戏。
     * 金币最多的海盗要拿出自己的金币来补偿其他人。
     * 补偿的额度为正好使被补偿人的金币数目翻番(即变为原来的2倍)。
     * 游戏要一直进行下去，直到无法完成。
     * （当金币数最多的不只一个人或最多金币的人持有金币数不够补偿他人的）
     * 游戏就这样紧张地进行了，一直进行了12轮，恰好每人都“放血”一次，
     * 更离奇的是，刚好在第12轮后，每个人的金币数居然都相等了！！ 这难道是天意吗？
     * 请你计算，游戏开始前，所有海盗的初始金币数目，从小到大排列，中间有一个空格分开。
     * 答案形如：
     * 8 15 29 58 110 ...
     * 当然，这个不是正确答案。
     * */
    public static void main(String[] args) {
        int a = 12;
        int b = 2;
        while (b < 60_000) {
            int[] ints = new int[a];
            Arrays.fill(ints, b);
            boolean flag = true;
            breakOut:
            for (int i = 0; i < a; i++) {
                int add = 0;
                for (int j = 0; j < a; j++) {
                    if (i != j) {
                        int c = ints[j] % 2;
                        if (c != 0) {
                            flag = false;
                            break breakOut;
                        }
                        int d = ints[j] / 2;
                        ints[j] = d;
                        add += d;
                    }
                }
                ints[i] = ints[i] + add;
            }
            if (flag) {
                System.out.println(Arrays.toString(ints));
                int count = 0;
                for (int anInt : ints) {
                    count += anInt;
                }
                System.out.println(count);
                break;
            }
            b += 2;
        }
    }
}
