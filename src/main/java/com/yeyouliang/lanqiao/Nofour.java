package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/3/14 : 10:18.
 */
public class Nofour {
    /**
     * 有些人很迷信数字，比如带“4”的数字，认为和“死”谐音，就觉得不吉利。
     * 虽然这些说法纯属无稽之谈，但有时还要迎合大众的需求。
     * 某抽奖活动的奖券号码是5位数（10000-99999），要求其中不要出现带“4”的号码，主办单位请你计算一下，如果任何两张奖券不重号，最多可发出奖券多少张。
     */
    public static void main(String[] args) {
        int count = 0;
        for (int i = 10000; i < 100000; i++) {
            if (!String.valueOf(i).contains("4")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
