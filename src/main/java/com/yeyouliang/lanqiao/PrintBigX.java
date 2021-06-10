package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/6/10 : 19:08.
 */
public class PrintBigX {
    /**
     * 打印大X
     * https://blog.csdn.net/qq_42798905/article/details/88085106
     * */
    public static void main(String[] args) {
        int high = 8;
        int weight = 5;
        int index = 0;
        String[][] ints = new String[high][high - 1 + weight];
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < index; j++) {
                ints[i][j] = " ";
            }
            for (int k = 0; k < weight; k++) {
                ints[i][index + k] = "*";
            }
            for (int l = index + weight; l < ints[0].length; l++) {
                ints[i][l] = " ";
            }
            index++;
        }
        index = 0;
        for (int i = 0; i < high; i++) {
            for (int k = 0; k < weight; k++) {
                ints[i][ints[0].length - 1 - index - k] = "*";
            }
            index++;
        }
        for (String[] anInt : ints) {
            for (String s : anInt) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
