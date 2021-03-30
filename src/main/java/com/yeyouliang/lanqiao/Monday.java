package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/3/29 : 20:52.
 */
public class Monday {
    /**
     * 星期一
     * 整个20世纪（1901年1月1日至2000年12月31日之间），一共有多少个星期一？
     * (不要告诉我你不知道今天是星期几)
     */
    public static void main(String[] args) {
        int year = 2000;
        int month = 12;
        int day = 25;//2000年最后一个星期一
        int count = 1;
        int[] ymd = {1901, 1, 1};
        while (true) {
            if (day > 7) {
                day -= 7;
            } else {
                if (month == 3) {
                    int d = 28;
                    if (isRunNian(year)) {
                        d = 29;
                    }
                    day = d + day - 7;
                    month--;
                } else if (month == 2 || month == 4 || month == 6 || month == 8 || month == 9 || month == 11 || month == 1) {
                    day = 31 + day - 7;
                    if (month == 1) {
                        month = 12;
                        year--;
                    } else {
                        month--;
                    }
                } else if (month == 5 || month == 7 || month == 10 || month == 12) {
                    day = 30 + day - 7;
                    month--;
                }
            }
            count++;
            if (year < ymd[0]) {
                break;
            }
        }
        System.out.println(count);
    }

    public static boolean isRunNian(int nian) {
        return nian % 400 == 0 || (nian % 4 == 0 && nian % 100 != 0);
    }
}
