package com.yeyouliang.jianzhi;

import java.util.Stack;

/**
 * Created by YYL on 2021/10/23 : 22:06.
 */
public class Offer9 {
    /**
     * 剑指 Offer 09. 用两个栈实现队列
     * */
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        /*cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());*/

        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    private static class CQueue {
        private Stack<Integer> a;

        public CQueue() {
            a = new Stack<>();
        }

        public void appendTail(int value) {
            a.push(value);
        }

        public int deleteHead() {
            if (!a.empty()) {
                if (a.size() == 1) {
                    return a.pop();
                } else {
                    Stack<Integer> b = new Stack<>();
                    while (!a.empty()) {
                        b.push(a.pop());
                    }
                    int c = b.pop();
                    while (!b.empty()) {
                        a.push(b.pop());
                    }
                    return c;
                }
            }
            return -1;
        }
    }
}
