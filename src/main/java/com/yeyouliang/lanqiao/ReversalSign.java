package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/7/12 : 20:46.
 */
public class ReversalSign {
    /**
     * 颠倒的价牌
     * 小李的店里专卖其它店中下架的样品电视机，可称为：样品电视专卖店。
     * 其标价都是4位数字（即千元不等）。
     * 小李为了标价清晰、方便，使用了预制的类似数码管的标价签，只要用颜色笔涂数字就可以了（参见p1.jpg）。
     * 这种价牌有个特点，对一些数字，倒过来看也是合理的数字。如：1 2 5 6 8 9 0 都可以。这样一来，如果牌子挂倒了，有可能完全变成了另一个价格，比如：1958 倒着挂就是：8561，差了几千元啊!!
     * 当然，多数情况不能倒读，比如，1110 就不能倒过来，因为0不能作为开始数字。
     * 有一天，悲剧终于发生了。某个店员不小心把店里的某两个价格牌给挂倒了。并且这两个价格牌的电视机都卖出去了!
     * 庆幸的是价格出入不大，其中一个价牌赔了2百多，另一个价牌却赚了8百多，综合起来，反而多赚了558元。
     * 请根据这些信息计算：赔钱的那个价牌正确的价格应该是多少？
     */
    public static void main(String[] args) {
        //int []ints={1,2,5,6,8,9,0};
        List<List<Integer>> kui = ps(-300, -200);
        System.out.println(kui.size());
        List<List<Integer>> zhuan = ps(800, 900);
        System.out.println(zhuan.size());
        for (List<Integer> k : kui) {
            for (List<Integer> z : zhuan) {
                int diff = k.get(1) + z.get(1);
                if (diff == 588) {
                    System.out.println(k.get(0) + "," + z.get(0));
                }
            }
        }
    }

    private static List<List<Integer>> ps(int min, int max) {
        List<List<Integer>> list = new ArrayList<>();
        String[] s = {"1", "2", "5", "6", "8", "9", "0"};
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                for (int k = 0; k < 7; k++) {
                    for (int l = 0; l < 6; l++) {
                        String a = s[i] + s[j] + s[k] + s[l];
                        int b = Integer.parseInt(a);
                        StringBuilder sb = new StringBuilder();
                        for (int m = 3; m >= 0; m--) {
                            String num = a.substring(m, m + 1);
                            if ("6".equals(num)) {
                                num = "9";
                            } else if ("9".equals(num)) {
                                num = "6";
                            }
                            sb.append(num);
                        }
                        int d = Integer.parseInt(sb.toString());
                        int diff = b - d;
                        if (diff < max && diff >= min) {
                            List<Integer> li = new ArrayList<>();
                            li.add(Integer.parseInt(a));
                            li.add(diff);
                            list.add(li);
                        }
                    }
                }
            }
        }
        return list;
    }
}
