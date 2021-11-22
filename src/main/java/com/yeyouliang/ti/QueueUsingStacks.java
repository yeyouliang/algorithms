package com.yeyouliang.ti;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by YYL on 2021/11/13 : 13:56.
 */
public class QueueUsingStacks {
    /**
     * 使用队列表示栈
     * */
    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        System.out.println(myStack.empty());
        myStack.push("a");
        System.out.println(myStack.empty());
        myStack.push("b");
        System.out.println(myStack.empty());
        System.out.println(myStack.peek());
        System.out.println(myStack.empty());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.empty());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    private static class MyStack<E> {
        Queue<E> a;
        Queue<E> b;

        public MyStack() {
            a = new ArrayDeque<>();
            b = new ArrayDeque<>();
        }

        boolean empty() {
            return a.isEmpty() && b.isEmpty();
        }

        E peek() {
            while (a.size() > 1) {
                b.add(a.poll());
            }
            E c = a.peek();
            b.add(c);
            while (!b.isEmpty()) {
                a.add(b.poll());
            }
            return c;
        }

        E pop() {
            while (a.size() > 1) {
                b.add(a.poll());
            }
            E c = a.poll();
            while (!b.isEmpty()) {
                a.add(b.poll());
            }
            return c;
        }

        void push(E e) {
            a.add(e);
        }
    }
}
