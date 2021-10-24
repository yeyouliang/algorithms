package com.yeyouliang.jianzhi;

import java.util.Stack;

/**
 * Created by YYL on 2021/10/23 : 22:06.
 */
public class Offer9 {
    /**
     * 剑指 Offer 09. 用两个栈实现队列
     */
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());

        /*System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());*/
    }

    private static class CQueue {
        private Stack<Integer> a;
        private Stack<Integer> b;

        CQueue() {
            a = new Stack<>();
            b = new Stack<>();
        }

        void appendTail(int value) {
            if (!b.isEmpty()) {
                while (!b.empty()) {
                    a.push(b.pop());
                }
            }
            a.push(value);
        }

        int deleteHead() {
            if (!a.empty() || !b.empty()) {
                if (b.empty()) {
                    while (!a.empty()) {
                        b.push(a.pop());
                    }
                }
                return b.pop();
            }
            return -1;
        }
    }
}
