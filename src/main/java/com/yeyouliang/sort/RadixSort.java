package com.yeyouliang.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/11/22 : 11:30.
 */
public class RadixSort {

    public static void main(String[] args) {
        int[][] ints = {
                {8, 9, 1, 7, 2, 3, 5, 4, 6, 0},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(radixSort(anInt)));
        }
    }

    /**
     * 基数排序
     */
    private static int[] radixSort(int[] ints) {
        if (ints != null && ints.length > 1) {
            int a = 0;
            int b = 0;
            do {
                List<Integer> l0 = new ArrayList<>();
                List<Integer> l1 = new ArrayList<>();
                List<Integer> l2 = new ArrayList<>();
                List<Integer> l3 = new ArrayList<>();
                List<Integer> l4 = new ArrayList<>();
                List<Integer> l5 = new ArrayList<>();
                List<Integer> l6 = new ArrayList<>();
                List<Integer> l7 = new ArrayList<>();
                List<Integer> l8 = new ArrayList<>();
                List<Integer> l9 = new ArrayList<>();
                for (int anInt : ints) {
                    String c = String.valueOf(anInt);
                    b = Math.max(c.length(), b);
                    if (c.length() > a) {
                        switch (c.substring(c.length() - 1 - a, c.length() - 1 - a + 1)) {
                            case "0":
                                l0.add(anInt);
                                break;
                            case "1":
                                l1.add(anInt);
                                break;
                            case "2":
                                l2.add(anInt);
                                break;
                            case "3":
                                l3.add(anInt);
                                break;
                            case "4":
                                l4.add(anInt);
                                break;
                            case "5":
                                l5.add(anInt);
                                break;
                            case "6":
                                l6.add(anInt);
                                break;
                            case "7":
                                l7.add(anInt);
                                break;
                            case "8":
                                l8.add(anInt);
                                break;
                            case "9":
                                l9.add(anInt);
                                break;
                        }
                    } else {
                        l0.add(anInt);
                    }
                }
                int d = 0;
                for (Integer integer : l0) {
                    ints[d++] = integer;
                }
                for (Integer integer : l1) {
                    ints[d++] = integer;
                }
                for (Integer integer : l2) {
                    ints[d++] = integer;
                }
                for (Integer integer : l3) {
                    ints[d++] = integer;
                }
                for (Integer integer : l4) {
                    ints[d++] = integer;
                }
                for (Integer integer : l5) {
                    ints[d++] = integer;
                }
                for (Integer integer : l6) {
                    ints[d++] = integer;
                }
                for (Integer integer : l7) {
                    ints[d++] = integer;
                }
                for (Integer integer : l8) {
                    ints[d++] = integer;
                }
                for (Integer integer : l9) {
                    ints[d++] = integer;
                }
                a++;
            } while (a < b);
        }
        return ints;
    }
}
