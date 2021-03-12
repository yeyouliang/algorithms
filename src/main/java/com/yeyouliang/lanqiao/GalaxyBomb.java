package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/3/12 : 22:11.
 */
public class GalaxyBomb {
    /**
     * 在X星系的广袤空间中漂浮着许多X星人造“炸弹”，用来作为宇宙中的路标。
     * 每个炸弹都可以设定多少天之后爆炸。
     * 比如：阿尔法炸弹2015年1月1日放置，定时为15天，则它在2015年1月16日爆炸。
     * 有一个贝塔炸弹，2014年11月9日放置，定时为1000天，请你计算它爆炸的准确日期。
     * 请填写该日期，格式为 yyyy-mm-dd 即4位年份2位月份2位日期。比如：2015-02-19
     */
    public static void main(String[] args) {
        int timing = 1000;
        int year = 2014;
        int month = 11;
        int day = 9;
        while (timing > 0) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day < 31) {
                    day++;
                } else {
                    day = 1;
                    if (month == 12) {
                        month = 1;
                        year++;
                    } else {
                        month++;
                    }
                }
            } else if (month == 2 || month == 4 || month == 6 || month == 9 || month == 11) {
                if (month == 2) {
                    int dayOfMonth = 28;
                    if (isRunNian(year)) {//29
                        dayOfMonth = 29;
                    }
                    if (day < dayOfMonth) {
                        day++;
                    } else {
                        day = 1;
                        month++;
                    }
                } else {
                    if (day < 30) {
                        day++;
                    } else {
                        day = 1;
                        month++;
                    }
                }
            }
            timing--;
        }
        String m = String.valueOf(month).length() == 1 ? "0" + month : "" + month;
        String d = String.valueOf(day).length() == 1 ? "0" + day : "" + day;
        System.out.println(year + "-" + m + "-" + d);
    }

    public static boolean isRunNian(int nian) {
        return nian % 400 == 0 || (nian % 4 == 0 && nian % 100 != 0);
    }
}
