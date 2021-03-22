package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/3/22 : 21:31.
 */
public class Ruiqi_ {
    /**
     * 观察下面的加法算式：
     *     祥 瑞 生 辉
     * +   三 羊 献 瑞
     * -------------------
     *   三 羊 生 瑞 气
     * 其中，相同的汉字代表相同的数字，不同的汉字代表不同的数字。
     * 请你填写“三羊献瑞”所代表的4位数字（答案唯一），不要填写任何多余内容。
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = new ArrayList<>();
        print(list, result);
    }

    public static void print(List<Integer> list, List<Integer> result) {
        if (list.size() == 3) {
            if (result.get(0) != 0 && result.get(4) != 0) {
                int xrsh = Integer.valueOf("" + result.get(0) + result.get(1) + result.get(2) + result.get(3));
                int syxr = Integer.valueOf("" + result.get(4) + result.get(5) + result.get(6) + result.get(1));
                int count = xrsh + syxr;
                if (count > 10000) {
                    for (Integer integer : list) {
                        int sysrq = Integer.valueOf("" + result.get(4) + result.get(5) + result.get(2) + result.get(1) + integer);
                        if (count == sysrq) {
                            System.out.println(sysrq);
                            System.out.println(Arrays.toString(result.toArray()));
                            System.out.println(Arrays.toString(list.toArray()));
                        }
                    }
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
