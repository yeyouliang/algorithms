package com.yeyouliang.util;

import org.junit.Test;

/**
 * Created by YEYOULIANG on 2020/5/2.
 */
public class Help {

    @Test
    public void tests() {
        int num=234;
        System.out.print(num+"=");
        fjzys(num);
    }

    public void fjzys(int num) {
        int pfg = (int) Math.sqrt(num);
        if (pfg < 2) {
            System.out.println(num);
            return;
        }
        int shang = 0;
        for (int i = 2; i <= pfg; i++) {
            int yu = num % i;
            if (yu == 0) {
                System.out.print(i + "*");
                shang = num / i;
                break;
            }
        }
        if (shang == 0) {
            System.out.println(num);
        } else {
            fjzys(shang);
        }
    }
}
