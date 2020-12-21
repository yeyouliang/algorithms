package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2020/12/21 : 21:55.
 */
public class LongestCommonPrefix {//最长公共前缀

    public static void main(String[] args) {
        System.out.println(lcp("flower", "flow", "flight"));
    }

    public static String lcp(String one, String two, String three) {
        StringBuffer sb = new StringBuffer("");
        int i = 0;
        for (; (i < one.length() && i < two.length() && i < three.length()); i++) {
            if (one.charAt(i) == two.charAt(i) && two.charAt(i) == three.charAt(i)) {
                sb.append(one.charAt(i));
            }
        }
        return sb.toString();
    }
}
