package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/10/18 : 11:42.
 */
public class UnivaluedBinaryTree {
    /**
     * 965. 单值二叉树
     * */
    public static void main(String[] args) {
        TreeNode f = new TreeNode(1);
        TreeNode e = new TreeNode(1);
        TreeNode d = new TreeNode(1);
        TreeNode c = new TreeNode(1, null, f);
        TreeNode b = new TreeNode(1, d, e);
        TreeNode a = new TreeNode(1, b, c);
        System.out.println(isUnivalTree(a));
    }

    private static boolean isUnivalTree(TreeNode root) {
        boolean falg = false;
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left == null && right == null) {
                falg = true;
            } else {
                if (left != null) {
                    falg = root.val == left.val && isUnivalTree(left);
                } else {
                    falg = true;
                }
                if (right != null && falg) {
                    falg = root.val == right.val && isUnivalTree(right);
                }
            }
        }
        return falg;
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
