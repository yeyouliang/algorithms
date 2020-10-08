package com.yeyouliang.number;

import org.junit.Test;

/**
 * Created by YYL on 2020/10/7.
 */
public class Mahu {

    @Test
    public void mahu() {//假设 a b c d e 代表1~9不同的5个数字（注意是各不相同的数字，且不含0）能满足形如： ab * cde = adb * ce 这样的算式一共有多少种呢？
        int count = 0;
        for (int a = 1; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                if (a == b) {
                    continue;
                }
                for (int c = 1; c < 10; c++) {
                    if (a == c || b == c) {
                        continue;
                    }
                    for (int d = 0; d < 10; d++) {
                        if (a == d || b == d || c == d) {
                            continue;
                        }
                        for (int e = 0; e < 10; e++) {
                            if (a == e || b == e || c == e || d == e) {
                                continue;
                            }
                            if ((a * 10 + b) * (c * 100 + d * 10 + e) == (a * 100 + d * 10 + b) * (c * 10 + e)) {
                                count++;
                                System.out.println("" + a + b + "," + c + d + e);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
