package com.yeyouliang.lanqiao;

import java.util.*;

/**
 * Created by YYL on 2021/7/25 : 14:47.
 */
public class LookForRing {
    /**
     * 发现环
     * 小明的实验室有N台电脑，编号1~N。原本这N台电脑之间有N-1条数据链接相连，恰好构成一个树形网络。在树形网络上，任意两台电脑之间有唯一的路径相连。
     * 不过在最近一次维护网络时，管理员误操作使得某两台电脑之间增加了一条数据链接，于是网络中出现了环路。
     * 环路上的电脑由于两两之间不再是只有一条路径，使得这些电脑上的数据传输出现了BUG。
     * 为了恢复正常传输。小明需要找到所有在环路上的电脑，你能帮助他吗？
     * 输入
     * 第一行包含一个整数N。
     * 以下N行每行两个整数a和b，表示a和b之间有一条数据链接相连。
     * 对于30%的数据，1 <= N <= 1000
     * 对于100%的数据, 1 <= N <= 100000， 1 <= a, b <= N
     * 输入保证合法。
     * 输出
     * 按从小到大的顺序输出在环路上的电脑的编号，中间由一个空格分隔。
     * 样例输入：
     * 5
     * 1 2
     * 3 1
     * 2 4
     * 2 5
     * 5 3
     * 样例输出：
     * 1 2 3 5
     * */
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] ints = new int[num][2];
        for (int i = 0; i < num; i++) {
            int[] in = new int[2];
            for (int j = 0; j < 2; j++) {
                int nextInt = scanner.nextInt();
                in[j] = nextInt;
            }
            ints[i] = in;
        }*/
        int[][] ints = {{1, 2}, {3, 1}, {2, 4}, {2, 5}, {5, 3}};
        //key表示某个电脑，values是能够连接到的电脑集合
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] anInt : ints) {
            for (int i = 0; i < anInt.length; i++) {
                int value = i == 0 ? anInt[1] : anInt[0];
                if (map.containsKey(anInt[i])) {
                    List<Integer> list = map.get(anInt[i]);
                    list.add(value);
                    map.put(anInt[i], list);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(value);
                    map.put(anInt[i], list);
                }
            }
        }
        List<Integer> integers = new ArrayList<>(map.keySet());
        Collections.sort(integers);
        //取出所有key，从小到大遍历，检查是否有环
        for (Integer integer : integers) {
            if (lfr(map, integer, new ArrayList<>())) {
                break;
            }
        }
    }

    private static boolean lfr(Map<Integer, List<Integer>> map, Integer index, List<Integer> distances) {
        distances.add(index);
        List<Integer> list = map.get(index);
        boolean falg = false;
        for (Integer integer : list) {
            if (distances.contains(integer)) {
                if (distances.indexOf(integer) == 0 && distances.size() >= 3) {
                    Collections.sort(distances);
                    System.out.println(distances);
                    falg = true;
                    break;
                }
            } else {
                List<Integer> dis = new ArrayList<>(distances);
                falg = falg || lfr(map, integer, dis);
            }
        }
        return falg;
    }
}
