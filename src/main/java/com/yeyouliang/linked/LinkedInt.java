package com.yeyouliang.linked;

/**
 * Created by YYL on 2021/6/21 : 20:25.
 */
public class LinkedInt {
    private int value;
    private LinkedInt next;

    public LinkedInt() {
    }

    public LinkedInt(int value) {
        this.value = value;
    }

    public LinkedInt(int value, LinkedInt next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedInt getNext() {
        return next;
    }

    public void setNext(LinkedInt next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkedInt{" +
                "value=" + value +
                '}';
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
