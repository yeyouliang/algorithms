package com.yeyouliang.number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by YYL on 2020/10/8.
 */
public class DuanChongHao {

    /*
    *所有正整数是连续的，但开始数是随机选定的
    *首先输入一个整数表示后面数据行数
    *每行数据长度不等，是用空格分开的若干个正整数
    *用户输入：
    *2
    *5 6 8 11 9
    *10 12 9
    *则程序输出：
    *7 9
    * */
    public static void main(String[] args) throws IOException {
        List<Integer> integers = new ArrayList<>();
        int repeatNum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入数据行数：");
        int lineCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < lineCount; i++) {
            System.out.println("请输入第" + (i + 1) + "行");
            String lineString = br.readLine();
            for (String s : lineString.split(" ")) {
                Integer num = Integer.valueOf(s);
                if (integers.contains(num)) {
                    repeatNum = num;
                } else {
                    integers.add(num);
                }
            }
        }
        System.out.println("重号：" + repeatNum);
        System.out.print("断号：");
        Collections.sort(integers);
        for (int i = 0; i < integers.size() - 1; i++) {
            if (integers.get(i + 1) - integers.get(i) > 1) {
                System.out.println(integers.get(i) + 1);
                break;
            }
        }
    }
}
