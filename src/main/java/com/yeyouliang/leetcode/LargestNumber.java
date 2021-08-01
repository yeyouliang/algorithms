package com.yeyouliang.leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/8/1 : 14:51.
 */
public class LargestNumber {
    /**
     * 179. 最大数
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * 示例 1：
     * 输入：nums = [10,2]
     * 输出："210"
     * 示例 2：
     * 输入：nums = [3,30,34,5,9]
     * 输出："9534330"
     * 示例 3：
     * 输入：nums = [1]
     * 输出："1"
     * 示例 4：
     * 输入：nums = [10]
     * 输出："10"
     */
    public static void main(String[] args) {
        List<Integer> list = Stream.of(35, 353, 303, 3, 350, 31, 355, 30, 301, 352, 333, 320, 356).collect(Collectors.toList());
        list.sort((o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            int f1 = Integer.parseInt(s1.substring(0, 1));
            int f2 = Integer.parseInt(s2.substring(0, 1));
            if (f1 < f2) {
                return -1;
            } else if (f1 > f2) {
                return 1;
            } else {
                if (o1.equals(o2)) {
                    return 0;
                } else {
                    String a = "" + o1 + o2;
                    String b = "" + o2 + o1;
                    Integer c = Integer.valueOf(a);
                    Integer d = Integer.valueOf(b);
                    return c.compareTo(d);
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int size = list.size() - 1; size >= 0; size--) {
            sb.append(list.get(size));
        }
        System.out.println(sb.toString());
    }
}
