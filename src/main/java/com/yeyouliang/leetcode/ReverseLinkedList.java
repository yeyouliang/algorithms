package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/9/25 : 18:08.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode listNode = reverseList(l1);
        System.out.println(listNode.val);
    }

    private static ListNode reverseList(ListNode head) {
        if (head != null) {
            ListNode next = head.next;
            if (next != null) {
                ListNode listNode = reverseList(next);
                ListNode b = listNode;
                while (b.next != null) {
                    b = b.next;
                }
                b.next = new ListNode(head.val);
                head = listNode;
            }
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}
