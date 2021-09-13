package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/9/13 : 21:50.
 */
public class SameTree {
    /**
     * 100. 相同的树
     */
    public static void main(String[] args) {
        /*TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p1 = new TreeNode(1, p2, p3);
        TreeNode q2 = new TreeNode(2);
        TreeNode q3 = new TreeNode(3);
        TreeNode q1 = new TreeNode(1, q2, q3);*/

        /*TreeNode p2 = new TreeNode(2);
        TreeNode p1 = new TreeNode(1, p2, null);
        TreeNode q2 = new TreeNode(2);
        TreeNode q1 = new TreeNode(1, null, q2);*/

        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(1);
        TreeNode p1 = new TreeNode(1, p2, p3);
        TreeNode q2 = new TreeNode(1);
        TreeNode q3 = new TreeNode(2);
        TreeNode q1 = new TreeNode(1, q2, q3);
        System.out.println(isSameTree(p1, q1));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean falg = false;
        if (p == null && q == null) {
            falg = true;
        } else if (p != null && q != null && p.val == q.val) {
            falg = isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
    }
}
