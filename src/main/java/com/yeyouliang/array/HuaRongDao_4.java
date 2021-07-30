package com.yeyouliang.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/7/30 : 19:39.
 */
public class HuaRongDao_4 {
    /**
     * key为各个字母的下标，value为从该字母能移动一步到达的另一个字母的位置。
     */
    private static Map<Integer, List<Integer>> map = new HashMap<>();
    private static Queue<String> queue = new ArrayDeque<>();
    private static List<String> listString = new ArrayList<>();

    /**
     * 4阶，对某个组合进行遍历，看是否能复原。
     * 1,2
     * 3,0
     * -------------
     * 1-2-3-0
     * 此字符串各字符的下标(1:0),(2:2),(3:4),(0:6)
     */
    public static void main(String[] args) {
        //1的下标为0，根据上下左右的顺序，它只有下和右两个方向可走，下面的3的下标是4，右边的2的下标是2。以此类推。
        map.put(0, Stream.of(4, 2).collect(Collectors.toList()));
        map.put(2, Stream.of(6, 0).collect(Collectors.toList()));
        map.put(4, Stream.of(0, 6).collect(Collectors.toList()));
        map.put(6, Stream.of(2, 4).collect(Collectors.toList()));
        String start = "1-2-3-0";
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
        listString.forEach(System.out::println);
    }
}
