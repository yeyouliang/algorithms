package com.yeyouliang.binaryTree;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/4/22 : 20:39.
 */
public class Dump {

    public static List<TreeNode> list = new ArrayList<>();

    public static void main(String[] args) {
        //int []ints={2,1,5,4,9,15,12,11,8,16,7};
        int[] ints = {7, 13, 4, 5, 8, 1, 11, 9};
        TreeNode root = new TreeNode(ints[0], null, null);
        list.add(root);
        for (int i = 1; i < ints.length; i++) {
            build(ints[i]);
        }
        System.out.println(root.getValue());
    }

    /**
     * 根据整数数组构建二叉树
     * */
    public static void build(int num) {
        while (true) {
            for (TreeNode treeNode : list) {
                TreeNode left = treeNode.getLeft();
                TreeNode right = treeNode.getRight();
                if (left == null) {
                    TreeNode le = new TreeNode(num, null, null);
                    treeNode.setLeft(le);
                    list.add(le);
                    return;
                }
                if (right == null) {
                    TreeNode ri = new TreeNode(num, null, null);
                    treeNode.setRight(ri);
                    list.add(ri);
                    return;
                }
            }
            return;
        }
    }

    public static void max(TreeNode root, int i) {
        int rv = root.getValue();
        if (i > rv) {
            root.setValue(i);

        }
    }
}
