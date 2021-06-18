package com.yeyouliang.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/6/18 : 20:03.
 */
public class BorrowBookWay {
    /**
     * 借书方案
     * 小明有5本新书，要借给A、B、C三位小朋友，若每人每次只能借一本，则可以有多少种不同的借法？
     */
    public static void main(String[] args) {
        int num = 5;
        List<String> list = Arrays.asList("A", "B", "C");
        int[] count = new int[1];
        distributeBook(num, list, count);
        System.out.println(count[0]);
    }

    public static void distributeBook(int num, List<String> list, int[] count) {
        if (list.size() == 1) {
            count[0]++;
            return;
        }
        for (int i = 1; i < num + 2 - list.size(); i++) {
            List<String> li = new ArrayList<>(list);
            li.remove(0);
            distributeBook(num - i, li, count);
        }
    }
}
