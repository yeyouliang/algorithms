package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YYL on 2021/1/20 : 21:40.
 */
public class PrintBinaryTree {
    public static void main(String[] args) {
        //List<String> qian = Stream.of("3", "9", "5", "20", "15", "7").collect(Collectors.toList());
        //List<String> zhong = Stream.of("5", "9", "3", "15", "20", "7").collect(Collectors.toList());
        //List<String> qian = Stream.of("A", "B", "D", "H", "E", "I", "C", "F", "J", "K", "G").collect(Collectors.toList());
        //List<String> zhong = Stream.of("D", "H", "B", "E", "I", "A", "J", "F", "K", "C", "G").collect(Collectors.toList());
        List<String> qian = Stream.of("G", "D", "A", "F", "E", "M", "H", "Z").collect(Collectors.toList());
        List<String> zhong = Stream.of("A", "D", "E", "F", "G", "H", "M", "Z").collect(Collectors.toList());
        Node top = new Node(qian.get(0));
        qq(top, qian, zhong);
        System.out.println(top);
    }

    public static void qq(Node top, List<String> qian, List<String> zhong) {
        String first = top.getContent();
        String left;
        String right;
        int index = zhong.indexOf(first);
        if (qian.size() > 1) {
            if (index != 0) {
                left = qian.get(1);
                top.setLeft(new Node(left));
            }
            if (qian.size() > index + 1) {
                right = qian.get(index + 1);
                top.setRight(new Node(right));
            }
        }
        if (top.getLeft() != null) {
            qq(top.getLeft(), qian.subList(1, index + 1), zhong.subList(0, index));
        }
        if (top.getRight() != null) {
            List<String> pQian = new ArrayList<>(qian.subList(index + 2, qian.size()));
            pQian.add(0, qian.get(index + 1));
            qq(top.getRight(), pQian, zhong.subList(index + 1, zhong.size()));
        }
    }

    static class Node {
        String content;
        Node left;
        Node right;

        public Node(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        @Override
        public String toString() {
            return "Node{" +
                    "content='" + content + '\'' +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
