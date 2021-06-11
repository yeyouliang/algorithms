package com.yeyouliang.lanqiao;

import java.util.Stack;

/**
 * Created by YYL on 2021/6/11 : 19:44.
 */
public class ShrinkAdd {
    /**
     * 缩位求和
     * https://blog.csdn.net/qq_42798905/article/details/88116228
     * */
    public static void main(String[] args) {
        String o = "7583676109608471656473500295825";
        System.out.println(sd(o));
    }

    public static int sd(String o) {
        if (o.length() == 1) {
            return Integer.valueOf(o);
        }
        int ten = 0;
        Stack<String> a1 = new Stack<>();
        Stack<String> b2 = new Stack<>();
        Stack<String> c3 = new Stack<>();
        Stack<String> d4 = new Stack<>();
        Stack<String> e5 = new Stack<>();
        Stack<String> f6 = new Stack<>();
        Stack<String> g7 = new Stack<>();
        Stack<String> h8 = new Stack<>();
        Stack<String> i9 = new Stack<>();
        for (String s : o.split("")) {
            switch (s) {
                case "1":
                    if (!i9.empty()) {
                        i9.pop();
                        ten++;
                    } else {
                        a1.push(s);
                    }
                    break;
                case "2":
                    if (!h8.empty()) {
                        h8.pop();
                        ten++;
                    } else {
                        b2.push(s);
                    }
                    break;
                case "3":
                    if (!g7.empty()) {
                        g7.pop();
                        ten++;
                    } else {
                        c3.push(s);
                    }
                    break;
                case "4":
                    if (!f6.empty()) {
                        f6.pop();
                        ten++;
                    } else {
                        d4.push(s);
                    }
                    break;
                case "5":
                    if (!e5.empty()) {
                        e5.pop();
                        ten++;
                    } else {
                        e5.push(s);
                    }
                    break;
                case "6":
                    if (!d4.empty()) {
                        d4.pop();
                        ten++;
                    } else {
                        f6.push(s);
                    }
                    break;
                case "7":
                    if (!c3.empty()) {
                        c3.pop();
                        ten++;
                    } else {
                        g7.push(s);
                    }
                    break;
                case "8":
                    if (!b2.empty()) {
                        b2.pop();
                        ten++;
                    } else {
                        h8.push(s);
                    }
                    break;
                case "9":
                    if (!a1.empty()) {
                        a1.pop();
                        ten++;
                    } else {
                        i9.push(s);
                    }
                    break;
            }
        }
        return sd("" + (ten * 10 + a1.size() + b2.size() * 2 + c3.size() * 3 + d4.size() * 4 + e5.size() * 5 + f6.size() * 6 + g7.size() * 7 + h8.size() * 8 + i9.size() * 9));
    }
}
