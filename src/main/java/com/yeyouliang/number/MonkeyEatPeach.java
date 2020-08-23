package com.yeyouliang.number;

import org.junit.Test;

/**
 * Created by YYL on 2020/8/23.
 */
public class MonkeyEatPeach {
    /*猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。
    到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。*/
    public int mep(int n, int count) {//第n次吃桃之前看到的桃子数count
        int a = (count + 1) * 2;//给桃子数赋初始值：第(n-1)次吃桃之前看到的桃子数
        for (int i = n - 2; i > 0; i--) {
            a = (a + 1) * 2;
        }
        return a;
    }

    @Test
    public void mepTest() {
        System.out.println(mep(10, 1));
    }
}
