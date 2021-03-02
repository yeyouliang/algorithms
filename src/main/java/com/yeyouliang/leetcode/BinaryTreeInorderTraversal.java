package com.yeyouliang.leetcode;

import java.util.List;
import java.util.Stack;

/**
 * Created by YYL on 2021/3/2 : 23:34.
 */
public class BinaryTreeInorderTraversal {
    
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2, t1, null);
        TreeNode t4 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5, t4, t6);
        TreeNode t13 = new TreeNode(13);
        TreeNode t16 = new TreeNode(16);
        TreeNode t15 = new TreeNode(15, t13, t16);
        TreeNode t21 = new TreeNode(21);
        TreeNode t30 = new TreeNode(30);
        TreeNode t29 = new TreeNode(29, t21, t30);
        TreeNode t3 = new TreeNode(3, t2, t5);
        TreeNode t20 = new TreeNode(20, t15, t29);
        TreeNode t8 = new TreeNode(8, t3, t20);
        inorderTraversal(t8);
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root.left != null) {
            stack.push(root.left);
        }
        stack.push(root);
        if (root.right != null) {
            stack.push(root.right);
        }
        while (!stack.empty()) {
            TreeNode peek = stack.peek();
            TreeNode pl = peek.left;
            TreeNode pr = peek.right;
            if (pr == null) {
                System.out.println(stack.pop().val);
                if (!stack.empty()) {
                    System.out.println(stack.pop().val);
                }
                if (pl!=null){
                    stack.push(pl);
                }
            } else {
                TreeNode treeNode = stack.pop();
                if (pl != null) {
                    stack.push(pl);
                }
                stack.push(treeNode);
                stack.push(pr);
            }
        }
        return null;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
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
