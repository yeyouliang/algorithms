package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YYL on 2021/5/30 : 21:49.
 */
public class NetworkRoute {
    /**
     * 所有节点对外的通路
     * */
    private static Map<Integer, List<Integer>> mil = new LinkedHashMap<>();

    /**
     * 网络寻路
     * X 国的一个网络使用若干条线路连接若干个节点。节点间的通信是双向的。某重要数据包，为了安全起见，必须恰好被转发两次到达目的地。
     * 该包可能在任意一个节点产生，我们需要知道该网络中一共有多少种不同的转发路径。
     * 源地址和目标地址可以相同，但中间节点必须不同。
     *
     * 用户输入：
     * 3 3
     * 1 2
     * 2 3
     * 1 3
     * 则程序应该输出：
     * 6
     *
     * 用户输入：
     * 4 4
     * 1 2
     * 2 3
     * 3 1
     * 1 4
     * 则程序应该输出：
     * 10
     */
    public static void main(String[] args) {
        int [][]ints={{1,2},{2,3},{1,3}};
        //int[][] ints = {{1, 2}, {2, 3}, {3, 1}, {1, 4}};
        int[] count = new int[1];
        //组装节点的通路
        for (int[] anInt : ints) {
            int one = anInt[0];
            int two = anInt[1];
            if (mil.containsKey(one)) {
                List<Integer> list = mil.get(one);
                if (!list.contains(two)) {
                    list.add(two);
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(two);
                mil.put(one, list);
            }
            if (mil.containsKey(two)) {
                List<Integer> list = mil.get(two);
                if (!list.contains(one)) {
                    list.add(one);
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(one);
                mil.put(two, list);
            }
        }
        //所有的节点（不重复）
        List<Integer> list = new ArrayList<>(mil.keySet());
        //对任意两个节点验证能否刚好经过两此转发到达
        for (Integer aList : list) {
            for (Integer aList1 : list) {
                int start = aList;
                int end = aList1;
                nr(start, end, 0, start, count);
            }
        }
        System.out.println(count[0]);
    }

    public static void nr(int start, int end, int distance, int node, int[] count) {
        List<Integer> nodes = mil.get(node);
        if (distance == 0) {
            for (Integer integer : nodes) {
                if (integer != end) {
                    nr(start, end, distance + 1, integer, count);
                }
            }
        } else if (distance == 1) {
            for (Integer integer : nodes) {
                if (integer != node && integer != start && integer != end) {
                    nr(start, end, distance + 1, integer, count);
                }
            }
        } else {
            if (nodes.contains(end)) {
                count[0]++;
            }
        }
    }
}
