package com.yeyouliang.sort;

import com.yeyouliang.util.Tools;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by YEYOULIANG on 2020/4/28.
 */
public class Sort {

    @Test
    public void maopao(){//冒泡排序
        Integer []shu= Tools.getRandomInt(30,10);
        System.out.println(Arrays.toString(shu)+" <-原始数列");
        int tmp=0;
        for (int i=shu.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if (shu[j]>shu[j+1]){
                    tmp=shu[j+1];
                    shu[j+1]=shu[j];
                    shu[j]=tmp;
                }
            }
            System.out.println(Arrays.toString(shu)+" <-第"+(shu.length-i)+"次排序结果");
        }
    }
}
