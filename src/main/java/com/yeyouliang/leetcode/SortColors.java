package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/8/21 : 20:20.
 */
public class SortColors {
    /**
     * 75. 颜色分类
     * */
    public static void main(String[] args) {
        sortColors(new int[]{1,2,1,2,2,0});
    }

    private static void sortColors(int[] nums) {
        int one = 0;
        int two = 0;
        int three = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    one++;
                    break;
                case 1:
                    two++;
                    break;
                case 2:
                    three++;
                    break;
            }
        }
        int index=0;
        for (int i = index; i < index+one; i++) {
            nums[i]=0;
        }
        index+=one;
        for (int i = index; i < index+two; i++) {
            nums[i]=1;
        }
        index+=two;
        for (int i = index; i < index+three; i++) {
            nums[i]=2;
        }
        System.out.println();
    }
}
