package com.yeyouliang.tree;

/**
 * Created by YYL on 2021/11/17 : 22:18.
 */
public class HowManyNodesInK {
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
        System.out.println(howManyNodesInK(t8, 3));
    }

    /**
     * 求二叉树中第k层节点的个数
     */
    private static int howManyNodesInK(TreeNode treeNode, int k) {
        if (treeNode != null) {
            return (k == 1 ? 1 : 0) + howManyNodesInK(treeNode.left, k - 1) + howManyNodesInK(treeNode.right, k - 1);
        }
        return 0;
    }
}
