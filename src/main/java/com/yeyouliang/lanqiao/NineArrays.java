package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/7/19 : 20:42.
 */
public class NineArrays {
    /**
     * 九数组分数
     * 1,2,3...9 这九个数字组成一个分数，其值恰好为1/3，如何组法？
     * */
    public static void main(String[] args) {
        int num = 1;
        while (num < 100_000) {
            int x3 = num * 3;
            String up = String.valueOf(num);
            String down = String.valueOf(x3);
            if (up.length() + down.length() == 9 && !up.contains("0") && !down.contains("0")) {
                boolean falg = true;
                int[] ints = new int[9];
                StringBuilder sb = new StringBuilder();
                sb.append(up);
                sb.append(down);
                System.out.println(sb.toString());
                for (String s : sb.toString().split("")) {
                    int i = Integer.parseInt(s);
                    if (ints[i - 1] == 1) {
                        falg = false;
                        break;
                    } else {
                        ints[i - 1] = 1;
                    }
                }
                if (falg) {
                    System.out.println(up + "," + down);
                    break;
                }
            }
            num += 3;
        }
    }
}
