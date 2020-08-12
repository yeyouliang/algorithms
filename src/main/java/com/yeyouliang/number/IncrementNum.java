package com.yeyouliang.number;

/**
 * Created by YEYOULIANG on 2020/8/12.
 */
public class IncrementNum {//1,2,2,3,3,3,4,4,4,4,5,5,5,5,5....从1开递增的数列，k(k>=1)有k个连续的数值，求下标为n(n>=1)的位置上的数值。
    int r = 0;
    int dd = 1;
    int a = -1;

    public void test(int n) {
        if (n == 1) {
            a = 1;
            return;
        }
        r += dd;
        dd++;
        if (r < n && r + dd >= n) {
            a = dd;
            return;
        }
        test(n);
    }

    public static void main(String[] args) {
        IncrementNum inte = new IncrementNum();
        inte.test(11);
        System.out.println(inte.a);
    }
}
