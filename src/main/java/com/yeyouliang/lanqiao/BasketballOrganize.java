package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/4/9 : 21:20.
 */
public class BasketballOrganize {
    /**
     * 
     * */
    public static void main(String[] args) {
        int[][] ints = {
                {97, 90, 0, 0, 0},//0
                {92, 85, 96, 0, 0},
                {0, 0, 0, 0, 93},
                {0, 0, 0, 80, 86},
                {89, 83, 97, 0, 0},
                {82, 86, 0, 0, 0},
                {0, 0, 0, 87, 90},
                {0, 97, 96, 0, 0},
                {0, 0, 89, 0, 0},
                {95, 99, 0, 0, 0},//1
                {0, 0, 96, 97, 0},//3
                {0, 0, 0, 93, 98},//4
                {94, 91, 0, 0, 0},
                {0, 83, 87, 0, 0},
                {0, 0, 98, 97, 98},
                {0, 0, 0, 93, 86},
                {98, 83, 99, 98, 81},//2
                {93, 87, 92, 96, 98},
                {0, 0, 0, 89, 92},
                {0, 99, 96, 95, 81}};
        int max = 0;
        for (int i = 0; i < ints.length - 4; i++) {
            for (int j = i + 1; j < ints.length - 3; j++) {
                for (int k = j + 1; k < ints.length - 2; k++) {
                    for (int l = k + 1; l < ints.length - 1; l++) {
                        for (int m = l + 1; m < ints.length; m++) {

                            for (int o = 0; o < ints[i].length; o++) {
                                for (int p = 0; p < ints[j].length; p++) {
                                    if (o == p) {
                                        continue;
                                    }
                                    for (int q = 0; q < ints[k].length; q++) {
                                        if (o == q || p == q) {
                                            continue;
                                        }
                                        for (int r = 0; r < ints[l].length; r++) {
                                            if (o == r || p == r || q == r) {
                                                continue;
                                            }
                                            for (int s = 0; s < ints[m].length; s++) {
                                                if (o == s || p == s || q == s || r == s) {
                                                    continue;
                                                }
                                                int ma = ints[i][o] + ints[j][p] + ints[k][q] + ints[l][r] + ints[m][s];
                                                if (ma > max) {
                                                    System.out.println(ma + "||" + i + "(" + o + ")||" + j + "(" + p + ")||" + k + "(" + q + ")||" + l + "(" + r + ")||" + m + "(" + s + ")");
                                                    max = ma;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
