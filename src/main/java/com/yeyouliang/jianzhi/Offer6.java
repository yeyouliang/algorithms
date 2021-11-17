package com.yeyouliang.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YYL on 2021/10/23 : 17:58.
 */
public class Offer6 {
    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * */
    public static void main(String[] args) {
        /*ListNode l1=null;*/

        /*ListNode l1 = new ListNode(1);*/

        /*ListNode l1 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        l3.next = new ListNode(2);
        l1.next = l3;*/

        ListNode l1 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        l2.next = l4;
        l3.next = l2;
        l1.next = l3;

        System.out.println(Arrays.toString(reversePrint(l1)));
    }

    private static int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[list.size() - 1 - i] = list.get(i);
        }
        return ints;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
