package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/1/25 : 21:19.
 */
public class PrintBinaryTreeNodeByFlow {
    public static void main(String[] args) {
        //String[] s = {"5", "3", "9", "null", "null", "7", "4"};
        String[] s = {"5", "3", "9", "null", "null", "7", "4", "null", "null", "null", "null", "1", "6", "2", "8"};
        StringBuffer sb = new StringBuffer();
        int n = 1;
        int count = 0;
        while (n < s.length) {
            int la = (int) Math.pow(2, n - 1);
            int a = 0;
            while (a != la) {
                if (a + count == s.length) {
                    System.out.println(sb);
                    return;
                }
                if (!"null".equals(s[a + count])) {
                    sb.append(s[a + count]);
                    sb.append(",");
                }
                if (a + 1 == la) {
                    System.out.println(sb);
                    sb = new StringBuffer();
                    n++;
                    count += la;
                    break;
                }
                a++;
            }
        }
    }
}
