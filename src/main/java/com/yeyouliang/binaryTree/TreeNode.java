package com.yeyouliang.binaryTree;

/**
 * Created by YYL on 2021/4/24 : 11:04.
 */
public class TreeNode {
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
