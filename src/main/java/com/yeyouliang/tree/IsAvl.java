package com.yeyouliang.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/11/17 : 22:09.
 */
public class IsAvl {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t13 = new TreeNode(13);
        TreeNode t16 = new TreeNode(16);
        TreeNode t21 = new TreeNode(21);
        TreeNode t30 = new TreeNode(30);
        TreeNode t2 = new TreeNode(2, t1, null);
        TreeNode t5 = new TreeNode(5, t4, t6);
        TreeNode t15 = new TreeNode(15, t13, t16);
        TreeNode t29 = new TreeNode(29, t21, t30);
        TreeNode t3 = new TreeNode(3, t2, t5);
        TreeNode t20 = new TreeNode(20, t15, t29);
        TreeNode t8 = new TreeNode(8, t3, t20);
        System.out.println(isAvl(t8));
    }

    /**
     * 判断二叉树是否是平衡二叉树
     */
    private static boolean isAvl(TreeNode treeNode) {
        if (treeNode != null) {
            List<TreeNode> list = new ArrayList<>();
            list.add(treeNode);
            //当前遍历的楼层
            int a = 1;
            //如果不为-1，则其值为第一次出现没有双子节点的节点的楼层。只有下一层是最后一层才满足平衡二叉树的条件。
            int b = -1;
            while (true) {
                List<TreeNode> newList = new ArrayList<>();
                for (TreeNode node : list) {
                    //判断
                    if (b > 0 && a - b > 1) {
                        return false;
                    }
                    if (node.left != null) {
                        newList.add(node.left);
                    } else {
                        if (b == -1) {
                            b = a;
                        }
                    }
                    if (node.right != null) {
                        newList.add(node.right);
                    } else {
                        if (b == -1) {
                            b = a;
                        }
                    }
                }
                if (newList.isEmpty()) {
                    break;
                } else {
                    a++;
                    list = newList;
                }
            }
            //判断
            return !(b > 0 && a - b > 1);
        }
        return false;
    }
}
