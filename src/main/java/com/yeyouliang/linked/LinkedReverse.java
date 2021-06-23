package com.yeyouliang.linked;

/**
 * Created by YYL on 2021/6/9 : 22:43.
 */
public class LinkedReverse {
    /**
     * 实现链表的反转
     * */
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        LinkedInt la = LinkedInt.init(a);
        LinkedInt next = la.getNext();
        LinkedInt linkedInt = new LinkedInt(la.getValue());
        LinkedInt origin = linkedInt;
        while (true) {
            if (next.getValue() == la.getValue()) {
                break;
            }
            linkedInt = new LinkedInt(next.getValue(), linkedInt);
            next = next.getNext();
        }
        origin.setNext(linkedInt);
    }
}
