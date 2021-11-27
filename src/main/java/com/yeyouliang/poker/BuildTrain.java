package com.yeyouliang.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/11/26 : 16:46.
 */
public class BuildTrain {

    private final Object object = new Object();
    private List<String> pai = new ArrayList<>();
    private boolean falg = false;

    public static void main(String[] args) throws InterruptedException {
        BuildTrain bhc = new BuildTrain();
        Player tom = new Player(bhc, "TOM");
        Player jenny = new Player(bhc, "JERRY");
        tom.start();
        Thread.sleep(750);
        jenny.start();

    }

    private static class Player extends Thread {

        BuildTrain bhc;
        List<String> list;

        Player(BuildTrain BuildTrain, String name) {
            this.bhc = BuildTrain;
            this.setName(name);
            this.list = init();
            System.out.println(name + ":" + this.list);
        }

        List<String> init() {
            //List<String> stringList = Stream.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K").collect(Collectors.toList());
            List<String> stringList = Stream.of("2", "3", "4", "5", "6").collect(Collectors.toList());
            return xi(stringList);
        }

        List<String> shou(List<String> shou) {
            return xi(shou);
        }

        List<String> xi(List<String> ru) {
            List<String> chu = new ArrayList<>();
            Random random = new Random();
            while (true) {
                int a = ru.size();
                if (a == 1) {
                    chu.add(ru.get(0));
                    break;
                }
                int b = random.nextInt(a);
                chu.add(ru.get(b));
                ru.remove(b);
            }
            return chu;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (bhc.object) {
                    if (bhc.falg) {
                        System.out.println(this.getName() + " 赢");
                        bhc.object.notify();
                        break;
                    } else {
                        System.out.println(this.getName() + "开始出牌，自己手上的牌：" + list + "，桌面上的牌：" + bhc.pai);
                        int d = -1;
                        while (true) {
                            if (list.isEmpty()) {
                                System.out.println(this.getName() + " 输");
                                bhc.falg = true;
                                break;
                            } else {
                                List<String> p = new ArrayList<>(bhc.pai);
                                String first = list.get(0);
                                System.out.println(this.getName() + " 出 : " + first);
                                //list = list.subList(1, list.size());
                                List<String> ls = new ArrayList<>(list.subList(1, list.size()));
                                boolean b = true;
                                if (p.isEmpty()) {
                                    p.add(first);
                                    d = -1;
                                } else {
                                    int index = p.indexOf(first);
                                    if (index != -1) {
                                        List<String> shou = new ArrayList<>(p.subList(index, p.size()));
                                        List<String> c = new ArrayList<>(p.subList(0, index));
                                        shou.add(first);
                                        shou = shou(shou);
                                        System.out.println(this.getName() + " 收 : " + shou);
                                        ls.addAll(shou);
                                        System.out.println(this.getName() + " 当前 : " + ls);
                                        first = ls.get(0);
                                        if (c.contains(first)) {
                                            b = false;
                                        } else {
                                            d = 1;
                                        }
                                        p = new ArrayList<>(c);
                                    } else {
                                        p.add(first);
                                        d = -1;
                                    }
                                }
                                list = ls;
                                bhc.pai = p;
                                if (b) {
                                    if (d == -1) {
                                        break;
                                    }
                                }
                            }
                        }
                        System.out.println(this.getName() + "结束出牌，自己手上的牌：" + list + "，桌面上的牌：" + bhc.pai);
                        System.out.println("------------------------------------------------------------------------------------------------");
                        bhc.object.notify();
                        if (bhc.falg) {
                            break;
                        } else {
                            try {
                                Thread.sleep(1500);
                                bhc.object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

}
