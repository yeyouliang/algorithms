package com.yeyouliang.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/5/6 : 19:59.
 */
public class PrintNumberTriangle {

    /**
     * 打印数字三角形
     * */
    public static void main(String[] args) {
        int n = 6;
        //打印第一行
        System.out.println(getWrite(n - 1) + "1");
        if (n == 1) {
            return;
        }
        //根据规律可知，打印数字总量=（层数-1）×4
        int count = (n - 1) * 4;
        List<String> list = new ArrayList<>();
        int start = 2;
        //将从1开始的自然数拆解为不可分的数字，存到集合中
        while (true) {
            boolean flag = false;
            for (String s : String.valueOf(start).split("")) {
                list.add(s);
                if (list.size() == count - 1) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            } else {
                start++;
            }
        }
        if (list.size() > 1) {
            //中间的空格数量
            int kong = 1;
            //打印中间的行
            for (int i = 2; i < n; i++) {
                String left = list.get(0);
                String right = list.get(list.size() - 1);
                System.out.println(getWrite(n - i) + left + getWrite(kong) + right);
                list = list.subList(1, list.size() - 1);
                kong = kong + 2;
            }
            //打印最后一行
            for (String s : list) {
                System.out.print(s);
            }
        }
    }

    /**
     * 获取若干空格字符串
     * */
    public static String getWrite(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
