package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/10/19 : 9:01.
 */
public class CousinsInBinaryTree {
    /**
     * 993. 二叉树的堂兄弟节点
     */
    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2, t4, null);
        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(isCousins(t1, 4, 3));

        /*TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3,null,t5);
        TreeNode t2 = new TreeNode(2, null, t4);
        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(isCousins(t1, 5, 4));*/

        /*TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2, null, t4);
        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(isCousins(t1, 2, 3));*/
    }

    private static boolean isCousins(TreeNode root, int x, int y) {
        boolean falg = false;
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            List<TreeNode> tn = new ArrayList<>();
            int index = 100000001;
            int count = 0;
            for (int i = 0; i < treeNodes.size(); i++) {
                TreeNode treeNode = treeNodes.get(i);
                if (treeNode == null) {
                    tn.add(null);
                    tn.add(null);
                    count++;
                } else {
                    if (treeNode.val == x || treeNode.val == y) {
                        if (index > 10000000) {
                            index = i;
                        } else {
                            if (i - index > 1 || (index % 2 == 1 && i % 2 == 0)) {
                                falg = true;
                            }
                            tn.clear();
                            break;
                        }
                    }
                    tn.add(treeNode.left);
                    tn.add(treeNode.right);
                }
            }
            if (count == treeNodes.size()) {
                break;
            }
            treeNodes = tn;
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
