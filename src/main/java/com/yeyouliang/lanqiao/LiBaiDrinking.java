package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/3/23 : 20:37.
 */
public class LiBaiDrinking {
    /**
     * 李白打酒
     * 话说大诗人李白，一生好饮。幸好他从不开车。
     * 一天，他提着酒壶，从家里出来，酒壶中有酒2斗。他边走边唱：
     * 无事街上走，提壶去打酒。
     * 逢店加一倍，遇花喝一斗。
     * 这一路上，他一共遇到店5次，遇到花10次。已知最后一次遇到的是花，他正好把酒喝光了。
     * 请你计算李白遇到店和花的次序，可以把遇店记为a，遇花记为b。则：babaabbabbabbbb就是合理的次序。像这样的答案一共有多少呢？
     */
    public static void main(String[] args) {
        drink(2, 5, 10, new ArrayList<>());
    }

    public static void drink(int count, int shop, int flower, List<String> list) {
        if (count == 0) {
            if (shop == 0 && flower == 0) {
                System.out.println(list);
            }
            return;
        }
        if (count > flower) {
            return;
        }
        List<String> li = new ArrayList<>(list);
        li.add("a");
        drink(count * 2, shop - 1, flower, li);
        List<String> lii = new ArrayList<>(list);
        lii.add("b");
        drink(count - 1, shop, flower - 1, lii);
    }
}
