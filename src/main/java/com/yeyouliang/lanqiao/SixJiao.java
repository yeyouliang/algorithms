package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/4/14 : 21:34.
 */
public class SixJiao {
    /**
     * 六角填数
     * https://blog.csdn.net/weixin_44107920/article/details/107879677
     */
    public static void main(String[] args) {
        List<Integer> origin = Stream.of(2, 4, 5, 6, 7, 9, 10, 11, 12).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        sj(origin, result, 0);
    }

    public static void sj(List<Integer> origin, List<Integer> result, int count) {
        int size = origin.size();
        if (size == 0) {
            System.out.println(result);
            return;
        }
        if (result.size() == 4) {
            int c = 1 + result.get(0) + result.get(1) + result.get(2);
            if (c == 8 + result.get(1) + result.get(3) + 3) {
                count = c;
            } else {
                return;
            }
        }
        if (result.size() == 6) {
            int c = result.get(2) + result.get(3) + result.get(4) + result.get(5);
            if (count != c) {
                return;
            }
        }
        if (result.size() == 8) {
            int c = 3 + result.get(4) + result.get(6) + result.get(7);
            int cc = result.get(5) + result.get(6) + origin.get(0) + 1;
            if (count != c || count != cc) {
                return;
            }
        }
        for (Integer integer : origin) {
            List<Integer> or = new ArrayList<>(origin);
            or.remove(integer);
            List<Integer> re = new ArrayList<>(result);
            re.add(integer);
            sj(or, re, count);
        }
    }
}
