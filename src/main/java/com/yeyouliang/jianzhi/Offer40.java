package com.yeyouliang.jianzhi;

import java.util.*;

/**
 * Created by YYL on 2021/10/26 : 11:49.
 */
public class Offer40 {
    /**
     * 剑指 Offer 40. 最小的k个数
     * */
    public static void main(String[] args) {
        int[][][] ints = {
                {{3, 2, 1}, {3}},
                {{3, 2, 1}, {2}},
                {{3, 2, 1}, {1}},
                {{3, 2, 1}, {0}},
                {{0, 1, 2, 1}, {1}},
                {{0, 1, 2, 1}, {2}},
                {{0, 1, 2, 1}, {3}},
                {{0, 1, 2, 3}, {3}},
                {{0, 1, 2, 1, 1}, {3}},
                {{0, 1, 2, 1, 1, 1}, {3}},
                {{0, 1, 2, 1}, {4}},
                {{0}, {0}},
                {{1}, {1}},
                {{1, 1}, {1}},
                {{1, 1}, {2}},
                {{1, 1, 1}, {0}},
                {{1, 1, 1}, {1}},
                {{1, 1, 1}, {2}},
                {{1, 1, 1}, {3}},
                {{1, 0, 0, 0, 1}, {0}},
                {{1, 0, 0, 0, 1}, {1}},
                {{1, 0, 0, 0, 1}, {2}},
                {{0, 1, 0, 0, 0, 1}, {1}},
                {{0, 0, 1, 0, 0, 0, 1}, {1}},
                {{1, 0, 0, 0, 1, 0}, {1}},
                {{1, 0, 0, 0, 1, 0, 0}, {1}},
                {{1, 0, 0, 0, 1}, {2}},
                {{0, 1, 0, 0, 0, 1}, {2}},
                {{0, 0, 1, 0, 0, 0, 1}, {2}},
                {{1, 0, 0, 0, 1, 0}, {2}},
                {{1, 0, 0, 0, 1, 0, 0}, {2}},
        };
        for (int[][] string : ints) {
            System.out.println(Arrays.toString(string[0]));
            System.out.println(Arrays.toString(string[1]));
            System.out.println(Arrays.toString(getLeastNumbers(string[0], string[1][0])));
            System.out.println("---------------------");
        }
    }

    private static int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == k) {
            return arr;
        } else {
            if (k != 0) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int i : arr) {
                    int a = 1;
                    if (map.containsKey(i)) {
                        a = map.get(i) + 1;
                    }
                    map.put(i, a);
                }
                List<Integer> list = new ArrayList<>(map.keySet());
                Collections.sort(list);
                int b = 0;
                int[] ints = new int[k];
                for (Integer integer : list) {
                    int c = k - b;
                    int d = map.get(integer);
                    if (c <= d) {
                        for (int i = 0; i < c; i++) {
                            ints[b++] = integer;
                        }
                        break;
                    } else {
                        for (int i = 0; i < d; i++) {
                            ints[b++] = integer;
                        }
                    }
                }
                return ints;
            } else {
                return new int[0];
            }
        }
    }
}
