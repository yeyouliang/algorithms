package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/10/30 : 16:29.
 */
public class TwoSumIvInputIsABst {
    /**
     * 653. 两数之和 IV - 输入 BST
     */
    public static void main(String[] args) {
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
