package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/10/16 : 9:46.
 */
public class MinimumDistanceBetweenBstNodes {
    /**
     * 783. 二叉搜索树节点最小距离
     * */
    public static void main(String[] args) {
        /*TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2, t1, t3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t4 = new TreeNode(4, t2, t6);*/
        TreeNode t49 = new TreeNode(49);
        TreeNode t12 = new TreeNode(12);
        TreeNode t48 = new TreeNode(46, t12, t49);
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(6, t0, t48);
        System.out.println(minDiffInBST(t1));
    }

    private static int minDiffInBST(TreeNode root) {
        int length = Integer.MAX_VALUE;
        List<Integer> list = inorderTraversal(root);
        for (int i = 0; i < list.size() - 1; i++) {
            length = Math.min(list.get(i + 1) - list.get(i), length);
        }
        return length;
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        if (root != null) {
            b = inorderTraversal(root.left);
            c = inorderTraversal(root.right);
            a.add(root.val);
        }
        a.addAll(c);
        a.addAll(0, b);
        return a;
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
