package com.yeyouliang.others;

/**
 * Created by YYL on 2021/3/30 : 22:15.
 */
public class LingXing {

    /**
     * 给定一个数字N：表示最多能利用的*的数量，用*号打印菱形，菱形的总*数量不超过给定数字N。
     * 要求：
     * 1.最大化利用*
     * 2.展示剩余的*数量
     * */
    public static void main(String[] args) {
        int n = 14;
        int index = -1;
        int base = 1;
        int diff = -1;
        for (int i = 1; i <= n; i += 2) {
            index = i;
            base += i + (i + 2);
            if (base > n) {
                break;
            } else {
                diff = n - base;
            }
        }
        //System.out.println(index + "," + diff);
        for (int i = 1; i <= index; i += 2) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = index - 2; i >= 1; i -= 2) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("剩余：" + diff);
    }
}
