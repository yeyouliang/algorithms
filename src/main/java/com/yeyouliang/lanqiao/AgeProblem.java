package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/6/1 : 20:13.
 */
public class AgeProblem {
    /**
     * 年龄问题
     * s夫人一向很神秘。这会儿有人问起她的年龄，她想了想说："20年前，我丈夫的年龄刚好是我的2倍，而现在他的年龄刚好是我的1.5倍"。
     * 你能算出s夫人现在的年龄吗？
     * */
    public static void main(String[] args) {
        for (int i = 100; i > 0; i--) {
            int a = i * 3 / 2;
            int b = i * 3 % 2;
            int aa = a - 20;
            int ii = i - 20;
            int c = aa / ii;
            int d = aa % ii;
            if (b == 0 && d == 0 && c == 2) {
                System.out.println(i);
                return;
            }
        }
    }
}
