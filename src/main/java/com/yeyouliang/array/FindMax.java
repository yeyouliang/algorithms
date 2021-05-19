package com.yeyouliang.array;

/**
 * Created by YYL on 2021/5/18 : 20:29.
 */
public class FindMax {
    /**
     * 寻找数组中的最小值与最大值
     */
    public static void main(String[] args) {
        int[] ints = {1, 1, -3, 4, -1, 2, -5, 4, -2};
        //one(ints);
        two(ints);
    }

    public static void one(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (ints[j] > ints[j + 1]) {
                    int tmp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = tmp;
                }
            }
        }
        System.out.println(ints[0] + "," + ints[ints.length - 1]);
    }

    public static void two(int []ints){
        int min=Math.min(ints[0],ints[1]);
        int max=Math.max(ints[0],ints[1]);
        for (int i = 2; i < ints.length; i++) {
            if (ints[i]<min){
                min=ints[i];
            }else if (ints[i]>max){
                max=ints[i];
            }
        }
        System.out.println(min+","+max);
    }
}
