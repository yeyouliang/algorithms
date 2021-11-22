package com.yeyouliang.ti;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/9 : 11:51.
 */
public class QuanPaiLie {
    /**
     * 全排列
     * 打印字符的所有排列组合
     */
    public static void main(String[] args) {
        qpl(new String[]{"a"}, new String[0]);
        qpl(new String[]{"a", "b"}, new String[0]);
        qpl(new String[]{"a", "b", "c"}, new String[0]);
    }

    private static void qpl(String[] a, String[] b) {
        if (a.length == 0) {
            System.out.println(Arrays.toString(b));
        } else {
            for (int i = 0; i < a.length; i++) {
                String s = a[i];
                String[] c = new String[b.length + 1];
                System.arraycopy(b, 0, c, 0, b.length);
                c[c.length - 1] = s;
                String[] d = new String[a.length - 1];
                System.arraycopy(a, 0, d, 0, i);
                System.arraycopy(a, i + 1, d, i, a.length - i - 1);
                qpl(d, c);
            }
        }
    }
}
