package com.yeyouliang.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/7/26 : 21:14.
 */
public class HuaRongDao_9 {
    /**
     * key为各个字母的下标，value为从该字母能移动一步到达的另一个字母的位置。
     */
    private static Map<Integer, List<Integer>> map = new HashMap<>();
    private static Queue<String> queue = new ArrayDeque<>();
    private static List<String> listString = new ArrayList<>();

    /**
     * 9阶，对某个组合进行遍历，看是否能复原。
     * 1,2,3
     * 4,5,6
     * 7,8,0
     * -------------
     * 1-2-3-4-5-6-7-8-0
     * 此字符串各字符的下标(1:0),(2:2),(3:4),(4:6),(5:8),(6:10),(7:12),(8:14),(0:16)
     */
    public static void main(String[] args) {
        //1的下标为0，根据上下左右的顺序，它只有下和右两个方向可走，下面的4的下标是6，右边的2的下标是2。以此类推。
        map.put(0, Stream.of(6, 2).collect(Collectors.toList()));
        map.put(2, Stream.of(8, 0, 4).collect(Collectors.toList()));
        map.put(4, Stream.of(10, 2).collect(Collectors.toList()));
        map.put(6, Stream.of(0, 12, 8).collect(Collectors.toList()));
        map.put(8, Stream.of(2, 14, 6, 10).collect(Collectors.toList()));
        map.put(10, Stream.of(4, 16, 8).collect(Collectors.toList()));
        map.put(12, Stream.of(6, 14).collect(Collectors.toList()));
        map.put(14, Stream.of(8, 12, 16).collect(Collectors.toList()));
        map.put(16, Stream.of(10, 14).collect(Collectors.toList()));
        String start = "1-2-3-4-5-6-7-8-0";
        queue.add(start);
        listString.add(start);
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            if (poll != null) {
                int index = poll.indexOf("0");
                List<Integer> list = map.get(index);
                for (Integer integer : list) {
                    String s = poll;
                    String a = poll.substring(index, index + 1);
                    s = s.replace(a, "i");
                    String b = poll.substring(integer, integer + 1);
                    s = s.replace(b, "j");
                    s = s.replace("i", b);
                    s = s.replace("j", a);
                    if (listString.contains(s)) {
                        continue;
                    }
                    queue.add(s);
                    listString.add(s);
                }
            }
        }
        System.out.println(listString.size());
    }
}
