package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/4/29 : 21:36.
 */
public class MonkeyEatBanana {
    /**
     * 猴子分香蕉解
     * 5只猴子是好朋友，在海边的椰子树上睡着了。这期间，有商船把一大堆香蕉忘记在沙滩上离去。
     * 第1只猴子醒来，把香蕉均分成5堆，还剩下1个，就吃掉并把自己的一份藏起来继续睡觉。
     * 第2只猴子醒来，重新把香蕉均分成5堆，还剩下2个，就吃掉并把自己的一份藏起来继续睡觉。
     * 第3只猴子醒来，重新把香蕉均分成5堆，还剩下3个，就吃掉并把自己的一份藏起来继续睡觉。
     * 第4只猴子醒来，重新把香蕉均分成5堆，还剩下4个，就吃掉并把自己的一份藏起来继续睡觉。
     * 第5只猴子醒来，重新把香蕉均分成5堆，哈哈，正好不剩！
     * 请计算一开始最少有多少个香蕉。
     */
    public static void main(String[] args) {
        int i = 5;
        while (true) {
            int j = 5;
            int jj = 4;
            while (true) {
                if (j * 4 / 5 + jj == i) {
                    int k = j;
                    int kk = 3;
                    while (true) {
                        if (k * 4 / 5 + kk == j + jj) {
                            int l = k;
                            int ll = 2;
                            while (true) {
                                if (l * 4 / 5 + ll == k + kk) {
                                    int m = l;
                                    int mm = 1;
                                    while (true) {
                                        if (m * 4 / 5 + mm == l + ll) {
                                            System.out.println(m + mm);
                                            return;
                                        }
                                        if (m > 100000000) {
                                            System.out.println("m");
                                            break;
                                        } else {
                                            m += 5;
                                        }
                                    }
                                }
                                if (l > 10000000) {
                                    System.out.println("l");
                                    break;
                                } else {
                                    l += 5;
                                }
                            }
                        }
                        if (k > 1000000) {
                            System.out.println("k");
                            break;
                        } else {
                            k += 5;
                        }
                    }
                }
                if (j > 10000) {
                    System.out.println("j");
                    break;
                } else {
                    j += 5;
                }
            }
            i += 5;
        }
    }
}
