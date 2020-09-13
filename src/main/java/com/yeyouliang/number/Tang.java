package com.yeyouliang.number;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by YYL on 2020/9/13.
 */
public class Tang {

    /*
    * 有n个小朋友围坐成一圈。老师给每个小朋友随机发偶数个糖果，然后进行下面的游戏：每个小朋友都把自己的糖果分一半给左手边的孩子。一轮分糖后，拥有奇数颗糖的孩子由老师补给1个糖果，从而变成偶数。
    * 反复进行这个游戏，直到所有小朋友的糖果数都相同为止。你的任务是预测在已知的初始糖果情形下，老师一共需要补发多少个糖果。
    * */
    @Test
    public void testTang() {
        int[] count = new int[]{0};
        tang(count, new int[]{2, 2, 4});
        System.out.println(count[0]);
    }

    public void tang(int[] count, int arr[]) {
        int firstHalf = arr[0] / 2;
        int end1Half = arr[arr.length - 1] / 2;
        int end2Half = arr[arr.length - 2] / 2;
        for (int i = 0; i < arr.length - 2; i++) {
            int tmp = arr[i + 1];
            arr[i + 1] = tmp / 2 + arr[i] / 2;
        }
        arr[0] = firstHalf + end1Half;
        arr[arr.length - 1] = end1Half + end2Half;
        System.out.println(Arrays.toString(arr));
        if (addAndCheck(count, arr)) {
            tang(count, arr);
        }
    }

    public boolean addAndCheck(int[] count, int arr[]) {
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                arr[i] += 1;
                count[0]++;
            }
            integerSet.add(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
        return integerSet.size() > 1;
    }

}
