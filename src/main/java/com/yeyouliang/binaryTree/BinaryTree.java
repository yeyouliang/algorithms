package com.yeyouliang.binaryTree;

/**
 * Created by YYL on 2021/4/18 : 11:06.
 */
public class BinaryTree {
    public static void main(String[] args) {
        TreeNode n9 = new TreeNode(9, null, null);
        TreeNode n12 = new TreeNode(12, null, null);
        TreeNode n11 = new TreeNode(11, n9, n12);
        TreeNode n8 = new TreeNode(8, null, n11);
        TreeNode n15 = new TreeNode(15, null, null);
        TreeNode n13 = new TreeNode(13, n8, n15);
        TreeNode n2 = new TreeNode(2, null, null);
        TreeNode n1 = new TreeNode(1, null, n2);
        TreeNode n5 = new TreeNode(5, null, null);
        TreeNode n4 = new TreeNode(4, n1, n5);
        TreeNode n7 = new TreeNode(7, n4, n13);
        after(n7);
    }

    public static void middle(TreeNode treeNode) {
        TreeNode left = treeNode.getLeft();
        if (left != null) {
            middle(left);
        }
        System.out.println(treeNode.getValue());
        TreeNode right = treeNode.getRight();
        if (right != null) {
            middle(right);
        }
    }

    public static void before(TreeNode treeNode) {
        System.out.println(treeNode.getValue());
        TreeNode left = treeNode.getLeft();
        if (left != null) {
            before(left);
        }
        TreeNode right = treeNode.getRight();
        if (right != null) {
            before(right);
        }
    }

    public static void after(TreeNode treeNode) {
        TreeNode left = treeNode.getLeft();
        if (left != null) {
            after(left);
        }
        TreeNode right = treeNode.getRight();
        if (right != null) {
            after(right);
        }
        System.out.println(treeNode.getValue());
    }

    public static class TreeNode {
        private int value;
        private TreeNode left; // 左子树
        private TreeNode right; // 右子树

        public TreeNode(int value, TreeNode left, TreeNode right) {
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
    }
}
