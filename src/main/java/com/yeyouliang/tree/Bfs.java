package com.yeyouliang.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by YYL on 2021/11/21 : 19:59.
 */
public class Bfs {
    /**
     * 二叉树的广度优先遍历（BFS）
     */
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
        m1(t8);
    }

    private static void m1(TreeNode head) {
        if (head != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(head);
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                System.out.println(treeNode.val + ",");
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
    }
}
