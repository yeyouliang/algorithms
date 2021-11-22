package com.yeyouliang.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/11/22 : 11:22.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[][] ints = {
                {8, 9, 1, 7, 2, 3, 5, 4, 6, 0},
        };
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt) + ":" + Arrays.toString(heapSort(anInt)));
        }
    }

    /**
     * 堆排序
     */
    private static int[] heapSort(int[] ints) {
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
}
