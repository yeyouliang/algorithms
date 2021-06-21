package com.yeyouliang.linked;

/**
 * Created by YYL on 2021/6/21 : 20:26.
 */
public class HasRing {
    public static void main(String[] args) {
        /*LinkedInt five = new LinkedInt(5);
        LinkedInt four = new LinkedInt(4, five);
        LinkedInt three = new LinkedInt(3, four);
        LinkedInt two = new LinkedInt(2, three);
        LinkedInt one = new LinkedInt(1, two);
        five.setNext(one);*/
        int[] ints = {1, 2, 3, 4, 5};
        LinkedInt linkedInt = init(ints);
        int value = linkedInt.getValue();
        LinkedInt next;
        while (true) {
            next = linkedInt.getNext();
            if (next == null) {
                System.out.println("no");
                break;
            } else if (next.getValue() == value) {
                System.out.println("yes");
                break;
            } else {
                linkedInt = next;
            }
        }
    }

    public static LinkedInt init(int[] ints) {
        LinkedInt linkedInt = new LinkedInt(ints[ints.length - 1]);
        LinkedInt next = linkedInt;
        for (int i = ints.length - 2; i >= 0; i--) {
            next = new LinkedInt(ints[i], next);
        }
        linkedInt.setNext(next);
        return next;
    }
}
