package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/9/23 : 21:21.
 */
public class MinimumDepthOfBinaryTree {
    /**
     * 111. 二叉树的最小深度
     * */
    public static void main(String[] args) {
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t3 = new TreeNode(3, t9, t20);
        System.out.println(minDepth(t3));
    }

    private static int minDepth(TreeNode root) {
        int length = 0;
        if (root != null) {
            length = 1;
            int l = Integer.MAX_VALUE;
            int r = Integer.MAX_VALUE;
            if (root.left != null || root.right != null) {
                if (root.left != null) {
                    l = length + minDepth(root.left);
                }
                if (root.right != null) {
                    r = length + minDepth(root.right);
                }
                System.out.println(root.val + "," + (root.left == null ? "null" : root.left.val) + "," + (root.right == null ? "null" : root.right.val) + "," + l + "," + r);
                length = Math.min(l, r);
            }
        }
        return length;
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
