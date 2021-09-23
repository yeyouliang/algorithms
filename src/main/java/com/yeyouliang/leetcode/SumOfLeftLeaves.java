package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/9/23 : 20:06.
 */
public class SumOfLeftLeaves {
    /**
     * 404. 左叶子之和
     * */
    public static void main(String[] args) {
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9, null, null);
        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t3 = new TreeNode(3, t9, t20);
        System.out.println(sumOfLeftLeaves(t3));
    }

    private static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root != null) {
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    sum += root.left.val;
                }
                sum += sumOfLeftLeaves(root.left);
            }
            if (root.right != null) {
                sum += sumOfLeftLeaves(root.right);
            }
        }
        return sum;
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
