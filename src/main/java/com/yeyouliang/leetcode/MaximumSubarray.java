package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/3/14 : 14:13.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int []ints={-2,1,-3,4,-1,2,1,-5,4};
        List<Integer> list=new ArrayList<>();//1,3,5,6,8
        for (int i = 0; i < ints.length; i++) {
            if (ints[i]>0){
                list.add(i);
            }
        }
        List<Integer> add=new ArrayList<>();
        for (int i = 0; i < list.size()-1; i++) {
            int count=0;
            for (int j = list.get(i); j < list.get(i+1); j++) {
                count+=ints[j];
            }
            add.add(ints[list.get(i)]);
            add.add(count);
        }
        add.add(ints[list.get(list.size()-1)]);
        System.out.println(Arrays.toString(add.toArray()));
    }
}
