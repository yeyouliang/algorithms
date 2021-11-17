package com.yeyouliang.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYL on 2021/10/25 : 20:27.
 */
public class Offer22 {
    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
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
        ListNode listNode = getKthFromEnd(l1, 4);
        System.out.println(listNode == null ? "null" : listNode.val);
    }

    private static ListNode getKthFromEnd(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode listNode = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (k - 1 == 0) {
                listNode = list.get(i);
                break;
            }
            k--;
        }
        return listNode;
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
