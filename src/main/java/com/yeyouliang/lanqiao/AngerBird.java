package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/5/29 : 20:30.
 */
public class AngerBird {
    /**
     * 愤怒的小鸟
     * X星球愤怒的小鸟喜欢撞火车！
     * 一根平直的铁轨上两火车间相距 1000 米，两火车（不妨称A和B）以时速 10米/秒 相对行驶。
     * 愤怒的小鸟从A车出发，时速50米/秒，撞向B车，然后返回去撞A车，再返回去撞B车，如此往复....两火车在相距1米处停车。
     * 问：这期间愤怒的小鸟撞 B 车多少次？
     */
    public static void main(String[] args) {
        int distance = 1000;
        int a = 0;
        int aSpeed = 10;
        int b = distance;
        int bSpeed = 10;
        int c = 0;
        int cSpeeed = 50;
        boolean x = true;
        int count = 0;
        while (b - a > 1) {
            if (x) {
                if (c >= b) {
                    c = b;
                    cSpeeed = -50;
                    x = false;
                    count++;
                }
            } else {
                if (c <= a) {
                    c = a;
                    cSpeeed = 50;
                    x = true;
                }
            }
            a += aSpeed;
            b -= bSpeed;
            c += cSpeeed;
        }
        System.out.println(count);
    }
}
