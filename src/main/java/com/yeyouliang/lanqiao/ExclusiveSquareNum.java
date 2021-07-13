package com.yeyouliang.lanqiao;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by YYL on 2021/7/13 : 21:07.
 */
public class ExclusiveSquareNum {
    /**
     * 排它平方数
     * 题目描述
     * 小明正看着 203879 这个数字发呆。
     * 原来，203879 * 203879 = 41566646641
     * 这有什么神奇呢？仔细观察，203879 是个6位数，并且它的每个数上的数字都是不同的，并且它平方后的所有数位上都不出现组成它自身的数字。
     * 具有这样特点的6位数还有一个，请你找出它！
     * 再归纳一下筛选要求：
     * 1. 6位正整数
     * 2. 每个数位上的数字不同
     * 3. 其平方数的每个数位不含原数字的任何组成数位
     * 答案是一个6位的正整数。
     */
    public static void main(String[] args) {
        for (int i = 100_000; i < 999_999; i++) {
            String s = String.valueOf(i);
            Set<String> set = new HashSet<>();
            Collections.addAll(set, s.split(""));
            if (set.size() < 6) {
                continue;
            }
            BigInteger bigInteger = new BigInteger(s);
            BigInteger mul = bigInteger.multiply(bigInteger);
            boolean falg = true;
            for (String s1 : mul.toString().split("")) {
                if (set.contains(s1)) {
                    falg = false;
                    break;
                }
            }
            if (falg) {
                System.out.println(s);
            }
        }
    }
}
