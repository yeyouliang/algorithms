package com.yeyouliang.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/11/7 : 14:11.
 */
public class NewSort {

    public static void main(String[] args) {
        int[][] ints = {
                {1},
                {1, 2},
                {1, 2, 3},
                {1, 2, 3, 4},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6, 7},
                {5, 1, 3, 9, 8, 2, 6, 4, 7},
                {2},
                {2, 1},
                {2, 2},
                {2, 5},
                {2, 5, 3, 1, 4},
                {1, 2, 3, 3},
                {2, 1, 2, 5, 3, 2},
                {5, 1, 5, 2, 5, 3, 5, 4},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(heap(anInt)));
        }
    }

    private static int[] heap(int[] ints) {
        if (ints != null && ints.length > 1) {
            List<TreeNode> a = new ArrayList<>();
            for (int anInt : ints) {
                a.add(new TreeNode(anInt));
            }
            int b = 0;
            while (true) {
                int c = b * 2 + 1;
                if (c < ints.length) {
                    a.get(b).left = a.get(c);
                    if (c + 1 < ints.length) {
                        a.get(b).right = a.get(c + 1);
                    } else {
                        break;
                    }
                } else {
                    break;
                }
                b++;
            }
            System.out.println(a.size());
        }
        return ints;
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

    private static int[] maopao(int[] ints) {
        if (ints != null && ints.length > 1) {
            for (int i = ints.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (ints[j] > ints[j + 1]) {
                        int temp = ints[j];
                        ints[j] = ints[j + 1];
                        ints[j + 1] = temp;
                    }
                }
            }
        }
        return ints;
    }

    private static int[] kuaipai(int[] ints) {
        if (ints != null && ints.length > 1) {
            int[] a = new int[ints.length];
            int[] b = new int[ints.length];
            int c = 0;
            int d = 0;
            for (int i = 1; i < ints.length; i++) {
                if (ints[i] >= ints[0]) {
                    b[d++] = ints[i];
                } else {
                    a[c++] = ints[i];
                }
            }
            ints[c] = ints[0];
            int[] e = new int[c];
            System.arraycopy(a, 0, e, 0, c);
            int[] f = new int[d];
            System.arraycopy(b, 0, f, 0, d);
            int[] g = kuaipai(e);
            int[] h = kuaipai(f);
            System.arraycopy(g, 0, ints, 0, c);
            System.arraycopy(h, 0, ints, c + 1, d);
        }
        return ints;
    }

    private static int[] zhicha(int[] ints) {
        if (ints != null && ints.length > 1) {
            for (int i = 1; i < ints.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (ints[j - 1] > ints[j]) {
                        int temp = ints[j - 1];
                        ints[j - 1] = ints[j];
                        ints[j] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
        return ints;
    }

    private static int[] selection(int[] ints) {
        if (ints != null && ints.length > 1) {
            for (int i = 0; i < ints.length - 1; i++) {
                int a = i;
                int b = ints[i];
                for (int j = i + 1; j < ints.length; j++) {
                    if (ints[j] < b) {
                        a = j;
                        b = ints[j];
                    }
                }
                if (a != i) {
                    int temp = ints[i];
                    ints[i] = ints[a];
                    ints[a] = temp;
                }
            }
        }
        return ints;
    }

}
