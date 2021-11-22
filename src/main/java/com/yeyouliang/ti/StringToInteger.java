package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/20 : 15:29.
 */
public class StringToInteger {
    /**
     * 转换字符串到整数
     * 给一个字符串, 转换为整数。你可以假设这个字符串是一个有效整数的字符串形式， 且范围在32位整数之间 (-231 ~ 231 - 1)。
     */
    public static void main(String[] args) {
        String[] strings = {
                "0",
                "-1",
                "-10345",
                "-12045",
                "-12305",
                "-12340",
                "10345",
                "12045",
                "12305",
                "12340",
                "" + Integer.MAX_VALUE,
                "" + Integer.MIN_VALUE,
        };
        for (String string : strings) {
            System.out.println(string + ":" + sti(string));
        }
    }

    private static int sti(String s) {
        char[] chars = s.toCharArray();
        boolean a = chars[0] == '-';
        int b = chars.length - 1;
        int c = a ? 1 : 0;
        long d = 1;
        long e = 0;
        for (int i = b; i >= c; i--) {
            if (chars[i] != 48) {
                e += (chars[i] - 48) * d;
            }
            d *= 10;
        }
        return a ? ((int) (0 - e)) : ((int) e);
    }
}
