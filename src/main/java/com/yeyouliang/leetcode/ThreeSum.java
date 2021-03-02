package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by YYL on 2021/3/3 : 0:01.
 */
public class ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> lli = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lli) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
            System.out.println("---------------------------------");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lli = new ArrayList<>();
        Set<Integer> oneZ = new HashSet<>();
        Set<Integer> oneF = new HashSet<>();
        List<Integer> zheng = new ArrayList<>();
        List<Integer> fu = new ArrayList<>();
        int zeroNum = 0;
        for (int num : nums) {
            if (num > 0) {
                zheng.add(num);
                oneZ.add(num);
            } else if (num < 0) {
                fu.add(num);
                oneF.add(num);
            } else {
                zeroNum++;
            }
        }
        int zSize = zheng.size();
        for (Integer integer : oneF) {
            if (zSize < 2) {
                break;
            }
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < zSize - 1; i++) {
                for (int j = i + 1; j < zSize; j++) {
                    int ii = zheng.get(i);
                    int jj = zheng.get(j);
                    if (integer + ii + jj == 0) {
                        String ij = "" + i + j;
                        String ji = "" + j + i;
                        if (!strings.contains(ij) && !strings.contains(ji)) {
                            List<Integer> list = new ArrayList<>();
                            list.add(integer);
                            list.add(ii);
                            list.add(jj);
                            lli.add(list);
                            strings.add(ij);
                            strings.add(ji);
                        }
                    }
                }
            }
        }

        int fSize = fu.size();
        for (Integer integer : oneZ) {
            if (fSize < 2) {
                break;
            }
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < fSize - 1; i++) {
                for (int j = i + 1; j < fSize; j++) {
                    int ii = fu.get(i);
                    int jj = fu.get(j);
                    if (integer + ii + jj == 0) {
                        String ij = "" + i + j;
                        String ji = "" + j + i;
                        if (!strings.contains(ij) && !strings.contains(ji)) {
                            List<Integer> list = new ArrayList<>();
                            list.add(integer);
                            list.add(ii);
                            list.add(jj);
                            lli.add(list);
                            strings.add(ij);
                            strings.add(ji);
                        }
                    }
                }
            }
        }

        if (zeroNum > 0) {
            for (Integer f : oneF) {
                for (Integer z : oneZ) {
                    if (f + z == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(0);
                        list.add(f);
                        list.add(z);
                        lli.add(list);
                    }
                }
            }
            if (zeroNum >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(0);
                list.add(0);
                list.add(0);
                lli.add(list);
            }
        }
        return lli;
    }
}
