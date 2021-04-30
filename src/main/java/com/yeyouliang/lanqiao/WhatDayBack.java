package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/4/30 : 19:15.
 */
public class WhatDayBack {
    /**
     * 哪天返回
     * 小明被不明势力劫持。后莫名其妙被扔到x星站再无问津。小明得知每天都有飞船飞往地球，但需要108元的船票，而他却身无分文。
     * 他决定在x星战打工。好心的老板答应包食宿，第1天给他1元钱。
     * 并且，以后的每一天都比前一天多2元钱，直到他有足够的钱买票。
     * 请计算一下，小明在第几天就能凑够108元，返回地球
     * */
    public static void main(String[] args) {
        int result = 108;
        int day = 1;
        int count=1;
        int pay=1;
        while (true) {
            //System.out.println(count);
            if (count >= result) {
                break;
            }
            pay+=2;
            count +=pay;
            day++;
        }
        System.out.println(day);
    }
}
