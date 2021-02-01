package com.yeyouliang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YYL on 2021/2/1 : 20:12.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15, 25, 19, 38, 145};
        int target = 117;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
            if (target != ints[i] && map.containsKey(ints[i])) {
                System.out.println(i + "," + map.get(ints[i]));
                return;
            } else {
                map.put(target - ints[i], i);
            }
        }
        System.out.println("none");
    }
}
