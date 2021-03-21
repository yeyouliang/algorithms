package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/3/21 : 21:09.
 */
public class Ruiqi {
    /**
     * 观察下面的加法算式：
     *     祥 瑞 生 辉
     * +   三 羊 献 瑞
     * -------------------
     *  三 羊 生 瑞 气
     * 其中，相同的汉字代表相同的数字，不同的汉字代表不同的数字。
     * 请你填写“三羊献瑞”所代表的4位数字（答案唯一），不要填写任何多余内容。
     */
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {//祥
            for (int j = 0; j < 10; j++) {//瑞
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < 10; k++) {//生
                    if (i == k || j == k) {
                        continue;
                    }
                    for (int l = 0; l < 10; l++) {//辉
                        if (i == l || j == l || k == l) {
                            continue;
                        }
                        for (int m = 1; m < 10; m++) {//三
                            if (i == m || j == m || k == m || l == m) {
                                continue;
                            }
                            for (int n = 0; n < 10; n++) {//羊
                                if (i == n || j == n || k == n || l == n || m == n) {
                                    continue;
                                }
                                for (int o = 0; o < 10; o++) {//献
                                    if (i == o || j == o || k == o || l == o || m == o || n == o) {
                                        continue;
                                    }
                                    int a = Integer.valueOf("" + i + j + k + l);
                                    int b = Integer.valueOf("" + m + n + o + j);
                                    int count = a + b;
                                    if (count < 10000) {
                                        continue;
                                    }
                                    List<Integer> list = Arrays.asList(i, j, k, l, m, n, o);
                                    List<Integer> integers = new ArrayList<>();
                                    for (int p = 0; p < 10; p++) {
                                        if (!list.contains(p)) {
                                            integers.add(p);
                                        }
                                    }
                                    for (Integer integer : integers) {
                                        if (count == Integer.valueOf("" + m + n + k + j + integer)) {
                                            System.out.println("" + count);
                                            System.out.println(Arrays.toString(list.toArray()));
                                            System.out.println(Arrays.toString(integers.toArray()));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
