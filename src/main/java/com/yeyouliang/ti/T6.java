package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/19 : 15:58.
 */
public class T6 {
    /**
     * 链表中倒数第k个节点
     * */
    public static void main(String[] args) {
        ListNode l8 = new ListNode(8);
        ListNode l7 = new ListNode(7, l8);
        ListNode l6 = new ListNode(6, l7);
        ListNode l5 = new ListNode(5, l6);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        System.out.println(getKthFromEnd(l1, 1).val);
        System.out.println(getKthFromEnd(l1, 2).val);
        System.out.println(getKthFromEnd(l1, 3).val);
        System.out.println(getKthFromEnd(l1, 4).val);
        System.out.println(getKthFromEnd(l1, 5).val);
        System.out.println(getKthFromEnd(l1, 6).val);
        System.out.println(getKthFromEnd(l1, 7).val);
        System.out.println(getKthFromEnd(l1, 8).val);
    }

    private static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode listNode = head;
        for (int i = 0; i < k - 1; i++) {
            listNode = listNode.next;
        }
        if (listNode.next == null) {
            return head;
        } else {
            return getKthFromEnd(head.next, k);
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
