package com.yeyouliang.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/11/7 : 14:11.
 */
public class NewSort {

    public static void main(String[] args) {
        int[][] ints = {
                {8, 9, 1, 7, 2, 3, 5, 4, 6, 0},
                {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48},
                {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48, 100, 10000},
                {4, 1, 9, 3, 7, 8, 5, 6, 2},
                {4, 6, 8, 5, 9},
                {1},
                {1, 2},
                {1, 2, 3},
                {1, 2, 3, 4},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6, 7},
                {5, 1, 3, 9, 8, 2, 6, 4, 7},
                {2},
                {2, 1},
                {2, 2},
                {2, 5},
                {2, 5, 3, 1, 4},
                {1, 2, 3, 3},
                {2, 1, 2, 5, 3, 2},
                {5, 1, 5, 2, 5, 3, 5, 4},
        };
        for (int[] anInt : ints) {
            //System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(guibing(anInt)));
        }
    }

}
