package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/3/29 : 20:37.
 */
public class DrinkExchangeBuy {
    /**
     * 饮料换购
     * 乐羊羊饮料厂正在举办一次促销优惠活动。乐羊羊C型饮料，凭3个瓶盖可以再换一瓶C型饮料，并且可以一直循环下去，但不允许赊账。
     * 请你计算一下，如果小明不浪费瓶盖，尽量地参加活动，那么，对于他初始买入的n瓶饮料，最后他一共能得到多少瓶饮料。
     * */
    public static void main(String[] args) {
        int num = 101;
        System.out.println(dcb(num));
    }

    public static int dcb(int num) {
        if (num < 3) {
            return num;
        }
        int count = 0;
        while (num > 2) {
            num = num - 3 + 1;
            count += 3;
        }
        return count + num;
    }
}
