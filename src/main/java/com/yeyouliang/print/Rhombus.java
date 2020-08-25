package com.yeyouliang.print;

import org.junit.Test;

/**
 * Created by YYL on 2020/8/24.
 */
public class Rhombus {//打印菱形

    @Test
    public void printRhombus() {
        int a = 8;
        for (int i = 7; i >= -7; i -= 1) {
            //System.out.println(a-Math.abs(i));
            for (int j = 0; j < a - Math.abs(i); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
