package com.yeyouliang.lanqiao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/6/25 : 21:09.
 */
public class WrongTicket {
    /**
     * 错误票据
     * 某涉密单位下发了某种票据，并要在年终全部收回。
     * 每张票据有唯一的ID号。全年所有票据的ID号是连续的，但ID的开始数码是随机选定的。
     * 因为工作人员疏忽，在录入ID号的时候发生了一处错误，造成了某个ID断号，另外一个ID重号。
     * 你的任务是通过编程，找出断号的ID和重号的ID。
     * 假设断号不可能发生在最大和最小号。
     * 输入
     * 要求程序首先输入一个整数N(N< 100)表示后面数据行数。
     * 接着读入N行数据。
     * 每行数据长度不等，是用空格分开的若干个（不大于100个）正整数（不大于100000），请注意行内和行末可能有多余的空格，你的程序需要能处理这些空格。
     * 每个整数代表一个ID号。
     * 输出
     * 要求程序输出1行，含两个整数m  n，用空格分隔。
     * 其中，m表示断号ID，n表示重号ID
     * 样例输入
     * 2
     * 5  6  8  11  9
     * 10  12  9
     * 样例输出
     * 7 9
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String s = br.readLine();
        for (int i = 0; i < Integer.parseInt(s); i++) {
            String line = br.readLine();
            for (String s1 : line.split(" ")) {
                list.add(Integer.valueOf(s1));
            }
        }
        System.out.println(list);
        int duan = -1;
        int chong = -1;
        for (int i = 1; i < list.size(); i++) {
            int n = list.get(i);
            int l = list.get(i - 1);
            if (n < l) {
                for (int j = i - 1; j >= 0; j--) {
                    if (list.get(j) > list.get(j + 1)) {
                        int tmp = list.get(j + 1);
                        list.remove(j + 1);
                        list.add(j + 1, list.get(j));
                        list.remove(j);
                        list.add(j, tmp);
                    }
                }
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            int diff = list.get(i + 1) - list.get(i);
            if (diff == 2) {
                duan = list.get(i) + 1;
            }
            if (diff == 0) {
                chong = list.get(i);
            }
        }
        System.out.println(duan + "," + chong);
    }
}
