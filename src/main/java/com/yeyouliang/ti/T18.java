package com.yeyouliang.ti;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/11/22 : 22:06.
 */
public class T18 {
    public static void main(String[] args) {
        List<String> a = Stream.of("a", "b", "c").collect(Collectors.toList());
        List<String> b = Stream.of("x", "y", "z").collect(Collectors.toList());
        m1(a, b, new ArrayList<>());
    }

    /**
     * 两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。有人向队员打听比赛的名单。
     * a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
     */
    private static void m1(List<String> a, List<String> b, List<String> r) {
        if (a.isEmpty()) {
            r.forEach(System.out::println);
            System.out.println("-------------------");
        } else {
            for (int i = 0; i < a.size(); i++) {
                for (int j = 0; j < b.size(); j++) {
                    String c = a.get(i);
                    String d = b.get(j);
                    if ((Objects.equals(c, "a") && Objects.equals(d, "x")) || (Objects.equals(c, "c") && (Objects.equals(d, "x") || Objects.equals(d, "z")))) {
                    } else {
                        List<String> e = new ArrayList<>(a);
                        e.remove(i);
                        List<String> f = new ArrayList<>(b);
                        f.remove(j);
                        List<String> t = new ArrayList<>(r);
                        t.add(c + "-" + d);
                        m1(e, f, t);
                    }
                }
            }
        }
    }
}
