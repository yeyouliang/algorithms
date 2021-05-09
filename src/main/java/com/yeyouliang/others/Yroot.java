package com.yeyouliang.others;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by YYL on 2021/5/9 : 12:13.
 */
public class Yroot {
    /**
     * 求某数的平方根的小数部分，0-9所有数字全部出现过为止。
     */
    public static void main(String[] args) {
        int n = 6;
        int zheng = hs(n, 0, n);
        StringBuilder sb = new StringBuilder();
        sb.append(zheng);
        sb.append(".");
        System.out.println(hs(n, 0, n));
        Set<String> set = new HashSet<>();
        int count = 0;
        Collections.addAll(set, String.valueOf(zheng).split(""));
        int turn = 0;
        int max = 100;
        while (set.size() < 10) {
            for (int i = 9; i >= 0; i--) {
                double d = Double.valueOf(sb.toString() + i);
                if (d * d < n) {
                    set.add("" + i);
                    sb.append(i);
                    count++;
                    break;
                }
            }
            turn++;
            if (turn == max) {
                System.out.println("no");
                break;
            }
        }
        System.out.println("count=" + count);
        System.out.println(sb);
    }

    /**
     * 折半查找求出整数部分
     * */
    public static int hs(int n, int start, int end) {
        int diff = end - start;
        if (diff == 1) {
            return start;
        }
        int half = diff / 2;
        int a = start + half;
        if (a * a == n) {
            System.out.println("y");
            return a;
        } else if (a * a > n) {
            return hs(n, start, a);
        } else {
            return hs(n, a, end);
        }
    }
}
