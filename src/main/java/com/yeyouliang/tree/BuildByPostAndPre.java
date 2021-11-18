package com.yeyouliang.tree;

/**
 * Created by YYL on 2021/11/17 : 22:17.
 */
public class BuildByPostAndPre {
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
        //TreeNode treeNode = buildByPostAndPre(new int[]{6, 2, 1, 4, 3, 7}, new int[]{1, 3, 4, 2, 7, 6});
        TreeNode treeNode = buildByPostAndPre(new int[]{8, 3, 2, 1, 5, 4, 6, 20, 15, 13, 16, 29, 21, 30}, new int[]{1, 2, 4, 6, 5, 3, 13, 16, 15, 21, 30, 29, 20, 8});
        //TreeNode treeNode = buildByPostAndPre(new int[]{1, 2, 3, 4, 5, 6}, new int[]{6, 5, 4, 3, 2, 1});
        //TreeNode treeNode = buildByPostAndPre(new int[]{6, 5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(treeNode.val);
    }

    /**
     * 前序遍历和后序遍历构造二叉树
     * 仅对二叉搜索树有效
     */
    private static TreeNode buildByPostAndPre(int[] a, int[] b) {
        TreeNode treeNode = null;
        if (a.length > 0) {
            //第一个节点为根节点
            treeNode = new TreeNode(a[0]);
            if (a.length == 2) {
                TreeNode tn = new TreeNode(a[1]);
                //两种可能情况：[{{2,1},{1,2}},{{1,2},{2,1}}],根据二叉搜索树的定义确定子树是左还是右。
                if (a[0] < a[1]) {
                    treeNode.right = tn;
                } else {
                    treeNode.left = tn;
                }
            } else if (a.length == 3) {
                //两种可能情况：[{{2,1,3},{1,3,2}},{{3,2,1},{1,2,3}},{{1,2,3},{3,2,1}}],根据二叉搜索树的定义确定子树是左还是右。
                if (a[1] > a[2]) {
                    TreeNode n = new TreeNode(a[1]);
                    TreeNode nn = new TreeNode(a[2]);
                    treeNode.left = n;
                    n.left = nn;
                } else {
                    if (b[0] < b[1]) {
                        TreeNode n = new TreeNode(a[1]);
                        TreeNode nn = new TreeNode(a[2]);
                        treeNode.left = n;
                        treeNode.right = nn;
                    } else {
                        TreeNode n = new TreeNode(a[1]);
                        TreeNode nn = new TreeNode(a[2]);
                        treeNode.right = n;
                        n.right = nn;
                    }
                }
            } else if (a.length > 3) {
                //左子树
                int c = a[1];
                //右子树
                int d = b[b.length - 2];
                //相等则为斜树，根据二叉搜索树的定义确定子树是左还是右。
                if (c == d) {
                    int[] e = new int[a.length - 1];
                    System.arraycopy(a, 1, e, 0, e.length);
                    int[] f = new int[b.length - 1];
                    System.arraycopy(b, 0, f, 0, f.length);
                    if (a[0] < c) {
                        treeNode.right = buildByPostAndPre(e, f);
                    } else {
                        treeNode.left = buildByPostAndPre(e, f);
                    }
                } else {
                    //右子树在前序遍历数组中的下标
                    int e = -1;
                    for (int i = 1; i < a.length; i++) {
                        if (a[i] == d) {
                            e = i;
                            break;
                        }
                    }
                    int[] f = new int[e - 1];
                    System.arraycopy(a, 1, f, 0, f.length);
                    int[] g = new int[a.length - e];
                    System.arraycopy(a, e, g, 0, g.length);
                    //左子树在后序遍历数组中的下标
                    int h = -1;
                    for (int i = 0; i < b.length; i++) {
                        if (b[i] == c) {
                            h = i;
                            break;
                        }
                    }
                    int[] i = new int[h + 1];
                    System.arraycopy(b, 0, i, 0, i.length);
                    int[] j = new int[b.length - h - 2];
                    System.arraycopy(b, h + 1, j, 0, j.length);
                    //将左右部分各自的前序遍历数组和后序遍历数组各自进行递归
                    treeNode.left = buildByPostAndPre(f, i);
                    treeNode.right = buildByPostAndPre(g, j);
                }
            }
        }
        return treeNode;
    }
}
