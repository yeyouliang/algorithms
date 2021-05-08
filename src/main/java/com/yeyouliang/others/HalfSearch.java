package com.yeyouliang.others;

/**
 * Created by YYL on 2021/5/8 : 20:56.
 */
public class HalfSearch {
    /**
     * 使用折半查找方法计算平方根
     * */
    public static void main(String[] args) {
        int n = 6;
        System.out.println(hs(n, 0, n));
    }

    public static int hs(int n, int start, int end) {
        int diff = end - start;
        if (diff == 1) {
            return start;
        }
        int half = diff / 2;
        int a = start + half;
        if (a * a == n) {
            System.out.println("y");
            return a;
        } else if (a * a > n) {
            return hs(n, start, a);
        } else {
            return hs(n, a, end);
        }
    }
}
