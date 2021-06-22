package com.yeyouliang.linked;

/**
 * Created by YYL on 2021/6/22 : 23:05.
 */
public class TwoRingIsEquals {
    public static void main(String[] args) {
        int[][][] ints = {
                {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}},//
                {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 1}},
                {{2, 3, 4, 5, 1}, {1, 2, 3, 4, 5}},//
                {{1, 2, 3, 4, 5}, {3, 4, 5, 1, 2}},
                {{3, 4, 5, 1, 2}, {1, 2, 3, 4, 5}},//
                {{1, 2, 3, 4, 5}, {4, 5, 1, 2, 3}},
                {{4, 5, 1, 2, 3}, {1, 2, 3, 4, 5}},//
                {{1, 2, 3, 4, 5}, {5, 1, 2, 3, 4}},
                {{5, 1, 2, 3, 4}, {1, 2, 3, 4, 5}}};//
        for (int[][] anInt : ints) {
            test(anInt[0], anInt[1]);
            System.out.println();
        }
    }

    /**
     * 相同长度的两个数组
     */
    public static void test(int[] a, int[] b) {
        LinkedInt ka = LinkedInt.init(a);
        LinkedInt kb = LinkedInt.init(b);
        if (ka.getValue() == kb.getValue()) {
            if (equal(ka, kb)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            return;
        }
        LinkedInt na = ka.getNext();
        LinkedInt nb = kb.getNext();
        while (true) {
            if (na.getValue() == ka.getValue()) {
                if (na.getValue() == nb.getValue()) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
                break;
            }
            if (na.getValue() == kb.getValue()) {
                if (equal(na, kb)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
                break;
            }
            if (nb.getValue() == ka.getValue()) {
                if (equal(nb, ka)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
                break;
            }
            na = na.getNext();
            nb = nb.getNext();
        }
    }

    public static boolean equal(LinkedInt start, LinkedInt open) {
        boolean flag = true;
        LinkedInt na = start.getNext();
        LinkedInt nb = open.getNext();
        while (true) {
            if (na.getValue() == start.getValue()) {
                break;
            }
            if (na.getValue() != nb.getValue()) {
                flag = false;
                break;
            }
            na = na.getNext();
            nb = nb.getNext();
        }
        return flag;
    }
}
