package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/7/5 : 21:40.
 */
public class EightQueen {
    /**
     * 八皇后
     * 检查一个如下的6 x 6的跳棋棋盘，有六个棋子被放置在棋盘上，使得每行、每列有且只有一个，每条对角线(包括两条主对角线的所有平行线)上至多有一个棋子。
     * 上面的布局可以用序列2 4 6 1 3 5来描述，第i个数字表示在第i行的相应位置有一个棋子，如下：
     * 行号 1 2 3 4 5 6
     * 列号 2 4 6 1 3 5
     * 这只是跳棋放置的一个解。请编一个程序找出所有跳棋放置的解。并把它们以上面的序列方法输出。解按字典顺序排列。请输出前3个解。最后一行是解的总个数。
     * */
    public static void main(String[] args) {
        int n = 8;
        List<String> list = new ArrayList<>();
        //i为垂直坐标，j为水平坐标
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list.add(i + "-" + j);
            }
        }
        eq(list, new ArrayList<>(), 0, n);
    }

    public static void eq(List<String> origin, List<String> strings, int index, int num) {
        if (index >= num * num) {
            System.out.println(strings);
            return;
        }
        //遍历每一行
        for (int i = index; i < index + num; i++) {
            if (!strings.isEmpty()) {
                boolean flag = true;
                //垂直坐标
                int h = index / num;
                //水平坐标
                int s = i % num;
                List<String> duijiao = duijiao(s, h, num);
                for (String string : strings) {
                    String[] split = string.split("-");
                    int y = Integer.parseInt(split[0]);
                    int x = Integer.parseInt(split[1]);
                    //判断是否在同一横线、同一竖线、同一对角线
                    if (h == y || s == x || duijiao.contains(string)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    List<String> str = new ArrayList<>(strings);
                    str.add(origin.get(i));
                    eq(origin, str, index + num, num);
                }
            } else {
                List<String> str = new ArrayList<>(strings);
                str.add(origin.get(i));
                eq(origin, str, index + num, num);
            }
        }
    }

    /**
     * 返回左下和右下对角线的格子
     * */
    public static List<String> duijiao(int x, int y, int num) {
        List<String> list = new ArrayList<>();
        int a = x - 1;
        int b = y - 1;
        while (a >= 0 && b >= 0) {
            list.add(b + "-" + a);
            a -= 1;
            b -= 1;
        }
        a = x + 1;
        b = y - 1;
        while (a < num && b >= 0) {
            list.add(b + "-" + a);
            a += 1;
            b -= 1;
        }
        return list;
    }
}
