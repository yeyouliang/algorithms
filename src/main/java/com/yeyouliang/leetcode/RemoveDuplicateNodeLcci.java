package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/11/3 : 21:23.
 */
public class RemoveDuplicateNodeLcci {
    /**
     * 面试题 02.01. 移除重复节点
     * */
    public static void main(String[] args) {
        /*ListNode l6 = new ListNode(1, 2);
        ListNode l5 = new ListNode(2, 2);
        ListNode l4 = new ListNode(3, 2);
        ListNode l3 = new ListNode(3, 1);
        ListNode l2 = new ListNode(2, 1);
        ListNode l1 = new ListNode(1, 1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;*/

        /*ListNode l5 = new ListNode(2, 1);
        ListNode l4 = new ListNode(1, 4);
        ListNode l3 = new ListNode(1, 3);
        ListNode l2 = new ListNode(1, 2);
        ListNode l1 = new ListNode(1, 1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;*/

        ListNode l2 = new ListNode(1, 2);
        ListNode l1 = new ListNode(1, 1);
        l1.next = l2;

        ListNode listNode = removeDuplicateNodes(l1);
        if (listNode != null) {
            System.out.println(listNode.val);
        } else {
            System.out.println("null");
        }
    }

    private static ListNode removeDuplicateNodes(ListNode head) {
        if (head != null) {
            ListNode a = head;
            while (a != null) {
                ListNode b = a;
                ListNode c = a.next;
                while (c != null) {
                    if (a.val == c.val) {
                        b.next = c.next;
                        c = c.next;
                    } else {
                        b = c;
                        c = c.next;
                    }
                }
                a = a.next;
            }
        }
        return head;
    }

    private static class ListNode {
        int val;
        int order;
        ListNode next;

        ListNode(int x, int o) {
            val = x;
            order = o;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", order=" + order +
                    '}';
        }
    }
}
