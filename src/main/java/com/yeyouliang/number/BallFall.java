package com.yeyouliang.number;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by YYL on 2020/8/22.
 */
public class BallFall {//一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？

    public BigDecimal[] ss(int n, int count, BigDecimal[] l_h) {//n：当前第几次下落，count：总共进行多少次，l_h[0]：在第n次下落后的总路程，l_h[1]：第n次下落后上弹的高度。
        BigDecimal half = l_h[0].multiply(new BigDecimal(0.5));
        l_h[1] = l_h[1].add(l_h[0].multiply(new BigDecimal(1.5)));
        System.out.print(l_h[1]+",");
        l_h[0] = half;
        System.out.println(l_h[0]);
        if (n == count) {
            return l_h;
        }
        n++;
        return ss(n, count, l_h);
    }

    @Test
    public void testSS() {
        Arrays.stream(ss(1, 10, new BigDecimal[]{new BigDecimal(100), new BigDecimal(0)})).forEach(System.out::println);
    }
}
