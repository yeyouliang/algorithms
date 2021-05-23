package com.yeyouliang.array;

/**
 * Created by YYL on 2021/5/22 : 10:47.
 */
public class OnlyAgain {
    /**
     * 找出数组中唯一的重复元素
     * 问题描述：数组a[N]，1～N-1这N-1个数存放在a[N]中，其中某个数重复1次。写一个函数，找出被重复的数字。
     */
    public static void main(String[] args) {//3,1,1,2,4
        int[] ints = {3,1,1,2,4};//
        for (int i = 0; i < ints.length; i++) {
            if (oa(ints, i)) {
                break;
            }
        }
    }

    public static boolean oa(int[] ints, int a) {
        if (ints[a] != a + 1) {
            int tmp = ints[ints[a] - 1];
            if (tmp == ints[a]) {
                System.out.println(tmp);
                return true;
            }
            ints[ints[a] - 1] = ints[a];
            ints[a] = tmp;
            return oa(ints, a);
        } else {
            return false;
        }
    }
}
