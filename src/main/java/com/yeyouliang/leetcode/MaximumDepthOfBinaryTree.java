package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/9/14 : 20:26.
 */
public class MaximumDepthOfBinaryTree {
    /**
     * 104. 二叉树的最大深度
     * */
    public static void main(String[] args) {
        TreeNode t16 = new TreeNode(16);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9, t16, null);
        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t3 = new TreeNode(3, t9, t20);
        System.out.println(maxDepth(t3));
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int length = 1;
        int l = Integer.MIN_VALUE;
        int r = Integer.MIN_VALUE;
        if (root.left != null) {
            l = length + maxDepth(root.left);
        }
        if (root.right != null) {
            r = length + maxDepth(root.right);
        }
        return Math.max(length, Math.max(l, r));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
