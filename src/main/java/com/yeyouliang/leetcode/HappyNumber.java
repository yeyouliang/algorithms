package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/8/8 : 10:08.
 */
public class HappyNumber {
    /**
     * 202.快乐数
     * */
    public static void main(String[] args) {
        System.out.println(isHappy(1));
    }

    private static boolean isHappy(int n) {
        String s = String.valueOf(n);
        List<String> list = new ArrayList<>();
        list.add(s);
        while (!"1".equals(s)) {
            int count = 0;
            for (String s1 : s.replace("0", "").split("")) {
                int i = Integer.parseInt(s1);
                count += i * i;
            }
            s = String.valueOf(count);
            if (list.contains(s)) {
                return false;
            } else {
                list.add(s);
            }
        }
        return true;
    }
}
