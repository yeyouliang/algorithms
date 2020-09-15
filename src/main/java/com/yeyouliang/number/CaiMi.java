package com.yeyouliang.number;

import org.junit.Test;

/**
 * Created by YYL on 2020/9/14.
 */
public class CaiMi {

    /*
    * 元宵节灯会上有一迷题：请猜谜*请猜谜 = 请边赏灯边猜，小明想，一定是每个汉字代表一个数字，不同的汉字代表不同的数字。请你用计算机按小明的思路算一下，然后提交“请猜谜”三个字所代表的整数即可。
    * */
    @Test
    public void caimi() {
        for (int i = 317; i < 1000; i++) {
            String ii = String.valueOf(i);
            if (ii.endsWith("0") || ii.endsWith("1") || ii.endsWith("5") || ii.endsWith("6")) {
                continue;
            }
            String pingfang = String.valueOf(i * i);
            if (pingfang.startsWith(ii.substring(0, 1)) && pingfang.endsWith(ii.substring(1, 2)) && pingfang.substring(1, 2).equals(pingfang.substring(4, 5))) {
                System.out.println(ii + "," + pingfang);
            }
        }
    }
}
