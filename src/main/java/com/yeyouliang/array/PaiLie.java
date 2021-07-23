package com.yeyouliang.array;

/**
 * Created by YYL on 2021/7/23 : 21:29.
 */
public class PaiLie {
    /**
     * 排列组合总数
     * */
    public static void main(String[] args) {
        //可插入的位置
        int[] ints = {1,2,3,4,5};
        //需要插入的数量
        int num=3;
        int count=0;
        for (int i = 0; i < ints.length-num+1; i++) {
            for (int j = i + 1; j < ints.length-num+2; j++) {
                for (int k = j + 1; k < ints.length-num+3; k++) {
                    System.out.println(ints[i] + "," + ints[j] + "," + ints[k]);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
