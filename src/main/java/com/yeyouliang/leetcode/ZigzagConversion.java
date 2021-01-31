package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/1/31 : 10:30.
 */
public class ZigzagConversion {

    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);
    }

    public static void convert(String s, int numRows) {
        int length = s.length();
        String[] arrays = s.split("");
        //在“Z”字的竖直方向上，相邻两个字符的下标之差是固定值。
        int turn = numRows + numRows - 2;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < length; j++) {
                int itj = i + (turn * j);
                //字符串下标不能超过字符串长度
                if (itj < length) {
                    //保存非斜线值
                    sb.append(arrays[itj]);
                } else {
                    break;
                }
                //排除头尾两行
                if (i > 0 && i < numRows - 1) {
                    int t = (numRows - 1) + turn * j;
                    //（斜线上的值的下标）与（当前竖行上的值的下标）距夹角顶点的距离相同。
                    int l = t - itj + t;
                    //字符串下标不能超过字符串长度
                    if (l < length) {
                        //保存斜线值
                        sb.append(arrays[l]);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
