package com.yeyouliang.tree;

import java.util.Stack;

/**
 * Created by YYL on 2021/2/23 : 21:29.
 */
public class BinaryTree {
    private static Stack<Node> deepStack = new Stack<>();

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n4 = new Node(4);
        Node n6 = new Node(6);
        Node n13 = new Node(13);
        Node n16 = new Node(16);
        Node n21 = new Node(21);
        Node n30 = new Node(30);
        Node n2 = new Node(2);
        Node n5 = new Node(5);
        Node n15 = new Node(15);
        Node n29 = new Node(29);
        Node n3 = new Node(3);
        Node n20 = new Node(20);
        Node n8 = new Node(8);
        n8.setLeft(n3);
        n8.setRight(n20);
        n3.setLeft(n2);
        n3.setRight(n5);
        n20.setLeft(n15);
        n20.setRight(n29);
        n2.setLeft(n1);
        n5.setLeft(n4);
        n5.setRight(n6);
        n15.setLeft(n13);
        n15.setRight(n16);
        n29.setLeft(n21);
        n29.setRight(n30);
        deep(n8);
    }

    public static void deep(Node node) {
        deepStack.push(node);
        if (node.getLeft() != null) {
            deep(node.getLeft());
        }
        if (node.getRight() != null) {
            deep(node.getRight());
        }
    }

    private static class Node {
        int anInt;
        Node left;
        Node right;

        public Node(int anInt) {
            this.anInt = anInt;
        }

        public Node(int anInt, Node left, Node right) {
            this.anInt = anInt;
            this.left = left;
            this.right = right;
        }

        public int getAnInt() {
            return anInt;
        }

        public void setAnInt(int anInt) {
            this.anInt = anInt;
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
}
