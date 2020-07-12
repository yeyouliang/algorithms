package com.yeyouliang.sort;

import com.yeyouliang.util.Tools;
import org.junit.Test;

import java.util.Arrays;

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
        System.out.println(" 原始数列->"+Arrays.toString(shu));
        kuaisu(shu, 0, shu.length-1);
        System.out.println("最终结果："+Arrays.toString(shu));
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
            System.out.println("leftLoop ："+Arrays.toString(ins));
            kuaisu(ins, start, (start + leftCount)-1);//因为加上了数量，所以要减1
        }
        if (rightCount > 1) {//少于2可知其位置已最终确定，所以不再循环。
            System.out.println("rightLoop："+Arrays.toString(ins));
            kuaisu(ins, start + leftCount + 1, ((start + leftCount + 1) + rightCount)-1);//因为加上了数量，所以要减1
        }
    }
}
