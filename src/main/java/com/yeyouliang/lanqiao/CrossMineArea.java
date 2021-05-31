package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YYL on 2021/5/31 : 19:36.
 */
public class CrossMineArea {
    /**
     * 每个区域能够移动过去的相邻区域（上下左右）
     */
    private static Map<String, List<String>> msl = new LinkedHashMap<>();

    /**
     * 穿越雷区
     * https://blog.csdn.net/weixin_42069140/article/details/90247311
     */
    public static void main(String[] args) {
        int n = 5;
        String a = "";
        String b = "";
        int[] length = {Integer.MAX_VALUE};
        String[][] strings = {
                {"A", "+", "-", "+", "-"},
                {"-", "+", "-", "-", "+"},
                {"-", "+", "+", "+", "-"},
                {"+", "-", "+", "-", "+"},
                {"B", "+", "-", "+", "-"}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String key = "" + i + "-" + j;
                if (strings[i][j].equals("A")) {
                    a = key;
                }
                if (strings[i][j].equals("B")) {
                    b = key;
                }
                List<String> value = new ArrayList<>();
                if (i != 0 && (!strings[i][j].equals(strings[i - 1][j]) || strings[i - 1][j].equals("A") || strings[i - 1][j].equals("B"))) {
                    value.add((i - 1) + "-" + j);
                }
                if (i != n - 1 && (!strings[i][j].equals(strings[i + 1][j]) || strings[i + 1][j].equals("A") || strings[i + 1][j].equals("B"))) {
                    value.add((i + 1) + "-" + j);
                }
                if (j != 0 && (!strings[i][j].equals(strings[i][j - 1]) || strings[i][j - 1].equals("A") || strings[i][j - 1].equals("B"))) {
                    value.add(i + "-" + (j - 1));
                }
                if (j != n - 1 && (!strings[i][j].equals(strings[i][j + 1]) || strings[i][j + 1].equals("A") || strings[i][j + 1].equals("B"))) {
                    value.add(i + "-" + (j + 1));
                }
                msl.put(key, value);
            }
        }
        System.out.println(msl.size());
        cma(a, b, new ArrayList<>(), length);
        if (length[0]==Integer.MAX_VALUE){
            System.out.println("no");
        }else {
            System.out.println("length:" + length[0]);
        }
    }

    /**
     * 从始点出发，递归能够行走的各条路径，不能走走过的区域。
     */
    public static void cma(String start, String end, List<String> list, int[] length) {
        List<String> li = msl.get(start);
        for (String s : li) {
            if (!list.contains(s)) {
                if (s.equals(end)) {
                    length[0] = Math.min(length[0], list.size() + 1);
                    System.out.println(length[0] + "||" + list + start + "," + s);
                } else {
                    List<String> ls = new ArrayList<>(list);
                    ls.add(start);
                    cma(s, end, ls, length);
                }
            }
        }
    }
}
