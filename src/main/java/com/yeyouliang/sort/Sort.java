package com.yeyouliang.sort;

import com.yeyouliang.util.Tools;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YEYOULIANG on 2020/4/28.
 */
public class Sort {

    @Test
    public void maopao() {//冒泡排序
        Integer[] shu = Tools.getRandomInt(30, 10);
        System.out.println(Arrays.toString(shu) + " <-原始数列");
        int tmp = 0;
        for (int i = shu.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (shu[j] > shu[j + 1]) {
                    tmp = shu[j + 1];
                    shu[j + 1] = shu[j];
                    shu[j] = tmp;
                }
            }
            System.out.println(Arrays.toString(shu) + " <-第" + (shu.length - i) + "次排序结果");
        }
    }

    @Test
    public void zhijiecharu() {//直接插入排序
        Integer[] shu = Tools.getRandomInt(30, 10);
        System.out.println(Arrays.toString(shu) + " <-原始数列");
        Integer[] in = new Integer[shu.length];
        in[0] = shu[0];
        for (int i = 1; i < shu.length; i++) {
            for (int j = i - 1; j >= 0; j--) {//从尾部到头部比较和插入
                if (in[j] <= shu[i]) {//符合条件
                    if (j == i - 1) {//如果第一个即符合条件，直接填入下一个位置，跳出循环
                        in[i] = shu[i];
                        break;
                    } else {
                        for (int k = i; k > j + 1; k--) {//数据向后移动
                            in[k] = in[k - 1];
                        }
                        in[j + 1] = shu[i];
                        break;
                    }
                } else if (j == 0) {//如果头部仍不符合条件，全部后移，把数据填入头部位置
                    for (int k = i; k > 0; k--) {
                        in[k] = in[k - 1];
                    }
                    in[j] = shu[i];
                    break;
                }
            }
            System.out.println(Arrays.toString(in) + " <-第" + i + "次排序结果");
        }
    }

    @Test
    public void fastSort() {//快速排序
        Integer[] shu = Tools.getRandomInt(50, 10);
        System.out.println(" 原始数列->" + Arrays.toString(shu));
        kuaisu(shu, 0, shu.length - 1);
        System.out.println("最终结果：" + Arrays.toString(shu));
    }

    public void kuaisu(Integer[] ins, int start, int end) {//总是传入原始数组，start和end指定此次循环要操作的数据范围。每次循环都确定至少一个数字的最终位置。
        int diff = end - start + 1;
        int[] tmpI = new int[diff];//把要操作的数据备份出来
        for (int i = 0; i < diff; i++) {
            tmpI[i] = ins[start + i];
        }
        int iStart = tmpI[0];
        int[] left = new int[diff];
        int leftCount = 0;
        int[] right = new int[diff];
        int rightCount = 0;
        for (int i = 1; i < diff; i++) {
            if (tmpI[i] <= iStart) {
                left[leftCount] = tmpI[i];
                leftCount++;
            } else {
                right[rightCount] = tmpI[i];
                rightCount++;
            }
        }
        //将数据填回原始数组
        if (leftCount > 0) {
            for (int i = 0; i < leftCount; i++) {
                ins[start + i] = left[i];
            }
        }
        ins[start + leftCount] = iStart;
        if (rightCount > 0) {
            for (int i = 0; i < rightCount; i++) {
                ins[start + leftCount + 1 + i] = right[i];
            }
        }
        //对修改过的原始数组进行循环操作
        if (leftCount > 1) {//少于2可知其位置已最终确定，所以不再循环。
            System.out.println("leftLoop ：" + Arrays.toString(ins));
            kuaisu(ins, start, (start + leftCount) - 1);//因为加上了数量，所以要减1
        }
        if (rightCount > 1) {//少于2可知其位置已最终确定，所以不再循环。
            System.out.println("rightLoop：" + Arrays.toString(ins));
            kuaisu(ins, start + leftCount + 1, ((start + leftCount + 1) + rightCount) - 1);//因为加上了数量，所以要减1
        }
    }

    @Test
    public void xuanze() {//选择排序
        Integer[] shu = Tools.getRandomInt(50, 10);
        System.out.println(Arrays.toString(shu) + " <-原始数列");
        for (int i = 0; i < shu.length - 1; i++) {//0...8
            int minIndex = i;
            for (int j = i + 1; j < shu.length; j++) {//1...9
                if (shu[minIndex] > shu[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int tmp;
                tmp = shu[minIndex];
                shu[minIndex] = shu[i];
                shu[i] = tmp;
            }
            System.out.println(Arrays.toString(shu) + " <-第" + (i + 1) + "次排序结果");
        }
    }

    /**
     * 归并排序
     * */
    @Test
    public void guibing(){
        List<List<Integer>> list = Stream.of(2, 7, 1, 3, 5, 0, 6, 9, 8, 4).map(integer -> {
            List<Integer> ins = new ArrayList<>();
            ins.add(integer);
            return ins;
        }).collect(Collectors.toList());
        List<Integer> gb = gb(list);
        for (Integer integer : gb) {
            System.out.print(integer + ",");
        }
        System.out.println();
    }

    public static List<Integer> gb(List<List<Integer>> list) {
        int length = list.size();
        if (length == 1) {
            return list.get(0);
        }
        List<List<Integer>> li = new ArrayList<>();
        int start = 0;
        while (start < length) {
            List<Integer> result = new ArrayList<>();
            List<Integer> one = list.get(start);
            if (start + 1 == length) {
                li.add(one);
                break;
            }
            List<Integer> two = list.get(start + 1);
            int o = one.size();
            int t = two.size();
            while (true) {
                if (o == 0) {
                    if (t != 0) {
                        result.addAll(two);
                    }
                    break;
                }
                if (t == 0) {
                    result.addAll(one);
                    break;
                }
                Integer a = one.get(0);
                Integer b = two.get(0);
                if (a > b) {
                    result.add(b);
                    two.remove(b);
                    t--;
                } else {
                    result.add(a);
                    one.remove(a);
                    o--;
                }
            }
            li.add(result);
            start += 2;
        }
        return gb(li);
    }
}
