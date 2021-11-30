package com.yeyouliang.print;

/**
 * Created by YYL on 2021/11/30 : 21:54.
 */
public class SellTicket {

    private static int no = 1;

    public static void main(String[] args) {
        Conductor danny = new Conductor("丹尼");
        Conductor candy = new Conductor("卡迪");
        Conductor suzy = new Conductor("苏西");
        Conductor molly = new Conductor("茉莉");
        danny.start();
        candy.start();
        suzy.start();
        molly.start();
    }

    private synchronized static int sell() {
        if (no > 100) {
            return -1;
        } else {
            return no++;
        }
    }

    private static class Conductor extends Thread {

        Conductor(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                int ticketNo = sell();
                if (ticketNo == -1) {
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + "：我卖出第" + ticketNo + "张票");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
