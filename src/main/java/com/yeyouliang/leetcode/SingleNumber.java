package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/3/4 : 20:45.
 */
public class SingleNumber {
    
    public static void main(String[] args) {
        out(new int[]{24, 6, 7, 6, 7});
    }

    /**
     * 输入: [4,6,7,6,7]
     * 输出: 4
     */
    public static int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j] && nums[j] != -1) {
                    nums[i] = -1;
                    nums[j] = -1;
                    break;
                }
            }
        }
        int ii = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                ii = nums[i];
                break;
            }
        }
        return ii;
    }

    public static void out(int[] ints) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < ints.length; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    for (int l = 0; l < ints.length; l++) {
                        if (i == l || j == l || k == l) {
                            continue;
                        }
                        for (int m = 0; m < ints.length; m++) {
                            if (i == m || j == m || k == m || l == m) {
                                continue;
                            }
                            String s = "" + ints[i] + "-" + ints[j] + "-" + ints[k] + "-" + ints[l] + "-" + ints[m];
                            if (!list.contains(s)) {
                                list.add(s);
                                int noRepeat = singleNumber(new int[]{ints[i], ints[j], ints[k], ints[l], ints[m]});
                                System.out.println(s + "," + noRepeat);
                            }
                        }
                    }
                }
            }
        }
    }
}
