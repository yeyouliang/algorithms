package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/8/28 : 13:59.
 */
public class ReverseInteger {
    /**
     * 7. 整数反转
     * */
    public static void main(String[] args) {
        int[] ints = {
                -21_4748_3648,
                -20_4748_3648,
                -12_2222_1111,
                -12_2222_1100,
                -256,
                -10,
                -1,
                0,
                1,
                2,
                10,
                520,
                748,
                1024,
                10000,
                10010,
                10086,
                12_2222_1100,
                1_2222_2100,
                12_2222_1111,
                1_2222_2111,
                20_4748_3648,
                21_4748_3647
        };
        for (int anInt : ints) {
            System.out.println(anInt + "," + reverse(anInt));
        }
    }

    private static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        String xx = String.valueOf(x).replace("-", "");
        boolean falg = false;
        StringBuilder sb = new StringBuilder();
        for (int i = xx.length() - 1; i >= 0; i--) {
            String s = xx.substring(i, i + 1);
            if (s.equals("0")) {
                if (falg) {
                    sb.append(s);
                }
            } else {
                sb.append(s);
                falg = true;
            }
        }
        xx = sb.toString();
        if (x > 0) {
            String max = "2147483647";
            if (xx.length() < max.length() || max.compareTo(xx) >= 0) {
                return Integer.parseInt(xx);
            } else {
                return 0;
            }
        } else {
            String min = "2147483648";
            if (xx.length() < min.length() || min.compareTo(xx) >= 0) {
                return Integer.parseInt(xx) * -1;
            } else {
                return 0;
            }
        }
    }
}
