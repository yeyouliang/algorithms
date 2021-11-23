package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/22 : 22:05.
 */
public class T17 {
    public static void main(String[] args) {
        m1();
    }

    /**
     * 猴子吃桃问题：
     * 猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。
     * 到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
     */
    private static void m1() {
        int a = 1;
        for (int i = 0; i < 9; i++) {
            a = (a + 1) * 2;
            System.out.println(a);
        }
    }
}
