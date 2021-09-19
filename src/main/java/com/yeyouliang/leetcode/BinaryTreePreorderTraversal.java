package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by YYL on 2021/9/18 : 21:03.
 */
public class BinaryTreePreorderTraversal {
    /**
     * 144. 二叉树的前序遍历
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t13 = new TreeNode(13, null, null);
        TreeNode t16 = new TreeNode(16, null, null);
        TreeNode t21 = new TreeNode(21, null, null);
        TreeNode t30 = new TreeNode(30, null, null);
        TreeNode t2 = new TreeNode(2, t1, null);
        TreeNode t5 = new TreeNode(5, t4, t6);
        TreeNode t15 = new TreeNode(15, t13, t16);
        TreeNode t29 = new TreeNode(29, t21, t30);
        TreeNode t3 = new TreeNode(3, t2, t5);
        TreeNode t20 = new TreeNode(20, t15, t29);
        TreeNode t8 = new TreeNode(8, t3, t20);
        List<Integer> list = preorderTraversal(t8);
        System.out.println(list);
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        if (root != null) {
            b = preorderTraversal(root.left);
            c = preorderTraversal(root.right);
            a.add(root.val);
        }
        a.addAll(b);
        a.addAll(c);
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
    }
}
