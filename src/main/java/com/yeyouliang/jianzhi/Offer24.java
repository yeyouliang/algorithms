package com.yeyouliang.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/10/25 : 20:43.
 */
public class Offer24 {
    /**
     * 剑指 Offer 24. 反转链表
     * */
    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode listNode = reverseList(l1);
        if (listNode == null) {
            System.out.println("null");
        } else {
            System.out.println(listNode.val);
        }
    }

    private static ListNode reverseList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (list.size() > 0) {
            ListNode ln = list.get(list.size() - 1);
            ln.next = null;
            for (int i = list.size() - 2; i >= 0; i--) {
                ListNode node = list.get(i);
                ln.next = node;
                node.next = null;
                ln = node;
            }
            return list.get(list.size() - 1);
        }
        return null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
