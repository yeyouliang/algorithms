package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/4/15 : 22:26.
 */
public class WinterVacationTask {
    /**
     * 寒假作业
     * 每个方块代表1～13中的某一个数字，但不能重复。
     * | |+| |=| |
     * | |-| |=| |
     * | |×| |=| |
     * | |/| |=| |
     * 比如：
     * 6+7=13
     * 9-8=1
     * 3×4=12
     * 10/2=5
     * 以及：
     * 7+6=13
     * 9-8=1
     * 3×4=12
     * 10/2=5
     * 就算两种解法（加法，乘法交换律后算不同的方案）。你一共找到了多少种方案？
     * */
    public static void main(String[] args) {
        int a=13/2;
        for (int i = 2; i <= a; i++) {
            for (int j = i*2; j < 14; j++) {
                int yu=j%i;
                int shang=j/i;
                if (j!=0 || shang==i){
                    continue;
                }

            }
        }
    }
}
