package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/22 : 22:05.
 */
public class T16 {
    public static void main(String[] args) {
        m1();
    }

    /**
     * 输出99口诀乘法表。
     */
    private static void m1() {
        for (int i = 1; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                sb.append(j).append("x").append(i).append("=").append(j * i).append(",");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }
}
