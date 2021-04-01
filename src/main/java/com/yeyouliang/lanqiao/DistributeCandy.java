package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/4/1 : 21:58.
 */
public class DistributeCandy {
    /**
    * 分糖果
    * 有n个小朋友围坐成一圈。老师给每个小朋友随机发偶数个糖果，然后进行下面的游戏：
    * 每个小朋友都把自己的糖果分一半给左手边的孩子。
    * 一轮分糖后，拥有奇数颗糖的孩子由老师补给1个糖果，从而变成偶数。
    * 反复进行这个游戏，直到所有小朋友的糖果数都相同为止。
    * 你的任务是预测在已知的初始糖果情形下，老师一共需要补发多少个糖果。
    * */
    public static void main(String[] args) {
        int[] ints = {2, 4, 2};
        int count = 0;
        while (true) {
            int first = ints[0];
            int last = ints[ints.length - 1];
            for (int i = 0; i < ints.length - 1; i++) {
                int tmp = ints[i];
                ints[i] = ints[i + 1] / 2 + tmp / 2;
            }
            ints[ints.length - 1] = first / 2 + last / 2;
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] % 2 == 1) {
                    ints[i] = ints[i] + 1;
                    count++;
                }
            }
            int start = ints[0];
            boolean equal = true;
            for (int i = 1; i < ints.length; i++) {
                if (ints[i] != start) {
                    equal = false;
                    break;
                }
            }
            if (equal) {
                System.out.println(count);
                return;
            }
        }
    }
}
