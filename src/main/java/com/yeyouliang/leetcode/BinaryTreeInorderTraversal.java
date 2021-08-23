package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by YYL on 2021/3/2 : 23:34.
 */
public class BinaryTreeInorderTraversal {

    /**
     * 94. 二叉树的中序遍历
     * */
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
        List<Integer> list = inorderTraversal(t8);
        System.out.println(list);
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<TreeNode> a = new ArrayList<>();
        List<TreeNode> b = new ArrayList<>();
        if (root != null) {
            b.add(root);
            while (true) {
                int size = b.size();
                for (TreeNode treeNode : b) {
                    if (!a.contains(treeNode)) {
                        a.add(treeNode);
                        int index = b.indexOf(treeNode);
                        List<TreeNode> c = new ArrayList<>(b);
                        if (treeNode.right != null) {
                            c.add(index + 1, treeNode.right);
                        }
                        if (treeNode.left != null) {
                            c.add(index, treeNode.left);
                        }
                        if (b.size() != c.size()) {
                            b = c;
                            break;
                        }
                    }
                }
                if (size == b.size()) {
                    break;
                }
            }
        }
        return b.stream().map(treeNode -> (treeNode.val)).collect(Collectors.toList());
    }

    static class TreeNode {
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
