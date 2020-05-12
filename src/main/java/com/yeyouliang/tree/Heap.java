package com.yeyouliang.tree;

import com.yeyouliang.util.Tools;
import org.junit.Test;

/**
 * Created by YEYOULIANG on 2020/5/10.
 */
public class Heap {
    class Node {
        private Node left;
        private Node right;
        private Integer value;

        public Node(Node left, Node right, Integer value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    public static Integer[] in = {5, 1, 13, 3, 16, 7, 10, 14, 6};
    public static Node[] dd = new Node[in.length];

    public void buildTree(){
        int len = in.length;
        for (int i = len - 1; i >= 0; i--) {
            Node ld = null;
            Node rd = null;
            if (2 * i + 2 < len) {
                rd = dd[2 * i + 2];
            }
            if (2 * i + 1 < len) {
                ld = dd[2 * i + 1];
            }
            Node thisNode = new Node(ld, rd, in[i]);
            dd[i] = thisNode;
        }
    }

    @Test
    public void duiPai() {
        buildTree();
        for (int i = dd.length - 1; i >= 0; i--) {
            turnNode(dd[i]);
        }
        System.out.print("最小堆为：");
        for (int i = 0; i < dd.length; i++) {
            System.out.print(dd[i] + ",");
        }
        System.out.println();
        isMinHeap(dd[0]);
    }

    public void isMinHeap(Node node) {//根据堆的根节点判断此堆是否符合最小堆的定义。
        if (node.getLeft() == null && node.getRight() == null) {
            return;
        }
        if (node.getLeft() != null) {
            if (node.getLeft().getValue() > node.getValue()) {
                isMinHeap(node.getLeft());
            } else {
                System.out.println("fail");
            }
        }
        if (node.getRight() != null) {
            if (node.getRight().getValue() > node.getValue()) {
                isMinHeap(node.getRight());
            } else {
                System.out.println("fail");
            }
        }
    }

    public void turnNode(Node node) {//根据堆的定义对此堆进行比较和交换。
        Node left = node.getLeft();
        Node right = node.getRight();
        if (null != right) {
            if (right.getValue() < node.getValue()) {
                Integer rightValue = right.getValue();
                right.setValue(node.getValue());
                node.setValue(rightValue);
                turnNode(right);
            }
            if (left.getValue() < node.getValue()) {
                Integer leftValue = left.getValue();
                left.setValue(node.getValue());
                node.setValue(leftValue);
                turnNode(left);
            }
        } else if (null != left && left.getValue() < node.getValue()) {
            Integer leftValue = left.getValue();
            left.setValue(node.getValue());
            node.setValue(leftValue);
        }
    }
}
