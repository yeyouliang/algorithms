package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/20 : 9:35.
 */
public class PowerOfTwo {
    /**
     * 写一个程序去判断一个数是否是2的幂次
     * */
    public static void main(String[] args) {
        //System.out.println(m1(Integer.MAX_VALUE));
        //System.out.println(m2(Integer.MAX_VALUE));
        System.out.println(m2(1));
        System.out.println(m2(2));
        System.out.println(m2(3));
        System.out.println(m2(4));
        System.out.println(m2(5));
        System.out.println(m2(6));
        System.out.println(m2(7));
        System.out.println(m2(8));
        System.out.println(m2(9));
        System.out.println(m2(10));
    }

    private static boolean m1(int n) {
        return n == 1 || n == 2 || n == 4 || n == 8 || n == 16 || n == 32 || n == 64 || n == 128 || n == 256 || n == 512 || n == 1024 || n == 2048 || n == 4096 || n == 8192
                || n == 16384 || n == 32768 || n == 65536 || n == 131072 || n == 262144 || n == 524288 || n == 1048576 || n == 2097152 || n == 4194304 || n == 8388608
                || n == 16777216 || n == 33554432 || n == 67108864 || n == 134217728 || n == 268435456 || n == 536870912 || n == 1073741824;
    }

    private static boolean m2(int n) {
        if (n <= 0) {
            return false;
        } else {
            long a = Integer.MAX_VALUE;
            long b = 1;
            while (true) {
                if (b > a) {
                    break;
                }
                if (n == b) {
                    return true;
                } else if (b > n) {
                    break;
                }
                b *= 2;
            }
            return false;
        }
    }
}
