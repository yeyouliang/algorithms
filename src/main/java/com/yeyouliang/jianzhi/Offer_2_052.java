package com.yeyouliang.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/10/30 : 10:52.
 */
public class Offer_2_052 {
    /**
     * 剑指 Offer II 052. 展平二叉搜索树
     * */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t2 = new TreeNode(2, t1, null);
        TreeNode t4 = new TreeNode(4);
        TreeNode t8 = new TreeNode(8, t7, t9);
        TreeNode t3 = new TreeNode(3, t2, t4);
        TreeNode t6 = new TreeNode(6, null, t8);
        TreeNode t5 = new TreeNode(5, t3, t6);
        TreeNode treeNode = increasingBST(t5);
        System.out.println(treeNode.val);
    }

    private static TreeNode increasingBST(TreeNode root) {
        List<TreeNode> a = new ArrayList<>();
        List<TreeNode> b = new ArrayList<>();
        a.add(root);
        b.add(root);
        while (!b.isEmpty()) {
            List<TreeNode> c = new ArrayList<>();
            for (TreeNode treeNode : b) {
                if (treeNode.left != null) {
                    a.add(treeNode.left);
                    c.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    a.add(treeNode.right);
                    c.add(treeNode.right);
                }
            }
            b = c;
        }
        a.sort((o1, o2) -> Integer.valueOf(o1.val).compareTo(o2.val));
        for (int i = 0; i < a.size() - 1; i++) {
            TreeNode e = a.get(i);
            e.left = null;
            TreeNode f = a.get(i + 1);
            f.left = null;
            e.right = f;
        }
        return a.get(0);
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
