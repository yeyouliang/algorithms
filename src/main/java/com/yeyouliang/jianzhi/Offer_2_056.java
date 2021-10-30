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
        System.out.println(findTarget(t1, 2));
    }

    private static boolean findTarget(TreeNode root, int k) {
        return find(root, k, new ArrayList<>());
    }

    private static boolean find(TreeNode root, int k, List<Integer> d) {
        if (d.contains(root.val)) {
            return true;
        } else {
            d.add(k - root.val);
            boolean a = false;
            if (root.left != null) {
                a = find(root.left, k, d);
            }
            boolean b = false;
            if (root.right != null) {
                b = find(root.right, k, d);
            }
            return a || b;
        }
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
