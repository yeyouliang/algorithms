package com.yeyouliang.leetcode;


/**
 * Created by YYL on 2021/1/26 : 18:41.
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        String a = "1234";
        String b = "567";
        int longs = a.length() * b.length();
        int max = Math.max(Integer.parseInt(a), Integer.parseInt(b));
        String maxS = a.length() == String.valueOf(max).length() && Integer.parseInt(a) > Integer.parseInt(b) ? a : b;
        String minS = a.equals(maxS) ? b : a;
        int min = Math.min(Integer.parseInt(a), Integer.parseInt(b));
        int[][] con = new int[minS.length()][longs];
        int index = 0;
        for (int i = minS.length() - 1; i >= 0; i--) {
            int in = 0;
            int ii = 0;
            for (int j = maxS.length() - 1; j >= 0; j--) {
                int re[] = multiply(((int) minS.charAt(i) - (int) ('0')), ((int) maxS.charAt(j) - (int) ('0')), ii);
                int aa = longs - 1 - in - index;
                con[index][longs - 1 - in - index] = re[1];
                ii = re[0];
                in++;
            }
            con[index][longs - 1 - in - index] = ii;
            index++;
        }
        System.out.println(min);
    }

    public static int[] multiply(int a, int b, int c) {
        int m = a * b;
        String s = String.valueOf(m + c);
        int[] ints = new int[2];
        if (s.length() > 1) {
            ints[0] = Integer.parseInt(s.substring(0, 1));
            ints[1] = Integer.parseInt(s.substring(1, 2));
        } else {
            ints[1] = Integer.parseInt(s.substring(0, 1));
        }
        return ints;
    }
}
