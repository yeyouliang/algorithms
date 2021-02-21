package com.yeyouliang.poker;

import java.util.*;

/**
 * Created by YYL on 2021/2/19 : 21:09.
 */
public class Kn {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    for (int l = 1; l < 10; l++) {
                        for (int m = 1; m < 10; m++) {
                            if (i == j && j == k && k == l && l == m) {
                                continue;
                            }
                            int[] ints = {i, j, k, l, m};
                            Arrays.sort(ints);
                            StringBuilder sb = new StringBuilder();
                            sb.append(ints[0]);
                            for (int i1 = 1; i1 < ints.length; i1++) {
                                sb.append("-");
                                sb.append(ints[i1]);
                            }
                            if (!strings.contains(sb.toString())) {
                                strings.add(sb.toString());
                            }
                        }
                    }
                }
            }
        }
        Collections.sort(strings);
        System.out.println(strings.size());
        strings.forEach(System.out::println);
    }
}
