package com.yeyouliang.leetcode;

import java.util.Stack;

/**
 * Created by YYL on 2021/10/29 : 10:00.
 */
public class ImplementQueueUsingStacks {
    /**
     * 232. 用栈实现队列
     * */
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        myQueue.push(3);
        System.out.println(myQueue.empty());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
        myQueue.push(4);
        System.out.println(myQueue.empty());
    }

    private static class MyQueue {

        private Stack<Integer> a;
        private Stack<Integer> b;

        public MyQueue() {
            a = new Stack<>();
            b = new Stack<>();
        }

        public void push(int x) {
            if (!b.isEmpty()) {
                while (!b.empty()) {
                    a.push(b.pop());
                }
            }
            a.push(x);
        }

        public int pop() {
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

        public int peek() {
            if (!a.empty() || !b.empty()) {
                if (b.empty()) {
                    while (!a.empty()) {
                        b.push(a.pop());
                    }
                }
                return b.peek();
            }
            return -1;
        }

        public boolean empty() {
            return a.empty() && b.empty();
        }
    }

}
