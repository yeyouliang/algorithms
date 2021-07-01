package com.yeyouliang.lanqiao;

import java.util.*;

/**
 * Created by YYL on 2021/7/1 : 20:42.
 */
public class AntCatchACold {
    /**
     * 蚂蚁感冒
     * 长100厘米的细长直杆子上有n只蚂蚁。它们的头有的朝左，有的朝右。
     * 每只蚂蚁都只能沿着杆子向前爬，速度是1厘米/秒。
     * 当两只蚂蚁碰面时，它们会同时掉头往相反的方向爬行。
     * 这些蚂蚁中，有1只蚂蚁感冒了。并且在和其它蚂蚁碰面时，会把感冒传染给碰到的蚂蚁。
     * 请你计算，当所有蚂蚁都爬离杆子时，有多少只蚂蚁患上了感冒。
     * 输入
     * 第一行输入一个整数n  (1  <   n  <   50),  表示蚂蚁的总数。
     * 接着的一行是n个用空格分开的整数  Xi  (-100  <   Xi  <   100),  Xi的绝对值，表示蚂蚁离开杆子左边端点的距离。正值表示头朝右，负值表示头朝左，数据中不会出现0值，也不会出现两只蚂蚁占用同一位置。
     * 其中，第一个数  据代表的蚂蚁感冒了。
     * 输出
     * 要求输出1个整数，表示最后感冒蚂蚁的数目。
     * 样例输入
     * 5
     * -10  8  -20  12  25
     * 样例输出
     * 3
     */
    public static void main(String[] args) {
        int[] ints = {-10, 8, -20, 12, 25};
        List<Ant> ants = new ArrayList<>();
        Ant hasCold = new Ant(Math.abs(ints[0]), ints[0] > 0 ? "R" : "L");
        hasCold.setCold(true);
        ants.add(hasCold);
        for (int i = 1; i < ints.length; i++) {
            ants.add(new Ant(Math.abs(ints[i]), ints[i] > 0 ? "R" : "L"));
        }
        //两种排序方式
        Collections.sort(ants);
        //ants.sort((o1, o2) -> Integer.valueOf(o1.getPosition()).compareTo(o2.getPosition()));
        //感冒蚂蚁的数目
        int count = 1;
        while (!ants.isEmpty()) {
            //最左边且方向为左的排除
            if (ants.get(0).getDirection().equals("L")) {
                ants.remove(0);
                continue;
            }
            //最右边且方向为右的排除
            if (ants.get(ants.size() - 1).getDirection().equals("R")) {
                ants.remove(ants.size() - 1);
                continue;
            }
            //保存蚂蚁的位置
            Map<Integer, Ant> map = new HashMap<>();
            for (Ant ant : ants) {
                ant.move();
                //如果到达相同位置
                if (map.containsKey(ant.getPosition())) {
                    ant.reversalDirection();
                    Ant mAnt = map.get(ant.getPosition());
                    //有且仅有一个感冒了
                    if ((ant.isCold() || mAnt.isCold()) && !(ant.isCold() && mAnt.isCold())) {
                        ant.setCold(true);
                        mAnt.setCold(true);
                        count += 1;
                    }
                    mAnt.reversalDirection();
                } else {
                    map.put(ant.getPosition(), ant);
                }
            }
        }
        System.out.println(count);
    }

    private static class Ant implements Comparable<Ant> {
        /**
         * 位置
         */
        private int position;
        /**
         * 是否感冒
         */
        private boolean isCold;
        /**
         * 方向
         */
        private String direction;

        public Ant(int position, String direction) {
            this.position = position;
            isCold = false;
            this.direction = direction;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public boolean isCold() {
            return isCold;
        }

        public void setCold(boolean cold) {
            isCold = cold;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        /**
         * 根据当前方向移动一步
         */
        public void move() {
            setPosition(getDirection().equals("R") ? getPosition() + 1 : getPosition() - 1);
        }

        /**
         * 根据当前方向反转
         */
        public void reversalDirection() {
            setDirection(getDirection().equals("R") ? "L" : "R");
        }

        @Override
        public String toString() {
            return "Ant{" +
                    "position=" + position +
                    ", isCold=" + isCold +
                    ", direction='" + direction + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Ant o) {
            return Integer.valueOf(this.getPosition()).compareTo(o.getPosition());
        }
    }
}
