package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/3/28 : 9:14.
 */
public class AcreagePaint {
    /**
     * 对若干用坐标表示的矩形涂上油漆，求油漆覆盖的总面积。
     * */
    public static void main(String[] args) {
        int[][] ints = new int[][]{{1, 5, 10, 10}, {3, 1, 20, 20}, {2, 7, 15, 17}};
        //int[][] ints = new int[][]{{2, 3, 5, 5}, {1, 6, 6, 9}, {3, 1, 7, 13}};
        List<String> list = new ArrayList<>();
        for (int[] anInt : ints) {
            for (int i = anInt[0]; i < anInt[2]; i++) {
                for (int j = anInt[1]; j < anInt[3]; j++) {
                    String xy = i + "-" + j;
                    if (!list.contains(xy)) {
                        list.add(xy);
                    }
                }
            }
        }
        System.out.println(list.size());
    }
}
