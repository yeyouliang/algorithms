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
                {8, 9, 1, 7, 2, 3, 5, 4, 6, 0},
                {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48},
                {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48, 100, 10000},
                {4, 1, 9, 3, 7, 8, 5, 6, 2},
                {4, 6, 8, 5, 9},
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
            System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(guibing(anInt)));
        }
    }

    /**
     * 归并排序
     * */
    private static int[] guibing(int[] ints) {
        if (ints != null && ints.length > 1) {
            if (ints.length == 2) {
                if (ints[0] > ints[1]) {
                    int temp = ints[0];
                    ints[0] = ints[1];
                    ints[1] = temp;
                }
            } else {
                int a = ints.length / 2;
                int[] b = new int[a];
                int[] c = new int[ints.length - a];
                System.arraycopy(ints, 0, b, 0, b.length);
                System.arraycopy(ints, a, c, 0, c.length);
                int[] d = guibing(b);
                int[] e = guibing(c);
                int f = 0;
                int g = 0;
                int h = 0;
                while (true) {
                    if (g == d.length) {
                        for (int i = h; i < e.length; i++) {
                            ints[f++] = e[i];
                        }
                        break;
                    }
                    if (h == e.length) {
                        for (int i = g; i < d.length; i++) {
                            ints[f++] = d[i];
                        }
                        break;
                    }
                    if (d[g] < e[h]) {
                        ints[f++] = d[g++];
                    } else {
                        ints[f++] = e[h++];
                    }
                }
            }
        }
        return ints;
    }

    /**
     * 希尔排序
     */
    private static int[] shell(int[] ints) {
        if (ints != null && ints.length > 1) {
            int a = ints.length / 2;
            while (a > 0) {
                for (int i = ints.length - 1; i > 0; i--) {
                    int b = i;
                    int c = i - a;
                    boolean d = true;
                    while (c >= 0) {
                        if (ints[c] > ints[b]) {
                            int temp = ints[c];
                            ints[c] = ints[b];
                            ints[b] = temp;
                        }
                        b = c;
                        c -= a;
                        d = false;
                    }
                    if (d) {
                        break;
                    }
                }
                a /= 2;
                System.out.println(Arrays.toString(ints));
            }
        }
        return ints;
    }

    /**
     * 基数排序
     * */
    private static int[] jishu(int[] ints) {
        if (ints != null && ints.length > 1) {
            int a = 0;
            int b = 0;
            do {
                List<Integer> l0 = new ArrayList<>();
                List<Integer> l1 = new ArrayList<>();
                List<Integer> l2 = new ArrayList<>();
                List<Integer> l3 = new ArrayList<>();
                List<Integer> l4 = new ArrayList<>();
                List<Integer> l5 = new ArrayList<>();
                List<Integer> l6 = new ArrayList<>();
                List<Integer> l7 = new ArrayList<>();
                List<Integer> l8 = new ArrayList<>();
                List<Integer> l9 = new ArrayList<>();
                for (int anInt : ints) {
                    String c = String.valueOf(anInt);
                    b = Math.max(c.length(), b);
                    if (c.length() > a) {
                        switch (c.substring(c.length() - 1 - a, c.length() - 1 - a + 1)) {
                            case "0":
                                l0.add(anInt);
                                break;
                            case "1":
                                l1.add(anInt);
                                break;
                            case "2":
                                l2.add(anInt);
                                break;
                            case "3":
                                l3.add(anInt);
                                break;
                            case "4":
                                l4.add(anInt);
                                break;
                            case "5":
                                l5.add(anInt);
                                break;
                            case "6":
                                l6.add(anInt);
                                break;
                            case "7":
                                l7.add(anInt);
                                break;
                            case "8":
                                l8.add(anInt);
                                break;
                            case "9":
                                l9.add(anInt);
                                break;
                        }
                    } else {
                        l0.add(anInt);
                    }
                }
                int d = 0;
                for (Integer integer : l0) {
                    ints[d++] = integer;
                }
                for (Integer integer : l1) {
                    ints[d++] = integer;
                }
                for (Integer integer : l2) {
                    ints[d++] = integer;
                }
                for (Integer integer : l3) {
                    ints[d++] = integer;
                }
                for (Integer integer : l4) {
                    ints[d++] = integer;
                }
                for (Integer integer : l5) {
                    ints[d++] = integer;
                }
                for (Integer integer : l6) {
                    ints[d++] = integer;
                }
                for (Integer integer : l7) {
                    ints[d++] = integer;
                }
                for (Integer integer : l8) {
                    ints[d++] = integer;
                }
                for (Integer integer : l9) {
                    ints[d++] = integer;
                }
                a++;
            } while (a < b);
        }
        return ints;
    }

    /**
     * 堆排序
     * */
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
            int d = a.size() / 2 + 1;
            while (true) {
                if (d * 2 + 1 < a.size()) {
                    break;
                } else {
                    d--;
                }
            }
            int e = d;
            while (d >= 0) {
                TreeNode f = a.get(d);
                TreeNode g = f.left;
                TreeNode h = f.right;
                boolean i = false;
                if (h != null) {
                    if (f.val < h.val) {
                        int temp = f.val;
                        f.val = h.val;
                        h.val = temp;
                        i = true;
                    }
                }
                if (g != null) {
                    if (f.val < g.val) {
                        int temp = f.val;
                        f.val = g.val;
                        g.val = temp;
                        i = true;
                    }
                }
                if (i) {
                    d = e;
                } else {
                    d--;
                }
            }
            int j = a.size() - 1;
            for (int i = j; i >= 0; i--) {
                ints[i] = a.get(0).val;
                a.get(0).val = a.get(i).val;
                a.set(i, null);
                int k = 0;
                while (true) {
                    if (k * 2 + 1 < i) {
                        TreeNode l = a.get(k);
                        TreeNode m = a.get(k * 2 + 1);
                        if (l.val < m.val) {
                            if (k * 2 + 2 < i) {
                                TreeNode n = a.get(k * 2 + 2);
                                if (m.val > n.val) {
                                    int temp = m.val;
                                    m.val = l.val;
                                    l.val = temp;
                                } else {
                                    int temp = n.val;
                                    n.val = l.val;
                                    l.val = temp;
                                }
                            } else {
                                int temp = l.val;
                                l.val = m.val;
                                m.val = temp;
                                break;
                            }
                        } else {
                            if (k * 2 + 2 < i) {
                                TreeNode n = a.get(k * 2 + 2);
                                if (l.val < n.val) {
                                    if (m.val > n.val) {
                                        int temp = m.val;
                                        m.val = l.val;
                                        l.val = temp;
                                    } else {
                                        int temp = n.val;
                                        n.val = l.val;
                                        l.val = temp;
                                    }
                                }
                            }
                        }
                        k++;
                    } else {
                        break;
                    }
                }
            }
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

    /**
     * 冒泡排序
     * */
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

    /**
     * 快速排序
     * */
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

    /**
     * 直接插入排序
     * */
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

    /**
     * 选择排序
     * */
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
