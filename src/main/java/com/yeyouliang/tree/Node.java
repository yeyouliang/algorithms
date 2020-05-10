package com.yeyouliang.tree;

/**
 * Created by YEYOULIANG on 2020/4/29.
 */
public class Node<T> {
    private T value;
    private Node left;
    private Node right;

    public Node(T value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
