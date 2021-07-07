package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/7/7 : 22:05.
 */
public class SymmetryString {
    /**
     * 对称字符串
     * 在沙盘上写了这样一些字符串：
     * A1 = “A”
     * A2 = “ABA”
     * A3 = “ABACABA”
     * A4 = “ABACABADABACABA”
     * … …
     * 你能找出其中的规律并写所有的数列AN吗？
     * 输入
     * 仅有一个数：N ≤ 26。
     * 输出
     * 请输出相应的字符串AN，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。
     * 样例输入
     * 复制样例数据 3
     * 样例输出
     * ABACABA
     * */
    public static void main(String[] args) {
        String[] strings = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int n = 3;
        String open = "";
        for (int i = 0; i < n; i++) {
            open = open + strings[i] + open;
        }
        System.out.println(open);
    }
}
