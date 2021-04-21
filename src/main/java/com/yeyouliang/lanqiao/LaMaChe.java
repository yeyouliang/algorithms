package com.yeyouliang.lanqiao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/4/21 : 20:41.
 */
public class LaMaChe {

    public static List<String> jia = Stream.of("K", "8", "X", "K", "A", "2", "A", "9", "5", "A").collect(Collectors.toList());
    public static List<String> yi = Stream.of("2", "7", "K", "5", "J", "5", "Q", "6", "K", "4").collect(Collectors.toList());
    public static List<String> table = new ArrayList<>();

    /**
     * https://blog.csdn.net/weixin_44107920/article/details/104288358
     * 拉马车
     * 有一种叫做“拉马车”的游戏，规则很简单，却很吸引小朋友。
     * 其规则简述如下：
     * 假设参加游戏的小朋友是A和B，游戏开始的时候，他们得到的随机的纸牌序列如下：
     * A方：[K,8,X,K,A,2,A,9,5,A]
     * B方：[2,3,K,5,J,5,Q,6,K,4]
     * 其中的X表示“10”，我们忽略了纸牌的花色。
     * 从A方开始，A、B双方轮流出牌。
     * 当轮到某一方出牌时，他从自己的纸牌序列的头部拿走一张，放到桌上，并且压在最上面的一张纸牌上（如果有的话）。
     * 此例中，游戏过程:
     * A出K，B出2，A出8，B出7，A出X，此时桌上的序列为：
     * K，2，8，7，X
     * 当轮到B出牌时，他的牌K与桌上的纸牌序列中的K相同，则把包括K在内的以及两个K之间的纸牌都赢回来，放入自己牌的队尾。
     * 注意：为了操作方便，放入牌的顺序是与桌上的顺序相反的。
     * 此时，A、B双方的手里牌为：
     * A方：[K，A，2，A，9，5，A]
     * B方：[5,J,5,Q,6,K,4,K,X,7,8,2,K]
     * */
    public static void main(String[] args) {
        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            if (jia.isEmpty()) {
                System.out.println(yi);
                break;
            }
            if (yi.isEmpty()) {
                System.out.println(jia);
                break;
            }
            if (i % 2 == 0) {
                lmc(table, jia);
            } else {
                lmc(table, yi);
            }
        }
    }

    public static void lmc(List<String> table, List<String> player) {
        if (player.isEmpty()) {
            return;
        }
        String p = player.get(0);
        player.remove(0);
        if (table.contains(p)) {
            player.add(p);
            int index = table.indexOf(p);
            int length = table.size();
            for (int i = length - 1; i >= index; i--) {
                player.add(table.get(i));
                table.remove(i);
            }
            lmc(table, player);
        } else {
            table.add(p);
        }
    }
}
