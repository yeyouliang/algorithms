package com.yeyouliang.linked;

/**
 * Created by YYL on 2021/11/15 : 15:27.
 */
public class DeleteMiddleNode {
    /**
     * 删除链表中间节点
     * */
    public static void main(String[] args) {
        ListNode l9 = new ListNode(9);
        ListNode l8 = new ListNode(8);
        ListNode l7 = new ListNode(7);
        ListNode l6 = new ListNode(6);
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        deleteNode(l1);
        System.out.println();
    }

    private static void deleteNode(ListNode node) {
        ListNode ln = node.next;
        if (ln != null) {
            node.val = ln.val;
            node.next = ln.next;
        }
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
