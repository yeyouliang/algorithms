package com.yeyouliang.lcci;

import java.util.Arrays;

/**
 * Created by YYL on 2021/11/5 : 14:57.
 */
public class MinimumHeightTree {
    /**
     * 面试题 04.02. 最小高度树
     * */
    public static void main(String[] args) {
        int[][] ints = {
                {-10,-3,0,5,9},
                {},
                {1},
                {1, 2},
                {1, 2, 3},
                {1, 2, 3, 4},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6, 7},
        };
        for (int[] anInt : ints) {
            TreeNode treeNode = sortedArrayToBST(anInt);
            System.out.println(Arrays.toString(anInt) + ":" + (treeNode == null ? "null" : treeNode.val));
        }
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = null;
        if (nums.length > 0) {
            if (nums.length == 1) {
                treeNode = new TreeNode(nums[0]);
            } else {
                int a = nums.length / 2;
                treeNode = new TreeNode(nums[a]);
                int[] b = new int[a];
                System.arraycopy(nums, 0, b, 0, a);
                treeNode.left = sortedArrayToBST(b);
                int[] c = new int[nums.length - a - 1];
                System.arraycopy(nums, a + 1, c, 0, nums.length - a - 1);
                treeNode.right = sortedArrayToBST(c);
            }
        }
        return treeNode;
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
