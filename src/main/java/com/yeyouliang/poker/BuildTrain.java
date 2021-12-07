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
    private List<String> carriages = new ArrayList<>();
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
            this.list = initPai();
            System.out.println(name + ":" + this.list);
        }

        List<String> initPai() {
            //List<String> stringList = Stream.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K").collect(Collectors.toList());
            List<String> stringList = Stream.of("2", "3", "4", "5", "6").collect(Collectors.toList());
            return xiPai(stringList);
        }

        List<String> shouPai(List<String> shou) {
            return xiPai(shou);
        }

        List<String> xiPai(List<String> ru) {
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
                        System.out.println(this.getName() + "：我赢了");
                        bhc.object.notify();
                        break;
                    } else {
                        if (list.isEmpty()) {
                            System.out.println(this.getName() + "：我输了");
                            bhc.falg = true;
                            bhc.object.notify();
                            break;
                        }
                        System.out.println(this.getName() + " 开始出牌，自己手上的牌：" + list + "，桌面上的牌：" + bhc.carriages);
                        while (true) {
                            List<String> newPai = new ArrayList<>(bhc.carriages);
                            String first = list.get(0);
                            System.out.println(this.getName() + " 出 : " + first);
                            List<String> newList = new ArrayList<>(list.subList(1, list.size()));
                            boolean b = true;
                            int index = newPai.indexOf(first);
                            if (index != -1) {
                                List<String> s = new ArrayList<>(newPai.subList(index, newPai.size()));
                                List<String> c = new ArrayList<>(newPai.subList(0, index));
                                s.add(first);
                                s = shouPai(s);
                                System.out.println(this.getName() + " 收 : " + s);
                                newList.addAll(s);
                                System.out.println(this.getName() + " 当前 : " + newList);
                                b = false;
                                newPai = new ArrayList<>(c);
                            } else {
                                newPai.add(first);
                            }
                            list = newList;
                            bhc.carriages = newPai;
                            if (b) {
                                break;
                            }
                        }
                        System.out.println(this.getName() + " 结束出牌，自己手上的牌：" + list + "，桌面上的牌：" + bhc.carriages);
                        System.out.println("------------------------------------------------------------------------------------------------");
                        bhc.object.notify();
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
