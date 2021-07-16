package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/7/16 : 21:10.
 */
public class StackPopOrder {
    /**
     * 出栈次序
     * X星球特别讲究秩序，所有道路都是单行线。一个甲壳虫车队，共16辆车，按照编号先后发车，夹在其它车流中，缓缓前行。
     * 路边有个死胡同，只能容一辆车通过，是临时的检查站，如图【p1.png】所示。
     * X星球太死板，要求每辆路过的车必须进入检查站，也可能不检查就放行，也可能仔细检查。
     * 如果车辆进入检查站和离开的次序可以任意交错。那么，该车队再次上路后，可能的次序有多少种？
     * 为了方便起见，假设检查站可容纳任意数量的汽车。
     * 显然，如果车队只有1辆车，可能次序1种；2辆车可能次序2种；3辆车可能次序5种。
     * 现在足足有16辆车啊，亲！需要你计算出可能次序的数目。
     * 这是一个整数，请通过浏览器提交答案，不要填写任何多余的内容（比如说明性文字）。
     * */
    public static void main(String[] args) {
        //String []strings={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"};
        //List<String> list= Stream.of("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P").collect(Collectors.toList());
        List<String> list = Stream.of("A", "B", "C").collect(Collectors.toList());
        int[] count = new int[1];
        Set<List<String>> set = new HashSet<>();
        spo(list, new ArrayList<>(), new ArrayList<>(), count, set);
        System.out.println(set.size());
    }

    private static void spo(List<String> list, List<String> out, List<String> stack, int[] count, Set<List<String>> set) {
        if (list.isEmpty()) {
            if (!stack.isEmpty()) {
                for (int i = stack.size() - 1; i >= 0; i--) {
                    out.add(stack.get(i));
                }
            }
            System.out.println(out);
            set.add(out);
            count[0]++;
            return;
        }
        String string = list.get(0);
        List<String> l = new ArrayList<>(list);
        l.remove(0);
        List<String> o = new ArrayList<>(out);
        o.add(string);
        List<String> s = new ArrayList<>(stack);
        spo(l, o, s, count, set);
        if (!stack.isEmpty()) {
            for (int i = stack.size() - 1; i >= 0; i--) {
                List<String> ll = new ArrayList<>(list);
                List<String> oo = new ArrayList<>(out);
                oo.add(stack.get(i));
                List<String> ss = new ArrayList<>(stack);
                ss.remove(i);
                spo(ll, oo, ss, count, set);
            }
        }
        List<String> li = new ArrayList<>(list);
        li.remove(0);
        List<String> ou = new ArrayList<>(out);
        List<String> st = new ArrayList<>(stack);
        st.add(string);
        spo(li, ou, st, count, set);
    }
}
