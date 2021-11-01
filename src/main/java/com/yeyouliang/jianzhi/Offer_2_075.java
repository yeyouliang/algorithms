package com.yeyouliang.jianzhi;

import java.util.*;

/**
 * Created by YYL on 2021/11/1 : 11:53.
 */
public class Offer_2_075 {
    /**
     * 剑指 Offer II 075. 数组相对排序
     */
    public static void main(String[] args) {
        int[][][] ints = {
                {{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, {2, 1, 4, 3, 9, 6}},
                {{28,6,22,8,44,17}, {22,28,8,6}},
        };
        for (int[][] string : ints) {
            System.out.println(Arrays.toString(string[0]));
            System.out.println(Arrays.toString(string[1]));
            int[] in = relativeSortArray(string[0], string[1]);
            System.out.println(Arrays.toString(in));
            System.out.println("---------------------------------");
        }
    }

    private static int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1.length > 1) {
            Map<Integer, Integer> map = new LinkedHashMap<>();
            List<Integer> list = new ArrayList<>();
            for (int i : arr2) {
                map.put(i, 0);
            }
            for (int i : arr1) {
                if (map.containsKey(i)) {
                    int value = map.get(i) + 1;
                    map.put(i, value);
                } else {
                    list.add(i);
                }
            }
            int index = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                for (int i = 0; i < value; i++) {
                    arr1[index++] = key;
                }
            }
            Collections.sort(list);
            for (Integer aList : list) {
                arr1[index++] = aList;
            }
        }
        return arr1;
    }
}
