package com.yeyouliang.lanqiao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/7/18 : 14:22.
 */
public class YueBinFangZhen {
    /**
     * 阅兵方阵
     * x国要参加同盟阅兵活动。
     * 主办方要求每个加盟国派出的士兵恰好能组成 2 个方阵。
     * x国发现弱小的 y国派出了130人的队伍，他们的士兵在行进中可以变换2种队形：
     * 130 = 81 + 49 = 9^2 + 7^2
     * 130 = 121 + 9 = 11^2 + 3^2
     * x国君很受刺激，觉得x国面积是y国的6倍，理应变出更多队形。
     * 于是他发号施令：
     * 我们要派出一支队伍，在行进中要变出 12 种队形！！！
     * 手下人可惨了，要忙着计算至少多少人才能组成 12 种不同的双方阵。
     * 请你利用计算机的优势来计算一下，至少需要多少士兵。
     * 注意，需要提交的是一个整数，表示至少需要士兵数目，不要填写任何多余的内容。
     */
    public static void main(String[] args) {
        int start = 1;
        Map<Integer, List<String>> map = new HashMap<>();
        while (true) {
            int squr = start * start;
            if (!map.isEmpty()) {
                for (int i = start - 1; i > 0; i--) {
                    int count = squr + i * i;
                    if (map.containsKey(count)) {
                        List<String> list = map.get(count);
                        list.add("" + start + "-" + i);
                        int size = list.size();
                        if (size == 12) {
                            System.out.println(count + "," + list);
                            return;
                        }
                    } else {
                        map.put(count, Stream.of("" + start + "-" + i).collect(Collectors.toList()));
                    }
                }
            } else {
                map.put(squr, Stream.of("" + start).collect(Collectors.toList()));
            }
            start++;
        }
    }
}
