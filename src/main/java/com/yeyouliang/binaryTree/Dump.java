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
     */
    public static void build(int num) {
        for (TreeNode treeNode : list) {
            TreeNode left = treeNode.getLeft();
            TreeNode right = treeNode.getRight();
            boolean has = true;
            TreeNode newTN = new TreeNode(num, null, null);
            if (left == null) {
                treeNode.setLeft(newTN);
            } else if (right == null) {
                treeNode.setRight(newTN);
            } else {
                has = false;
            }
            if (has) {
                list.add(newTN);
                mm(list.get(0));//维持小根堆状态
                return;
            }
        }
    }

    /**
     * 根据整数数组构建二叉树
     * 利用完全二叉树在数组中存储的特性
     */
    public static void buildPlus() {
        int[] ints = {0, 3, 1, 5, 6, 4, 2, 7, 8};
        int length = ints.length;
        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode(ints[0], null, null));
        for (int i = 0; i < length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            TreeNode tn = list.get(i);
            if (left > length - 1) {
                break;
            }
            TreeNode le = new TreeNode(ints[left], null, null);
            tn.setLeft(le);
            list.add(le);
            if (right > length - 1) {
                break;
            }
            TreeNode ri = new TreeNode(ints[right], null, null);
            tn.setRight(ri);
            list.add(ri);
        }
        System.out.println(list.size());
    }

    /**
     * 维持小根堆状态
     */
    public static void mm(TreeNode root) {
        List<TreeNode> tmp = new ArrayList<>();
        tmp.add(root);
        min(root, tmp);
    }

    /**
     * 维持小根堆状态
     */
    public static void min(TreeNode root, List<TreeNode> list) {
        TreeNode left = root.getLeft();
        TreeNode right = root.getRight();
        if (left != null) {
            if (list.get(list.size() - 1).getValue() > left.getValue()) {
                list.add(left);
                int length = list.size();
                for (int i = length - 2; i >= 0; i--) {
                    TreeNode now = list.get(i);
                    TreeNode last = list.get(i + 1);
                    if (now.getValue() > last.getValue()) {
                        int tmp = now.getValue();
                        now.setValue(last.getValue());
                        last.setValue(tmp);
                    }
                }
                return;
            } else {
                List<TreeNode> li = new ArrayList<>(list);
                li.add(left);
                min(left, li);
            }
        }
        if (right != null) {
            if (list.get(list.size() - 1).getValue() > right.getValue()) {
                list.add(right);
                int length = list.size();
                for (int i = length - 2; i >= 0; i--) {
                    TreeNode now = list.get(i);
                    TreeNode last = list.get(i + 1);
                    if (now.getValue() > last.getValue()) {
                        int tmp = now.getValue();
                        now.setValue(last.getValue());
                        last.setValue(tmp);
                    }
                }
            } else {
                List<TreeNode> li = new ArrayList<>(list);
                li.add(right);
                min(right, li);
            }
        }
    }

    public static void max(TreeNode root, int i) {
        int rv = root.getValue();
        if (i > rv) {
            root.setValue(i);

        }
    }
}
