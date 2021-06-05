package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/6/5 : 20:20.
 */
public class MysteryOfRoute {
    /**
     * 路径之谜
     * https://blog.csdn.net/weixin_42069140/article/details/90321956
     * */
    public static void main(String[] args) {
        /*int []x={2,4,3,4};
        int []y={4,3,3,3};*/
        List<Integer> h = Stream.of(3,4, 4, 2).collect(Collectors.toList());
        List<Integer> s = Stream.of(3, 3, 4, 3).collect(Collectors.toList());
        Map<Integer, List<Integer>> mil = new HashMap<>();
        mil.put(0, Stream.of(0, 0, 1, 4).collect(Collectors.toList()));
        mil.put(1, Stream.of(1, 0, 0, 2, 5).collect(Collectors.toList()));
        mil.put(2, Stream.of(2, 0, 1, 3, 6).collect(Collectors.toList()));
        mil.put(3, Stream.of(3, 0, 2, 7).collect(Collectors.toList()));
        mil.put(4, Stream.of(0, 1, 0, 5, 8).collect(Collectors.toList()));
        mil.put(5, Stream.of(1, 1, 1, 4, 6, 9).collect(Collectors.toList()));
        mil.put(6, Stream.of(2, 1, 2, 5, 7, 10).collect(Collectors.toList()));
        mil.put(7, Stream.of(3, 1, 3, 6, 11).collect(Collectors.toList()));
        mil.put(8, Stream.of(0, 2, 4, 9, 12).collect(Collectors.toList()));
        mil.put(9, Stream.of(1, 2, 5, 8, 10, 13).collect(Collectors.toList()));
        mil.put(10, Stream.of(2, 2, 6, 9, 11, 14).collect(Collectors.toList()));
        mil.put(11, Stream.of(3, 2, 7, 10, 15).collect(Collectors.toList()));
        mil.put(12, Stream.of(0, 3, 8, 13).collect(Collectors.toList()));
        mil.put(13, Stream.of(1, 3, 9, 12, 14).collect(Collectors.toList()));
        mil.put(14, Stream.of(2, 3, 10, 13, 15).collect(Collectors.toList()));
        mil.put(15, Stream.of(3, 3, 11, 14).collect(Collectors.toList()));
        mor(h, s, mil, 0, 15, new ArrayList<>());
    }

    public static void mor(List<Integer> h, List<Integer> s, Map<Integer, List<Integer>> mil, int start, int end, List<Integer> route) {
        List<Integer> m = mil.get(start);
        int x = m.get(0);
        int y = m.get(1);
        int xx = h.get(x);
        int yy = s.get(y);
        if (xx == 0 || yy == 0) {
            return;
        }
        h.remove(x);
        h.add(x, xx - 1);
        s.remove(y);
        s.add(y, yy - 1);
        route.add(start);
        if (start == end) {
            if (check(h, s)){
                System.out.println(route);
            }
            return;
        }
        for (Integer integer : m.subList(2, m.size())) {
            if (!route.contains(integer)) {
                mor(new ArrayList<>(h), new ArrayList<>(s), mil, integer, end, new ArrayList<>(route));
            }
        }
    }

    public static boolean check(List<Integer> h, List<Integer> s) {
        for (Integer integer : h) {
            if (integer != 0) {
                return false;
            }
        }
        for (Integer integer : s) {
            if (integer != 0) {
                return false;
            }
        }
        return true;
    }
}
