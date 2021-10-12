package com.yeyouliang.leetcode;

import java.util.*;

/**
 * Created by YYL on 2021/10/12 : 21:46.
 */
public class MinimumIndexSumOfTwoLists {
    /**
     * 599. 两个列表的最小索引总和
     * */
    public static void main(String[] args) {
        String[][][] strings = {
                {{"Shogun", "Tapioca Express", "Burger King", "KFC"}, {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}},
                {{"Shogun", "Tapioca Express", "Burger King", "KFC"}, {"KFC", "Shogun", "Burger King"}},
                {{"Shogun", "KFC", "Burger King", "Tapioca Express"}, {"KFC", "Shogun", "Burger King"}},
        };
        for (String[][] string : strings) {
            System.out.println(Arrays.toString(string[0]));
            System.out.println(Arrays.toString(string[1]));
            System.out.println(Arrays.toString(findRestaurant(string[0], string[1])));
        }
    }

    private static String[] findRestaurant(String[] list1, String[] list2) {
        List<String> a = new ArrayList<>();
        Map<Integer, List<String>> b = new HashMap<>();
        Collections.addAll(a, list1);
        for (int i = 0; i < list2.length; i++) {
            String c = list2[i];
            if (a.contains(c)) {
                int d = a.indexOf(c);
                int e = i + d;
                List<String> f;
                if (b.containsKey(e)) {
                    f = b.get(e);
                } else {
                    f = new ArrayList<>();
                }
                f.add(c);
                b.put(e, f);
            }
        }
        List<Integer> g = new ArrayList<>(b.keySet());
        Collections.sort(g);
        List<String> h = b.get(g.get(0));
        String[] j = new String[h.size()];
        for (int k = 0; k < j.length; k++) {
            j[k] = h.get(k);
        }
        return j;
    }
}
