package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/10/29 : 8:55.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    /**
     * 235. 二叉搜索树的最近公共祖先
     * */
    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t0 = new TreeNode(0);
        TreeNode t4 = new TreeNode(4, t3, t5);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t2 = new TreeNode(2, t0, t4);
        TreeNode t8 = new TreeNode(8, t7, t9);
        TreeNode t6 = new TreeNode(6, t2, t8);
        System.out.println(lowestCommonAncestor(t6, t2, t8).val);
        System.out.println(lowestCommonAncestor(t6, t2, t4).val);

        /*TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2,t1,null);
        System.out.println(lowestCommonAncestor(t2,t2,t1).val);*/
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            int a = p.val;
            int b = q.val;
            p = new TreeNode(b);
            q = new TreeNode(a);
        }
        if (root.val == p.val || root.val == q.val || (root.val > p.val && root.val < q.val)) {
            return root;
        } else if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
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
