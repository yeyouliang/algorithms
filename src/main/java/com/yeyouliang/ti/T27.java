package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/22 : 22:19.
 */
public class T27 {
    public static void main(String[] args) {
        //m1();
        m2();
    }

    /**
     * 海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子平均分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
     * 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？
     */
    private static void m1() {
        for (int i = 1; i < 10000; i++) {
            int a = i;
            int b = a * 5 + 1;
            int c = 0;
            while (c < 4) {
                if (b % 4 != 0) {
                    break;
                } else {
                    a = b / 4;
                    b = a * 5 + 1;
                    c++;
                }
            }
            if (c == 4) {
                System.out.println(a * 5 + 1);
                break;
            }
        }
    }

    /**
     * 海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子平均分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
     * 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？
     */
    private static void m2() {
        int a = 11;
        for (int i = 0; i < 3000; i++) {
            a += 5;
            int b = 0;
            int c = a;
            while (b < 5) {
                int d = c % 5;
                if (d != 1) {
                    break;
                }
                int x = c / 5;
                c = x * 4;
                b++;
            }
            if (b == 5) {
                System.out.println(a);
                break;
            }
        }
    }
}
