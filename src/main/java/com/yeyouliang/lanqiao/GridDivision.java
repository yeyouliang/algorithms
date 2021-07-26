package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/7/26 : 20:13.
 */
public class GridDivision {
    /**
     * 方格分割
     * https://www.cnblogs.com/douzujun/p/8457087.html#autoid-0-4-0
     * 6x6的方格，沿着格子的边线剪开成两部分。
     * 要求这两部分的形状完全相同。
     * 试计算：
     * 包括这3种分法在内，一共有多少种不同的分割方法。
     * 注意：旋转对称的属于同一种分割法。
     */
    public static void main(String[] args) {
        int[] count = new int[1];
        //三条切入路径，以切入后的第一个节点为起点。
        for (int y = -1; y < 0; y++) {
            for (int x = 1; x < 4; x++) {
                gd(new ArrayList<>(), x, y, count);
            }
        }
        System.out.println(count[0]);
    }

    /**
     * 分别进行向上、向下、向左、向右的移动。上、下、左都不能触边，右以3为界，以（3，-3）为终点。
     */
    private static void gd(List<String> distances, int x, int y, int[] count) {
        String s = x + "|" + y;
        if (x == 3 && y == -3) {
            distances.add(s);
            System.out.println(distances);
            count[0]++;
            return;
        }
        //上
        if (y < -1 && !distances.contains(s)) {
            List<String> dis = new ArrayList<>(distances);
            dis.add(s);
            gd(dis, x, y + 1, count);
        }
        //下
        if (y > -5 && !distances.contains(s)) {
            List<String> dis = new ArrayList<>(distances);
            dis.add(s);
            gd(dis, x, y - 1, count);
        }
        //左
        if (x > 1 && !distances.contains(s)) {
            List<String> dis = new ArrayList<>(distances);
            dis.add(s);
            gd(dis, x - 1, y, count);
        }
        //右
        if (x < 3 && !distances.contains(s)) {
            List<String> dis = new ArrayList<>(distances);
            dis.add(s);
            gd(dis, x + 1, y, count);
        }
    }
}
