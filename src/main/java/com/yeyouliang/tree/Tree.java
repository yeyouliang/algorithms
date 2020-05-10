package com.yeyouliang.tree;

import org.junit.Test;

/**
 * Created by YEYOULIANG on 2020/4/29.
 */
public class Tree {

    @Test
    public void erCha() {
        Node n4=new Node(4,null,null);
        Node n5=new Node(5,null,null);
        Node n7=new Node(7,null,null);
        Node n2=new Node(2,n4,n5);
        Node n3=new Node(3,null,n7);
        Node n1=new Node(1,n2,n3);
        new Tree().preOrderRecur(n1);
    }

    class Node {//二叉树节点
        public int value;
        public Node left;
        public Node right;
        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public void preOrderRecur(Node head) {//前序遍历
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public void inOrderRecur(Node head) {//中序遍历
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    public void posOrderRecur(Node head) {//后序遍历
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }
}
