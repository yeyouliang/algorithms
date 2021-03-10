package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/3/10 : 22:02.
 */
public class Divide_ {
    
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = new ArrayList<>();
        print(list, result);
    }

    public static void print(List<Integer> list, List<Integer> result) {
        if (list.size() == 0) {
            int lmn = Integer.valueOf("" + result.get(3) + result.get(4) + result.get(5));
            int opq = Integer.valueOf("" + result.get(6) + result.get(7) + result.get(8));
            int yu = opq % result.get(2);
            int bc = opq / result.get(2);
            if (yu == 0) {
                if (result.get(0) * opq + result.get(1) * bc + lmn == opq * 10) {
                    System.out.println("" + result.get(0) + "," + result.get(1) + "," + result.get(2) + "," + lmn + "," + opq);
                }
            }
            return;
        }
        for (Integer integer : list) {
            List<Integer> li = new ArrayList<>();
            for (Integer integer1 : list) {
                if (!integer.equals(integer1)) {
                    li.add(integer1);
                }
            }
            List<Integer> res = new ArrayList<>(result);
            res.add(integer);
            print(li, res);
        }
    }
}
