package com.yeyouliang.merge;

import java.util.Arrays;

/**
 * Created by YEYOULIANG on 2020/8/2.
 */
public class ArraysMerge {//合并两个有序整数数组
    private int[] o = new int[]{1, 2, 4, 7, 40, 79, 90, 91, 95, 99};
    private int[] t = new int[]{3, 6, 9, 13, 26, 30, 70, 77, 89, 93, 96, 97};
    private int oneLength = o.length;
    private int twoLength = t.length;
    private int[] result = new int[oneLength + twoLength];
    private int oneIndex = 0;
    private int twoIndex = 0;

    public void am() {
        if (oneIndex == oneLength) {
            for (int i = twoIndex; i < twoLength; i++) {
                result[oneIndex + twoIndex] = t[i];
                twoIndex++;
            }
        } else if (twoIndex == twoLength) {
            for (int i = oneIndex; i < oneLength; i++) {
                result[oneIndex + twoIndex] = o[i];
                oneIndex++;
            }
        } else {
            if (o[oneIndex] < t[twoIndex]) {
                result[oneIndex + twoIndex] = o[oneIndex];
                oneIndex += 1;
                am();
            } else {
                result[oneIndex + twoIndex] = t[twoIndex];
                twoIndex += 1;
                am();
            }
        }
    }

    public static void main(String[] args) {
        ArraysMerge arraysMerge = new ArraysMerge();
        arraysMerge.am();
        System.out.println(Arrays.toString(arraysMerge.result));
    }
}
