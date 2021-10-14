package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/10/14 : 20:59.
 */
public class ConstructStringFromBinaryTree {
    /**
     * 606. 根据二叉树创建字符串
     * */
    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2, t4, null);
        TreeNode t3 = new TreeNode(3);
        TreeNode t1 = new TreeNode(1, t2, t3);

        /*TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2, null, t4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t1 = new TreeNode(1, t2, t3);*/
        System.out.println(tree2str(t1));
    }

    private static String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            sb.append(root.val);
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (right == null) {
                if (left != null) {
                    sb.append("(");
                    sb.append(tree2str(left));
                    sb.append(")");
                }
            } else {
                sb.append("(");
                sb.append(tree2str(left));
                sb.append(")");
                sb.append("(");
                sb.append(tree2str(right));
                sb.append(")");
            }
        }
        return sb.toString();
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
