package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/10/13 : 22:01.
 */
public class MergeTwoBinaryTrees {
    /**
     * 617. 合并二叉树
     * */
    public static void main(String[] args) {
        TreeNode t15 = new TreeNode(5);
        TreeNode t13 = new TreeNode(3, t15, null);
        TreeNode t12 = new TreeNode(2);
        TreeNode t11 = new TreeNode(1, t13, t12);
        TreeNode t24 = new TreeNode(4);
        TreeNode t27 = new TreeNode(7);
        TreeNode t21 = new TreeNode(1, null, t24);
        TreeNode t23 = new TreeNode(3, null, t27);
        TreeNode t22 = new TreeNode(2, t21, t23);
        TreeNode treeNode = mergeTrees(t11, t22);
        System.out.println(treeNode.val);
    }

    private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode treeNode = null;
        if (root1 != null || root2 != null) {
            int count = 0;
            count += root1 == null ? 0 : root1.val;
            count += root2 == null ? 0 : root2.val;
            treeNode = new TreeNode(count, mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left),
                    mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right));
        }
        return treeNode;
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
