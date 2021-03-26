package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/3/26 : 19:59.
 */
public class SameDiffSuShu {
    /**
     * 标题：等差素数列
     * 2,3,5,7,11,13,....是素数序列。
     * 类似：7,37,67,97,127,157 这样完全由素数组成的等差数列，叫等差素数数列。
     * 上边的数列公差为30，长度为6。
     * 2004年，格林与华人陶哲轩合作证明了：存在任意长度的素数等差数列。
     * 这是数论领域一项惊人的成果！
     * 有这一理论为基础，请你借助手中的计算机，满怀信心地搜索：
     * 长度为10的等差素数列，其公差最小值是多少？
     * 注意：需要提交的是一个整数，不要填写任何多余的内容和说明文字。
     */
    public static void main(String[] args) {
        int length=9;
        for (int i = 3; i < 100000; i++) {
            System.out.println("--------------------------");
            if (isSuShu(i)) {
                for (int j = 1; j < 1000; j++) {
                    int count = 0;
                    int a = i;
                    for (int k = 0; k < length; k++) {
                        a += j;
                        if (isSuShu(a)) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (count == length) {
                        System.out.println("从"+i + "开始，逐个加上" + j+"。公差为："+j);
                        return;
                    }
                }
            }
        }
    }

    public static boolean isSuShu(int num) {
        boolean is = false;
        if (num % 2 != 0) {
            int half = num / 2;
            boolean has = true;
            for (int j = half; j > 2; j--) {
                if (j % 2 == 0) {
                    continue;
                }
                if (num % j == 0) {
                    has = false;
                    break;
                }
            }
            if (has) {
                is = true;
            }
        }
        return is;
    }
}
