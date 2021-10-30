package com.yeyouliang.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/10/30 : 12:21.
 */
public class Offer_2_056 {
    /**
     * 剑指 Offer II 056. 二叉搜索树中两个节点之和
     */
    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t11 = new TreeNode(11);
        TreeNode t6 = new TreeNode(6, t5, t7);
        TreeNode t10 = new TreeNode(10, t9, t11);
        TreeNode t8 = new TreeNode(8, t6, t10);
        System.out.println(findTarget(t8, 10));
        System.out.println(findTarget(t8, 11));
        System.out.println(findTarget(t8, 12));
        System.out.println(findTarget(t8, 13));
        System.out.println(findTarget(t8, 14));
        System.out.println(findTarget(t8, 15));
        System.out.println(findTarget(t8, 16));
        System.out.println(findTarget(t8, 17));
        System.out.println(findTarget(t8, 18));
        System.out.println(findTarget(t8, 19));
        System.out.println(findTarget(t8, 20));
        System.out.println(findTarget(t8, 21));
        System.out.println(findTarget(t8, 22));
        TreeNode t1 = new TreeNode(1);
        System.out.println(findTarget(t1,2));
    }

    private static boolean findTarget(TreeNode root, int k) {
        List<TreeNode> a = new ArrayList<>();
        List<TreeNode> b = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        if (root != null) {
            b.add(root);
            while (true) {
                int size = b.size();
                for (TreeNode treeNode : b) {
                    if (!a.contains(treeNode)) {
                        if (d.contains(treeNode.val)) {
                            return true;
                        }else {
                            d.add(k - treeNode.val);
                        }
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
        return false;
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
