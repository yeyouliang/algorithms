package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/8/16 : 21:06.
 */
public class LastStoneWeight {
    /**
     * 1046. 最后一块石头的重量
     * */
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        //System.out.println(lastStoneWeight(new int[]{9, 10, 4, 5, 7, 1}));
    }

    private static int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        if (stones.length == 2) {
            return Math.abs(stones[0] - stones[1]);
        }
        for (int i = 1; i < stones.length; i++) {
            int index = i;
            while (index > 0 && stones[index - 1] > stones[index]) {
                int tmp = stones[index];
                stones[index] = stones[index - 1];
                stones[index - 1] = tmp;
                index--;
            }
        }
        int index = stones.length - 2;
        while (index > 0) {
            if (stones[index + 1] == stones[index]) {
                index = index - 2;
            } else {
                if (stones[index + 1] > stones[index]) {
                    stones[index] = stones[index + 1] - stones[index];
                    index--;
                } else {
                    for (int i = index; i >= 0; i--) {
                        if (stones[i] > stones[i + 1]) {
                            int tmp = stones[i + 1];
                            stones[i + 1] = stones[i];
                            stones[i] = tmp;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        if (index == -1) {
            return stones[0];
        } else if (index == 0) {
            return Math.abs(stones[0] - stones[1]);
        } else {
            return 0;
        }
    }
}
