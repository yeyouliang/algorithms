package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/10/15 : 22:53.
 */
public class AverageOfLevelsInBinaryTree {
    /**
     * 637. 二叉树的层平均值
     * */
    public static void main(String[] args) {
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t3 = new TreeNode(3, t9, t20);
        List<Double> list = averageOfLevels(t3);
        System.out.println(list);
    }

    private static List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root != null) {
            List<TreeNode> treeNodes = new ArrayList<>();
            treeNodes.add(root);
            while (!treeNodes.isEmpty()) {
                //double sum=treeNodes.stream().mapToDouble(value -> value.val).sum();
                List<TreeNode> tn = new ArrayList<>();
                double sum = 0;
                for (TreeNode treeNode : treeNodes) {
                    sum += treeNode.val;
                    if (treeNode.left != null) {
                        tn.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        tn.add(treeNode.right);
                    }
                }
                list.add(sum / treeNodes.size());
                treeNodes = tn;
            }
        }
        return list;
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
