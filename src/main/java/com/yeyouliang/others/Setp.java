package com.yeyouliang.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/5/1 : 8:01.
 */
public class Setp {
    /**
     * 
     * */
    public static void main(String[] args) {
        int[] count = new int[1];
        int start = 0;
        int end = 7;
        List<Integer> up = new ArrayList<>();
        up.add(start);
        List<Integer> down = new ArrayList<>();
        down.add(end);
        walk(start, end, count, up, down);
        System.out.println(count[0]);
    }

    public static void walk(int start, int end, int[] count, List<Integer> up, List<Integer> down) {
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                int s = start + i;
                int e = end - j;
                if (s < e) {
                    List<Integer> u = new ArrayList<>(up);
                    u.add(s);
                    List<Integer> d = new ArrayList<>(down);
                    d.add(e);
                    walk(s, e, count, u, d);
                } else if (s == e) {
                    for (Integer integer : up) {
                        System.out.print(integer + ">");
                    }
                    System.out.print(s + ">");
                    System.out.print("||");
                    System.out.print("<" + e);
                    for (int k = down.size() - 1; k >= 0; k--) {
                        Integer integer = down.get(k);
                        System.out.print("<" + integer);
                    }
                    System.out.println();
                    count[0]++;
                }
            }
        }
    }
}
