package com.yeyouliang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/9/12 : 21:54.
 */
public class SymmetricTree {
    /**
     * 101. 对称二叉树
     * */
    public static void main(String[] args) {
        /*TreeNode t_3_1 = new TreeNode(3);
        TreeNode t_3_2 = new TreeNode(4);
        TreeNode t_3_3 = new TreeNode(4);
        TreeNode t_3_4 = new TreeNode(3);
        TreeNode t_2_1 = new TreeNode(2, null, t_3_2);
        TreeNode t_2_2 = new TreeNode(2, null, t_3_4);
        TreeNode t_1_1 = new TreeNode(1, t_2_1, t_2_2);
        System.out.println(isSymmetric(t_1_1));*/
        TreeNode t_1_1 = new TreeNode(1, null, null);
        System.out.println(isSymmetric(t_1_1));
    }

    private static boolean isSymmetric(TreeNode root) {
        boolean falg = false;
        List<TreeNode> list = new ArrayList<>();
        list.add(root.left);
        list.add(root.right);
        while (true) {
            List<TreeNode> leftList = new ArrayList<>();
            List<TreeNode> rightList = new ArrayList<>();
            int start = 0;
            int end = list.size() - 1;
            int length = list.size();
            while (start < end) {
                if (list.get(start) == null && list.get(end) == null) {
                    length -= 2;
                    start++;
                    end--;
                } else if (list.get(start) != null && list.get(end) != null && list.get(start).val == list.get(end).val) {
                    leftList.add(list.get(start).left);
                    leftList.add(list.get(start).right);
                    rightList.add(0, list.get(end).right);
                    rightList.add(0, list.get(end).left);
                    start++;
                    end--;
                } else {
                    break;
                }
            }
            if (length == 0) {
                falg = true;
                break;
            } else {
                if (start >= end) {
                    list.clear();
                    list.addAll(leftList);
                    list.addAll(rightList);
                } else {
                    break;
                }
            }
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
    }
}
