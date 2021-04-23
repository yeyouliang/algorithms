package com.yeyouliang.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/4/23 : 21:14.
 */
public class BinaryTrees {
    public static List<TreeNode> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t8 = new TreeNode(8, null, null);
        TreeNode t5 = new TreeNode(5, t7, t8);
        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t3 = new TreeNode(3, t5, t6);
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t2 = new TreeNode(2, null, null);
        TreeNode t1 = new TreeNode(1, t4, t2);
        TreeNode t0 = new TreeNode(0, t3, t1);
        list.add(t0);
        //before();
        //middle();
        after();
    }

    public static void before() {
        while (true) {
            int length = list.size();
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                TreeNode treeNode = list.get(i);
                if (!treeNode.has) {
                    treeNode.setHas(true);
                    TreeNode left = treeNode.getLeft();
                    TreeNode right = treeNode.getRight();
                    if (left != null || right != null) {
                        List<TreeNode> nodeList = new ArrayList<>(list);
                        int index = i;
                        if (left != null) {
                            index += 1;
                            nodeList.add(index, left);
                        }
                        if (right != null) {
                            index += 1;
                            nodeList.add(index, right);
                        }
                        list = nodeList;
                        break;
                    }
                }
                count++;
            }
            list.forEach(treeNode -> System.out.print(treeNode.getValue() + ","));
            System.out.println();
            if (length == count) {
                break;
            }
        }
        for (TreeNode treeNode : list) {
            System.out.print(treeNode.getValue() + ",");
        }
        System.out.println();
    }

    public static void middle() {
        while (true) {
            int length = list.size();
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                TreeNode treeNode = list.get(i);
                if (!treeNode.has) {
                    treeNode.setHas(true);
                    TreeNode left = treeNode.getLeft();
                    TreeNode right = treeNode.getRight();
                    if (left != null || right != null) {
                        List<TreeNode> nodeList = new ArrayList<>(list);
                        int index = i;
                        if (left != null) {
                            index += 1;
                            nodeList.add(i, left);//改index为i
                        }
                        if (right != null) {
                            index += 1;
                            nodeList.add(index, right);
                        }
                        list = nodeList;
                        break;
                    }
                }
                count++;
            }
            list.forEach(treeNode -> System.out.print(treeNode.getValue() + ","));
            System.out.println();
            if (length == count) {
                break;
            }
        }
        for (TreeNode treeNode : list) {
            System.out.print(treeNode.getValue() + ",");
        }
        System.out.println();
    }

    public static void after() {
        while (true) {
            int length = list.size();
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                TreeNode treeNode = list.get(i);
                if (!treeNode.has) {
                    treeNode.setHas(true);
                    TreeNode left = treeNode.getLeft();
                    TreeNode right = treeNode.getRight();
                    if (left != null || right != null) {
                        List<TreeNode> nodeList = new ArrayList<>(list);
                        int index = i;
                        if (left != null) {
                            index += 1;
                            nodeList.add(i, left);
                        }
                        if (right != null) {
                            nodeList.add(index, right);
                        }
                        list = nodeList;
                        break;
                    }
                }
                count++;
            }
            list.forEach(treeNode -> System.out.print(treeNode.getValue() + ","));
            System.out.println();
            if (length == count) {
                break;
            }
        }
        for (TreeNode treeNode : list) {
            System.out.print(treeNode.getValue() + ",");
        }
        System.out.println();
    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        boolean has;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.has = false;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return this.getValue() + "";
        }

        public boolean isHas() {
            return has;
        }

        public void setHas(boolean has) {
            this.has = has;
        }
    }
}
