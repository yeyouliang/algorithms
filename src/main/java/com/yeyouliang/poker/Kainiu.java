package com.yeyouliang.poker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by YYL on 2021/2/19 : 20:07.
 */
public class Kainiu {
    public static void main(String[] args) {//59049
        int all = 0;
        int cheng = 0;
        int santiao=0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    for (int l = 1; l < 10; l++) {
                        for (int m = 1; m < 10; m++) {
                            int[] ints = {i, j, k, l, m};
                            if (theSame(ints)==ints.length){
                                continue;
                            }
                            all++;
                            if (theSame(ints)>2){
                                santiao++;
                            }
                            cheng += addIS_10_Or_20(ints);
                        }
                    }
                }
            }
        }
        System.out.println(cheng + "/" + all);
        System.out.println(santiao);
    }

    public static int theSame(int []ints){
        Set<Integer> set=new HashSet<>();
        for (int anInt : ints) {
            set.add(anInt);
        }
        return ints.length-set.size()+1;
    }

    public static int addIS_10_Or_20(int[] ints) {
        for (int anInt : ints) {
            for (int anInt1 : ints) {
                if (anInt == anInt1) {
                    continue;
                }
                for (int anInt2 : ints) {
                    if (anInt == anInt2 || anInt1 == anInt2) {
                        continue;
                    }
                    if (anInt + anInt1 + anInt2 == 10 || anInt + anInt1 + anInt2 == 20) {
                        System.out.println(Arrays.toString(ints));
                        System.out.println("" + anInt + "+" + anInt1 + "+" + anInt2);
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
