package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/3/23 : 20:49.
 */
public class LuckNumber {

    /**
     * 第几个幸运数
     * 到x星球旅行的游客都被发给一个整数，作为游客编号。
     * x星的国王有个怪癖，他只喜欢数字3,5和7。
     * 国王规定，游客的编号如果只含有因子：3,5,7,就可以获得一份奖品。
     * 我们来看前10个幸运数字是：
     * 3 5 7 9 15 21 25 27 35 45
     * 因而第11个幸运数字是：49
     * 小明领到了一个幸运数字 59084709587505，他去领奖的时候，人家要求他准确地说出这是第几个幸运数字，否则领不到奖品。
     * 请你帮小明计算一下，59084709587505是第几个幸运数字。
     */
    public static void main(String[] args) {
        //long num = 59084709587505L;
        long num = 7505L;
        long count =0L;
        for (long i = 10L; i < num; i=i+1L) {
            if (ln(i)){
                count=count+1L;
            }
        }
        System.out.println(count);
    }


    public static boolean ln(long num) {
        while (num % 3L == 0L || num % 5L == 0L || num % 7L == 0L) {
            if (num % 3L == 0L) {
                num = num / 3L;
            } else if (num % 5L == 0L) {
                num = num / 5L;
            } else if (num % 7L == 0L) {
                num = num / 7L;
            }
            if (num == 1L) {
                return true;
            } else if (num < 3L) {
                return false;
            }
        }
        return false;
    }
}
