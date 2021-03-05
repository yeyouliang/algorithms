package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/3/5 : 21:57.
 */
public class BlewCandles {
    /**
     * 生日蜡烛
     * 某君从某年开始每年都举办一次生日party，并且每次都要吹熄与年龄相同根数的蜡烛。
     * 现在算起来，他一共吹熄了236根蜡烛。
     * 请问，他从多少岁开始过生日party的？
     */
    public static void main(String[] args) {
        int count = 9;
        for (int i = 2; i < count; i++) {
            StringBuilder sb = new StringBuilder();
            int a = i % 2;
            int aa = i / 2;
            int b = count / i;
            int c = 0;
            if (a == 0) {
                for (int j = b; j > ((b - aa) < 0 ? 0 : (b - aa)); j--) {
                    sb.append(j);
                    sb.append(",");
                    c += j;
                }
                for (int j = b + 1; j <= (b + aa); j++) {
                    sb.append(j);
                    sb.append(",");
                    c += j;
                }
            } else {
                for (int j = b - 1; j > ((b - aa - 1) < 0 ? 0 : (b - aa - 1)); j--) {
                    sb.append(j);
                    sb.append(",");
                    c += j;
                }
                c += b;
                sb.append(b);
                sb.append(",");
                for (int j = b + 1; j <= (b + aa); j++) {
                    sb.append(j);
                    sb.append(",");
                    c += j;
                }
            }
            if (c == count) {
                System.out.println(sb.toString());
            }
        }
    }
}
