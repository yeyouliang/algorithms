package com.yeyouliang.tree;

/**
 * Created by YYL on 2021/11/17 : 22:16.
 */
public class IsBst {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t13 = new TreeNode(13);
        TreeNode t16 = new TreeNode(16);
        TreeNode t21 = new TreeNode(21);
        TreeNode t30 = new TreeNode(30);
        TreeNode t2 = new TreeNode(2, t1, null);
        TreeNode t5 = new TreeNode(5, t4, t6);
        TreeNode t15 = new TreeNode(15, t13, t16);
        TreeNode t29 = new TreeNode(29, t21, t30);
        TreeNode t3 = new TreeNode(3, t2, t5);
        TreeNode t20 = new TreeNode(20, t15, t29);
        TreeNode t8 = new TreeNode(8, t3, t20);
        System.out.println(isBst(t8));
    }

    /**
     * 判断二叉树是否是合法的二叉查找树(BST)
     */
    private static boolean isBst(TreeNode treeNode) {
        if (treeNode != null) {
            TreeNode left = treeNode.left;
            TreeNode right = treeNode.right;
            if (left == null && right == null) {
                return true;
            } else {
                boolean falg = false;
                if (left != null) {
                    falg = left.val < treeNode.val;
                    if (falg) {
                        falg = isBst(left);
                    }
                }
                if (falg) {
                    if (right != null) {
                        falg = left.val < treeNode.val;
                        if (falg) {
                            falg = isBst(right);
                        }
                    }
                }
                return falg;
            }
        }
        return true;
    }
}
