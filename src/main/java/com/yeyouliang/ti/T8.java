package com.yeyouliang.ti;

/**
 * Created by YYL on 2021/11/20 : 10:34.
 */
public class T8 {
    /**
     * 查找单链表的倒数第k个节点
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
        System.out.println(m1(l1, 1).val);
        System.out.println(m1(l1, 2).val);
        System.out.println(m1(l1, 3).val);
        System.out.println(m1(l1, 4).val);
        System.out.println(m1(l1, 5).val);
        System.out.println(m1(l1, 6).val);
        System.out.println(m1(l1, 7).val);
        System.out.println(m1(l1, 8).val);
        ListNode listNode = m1(l1, 9);
        System.out.println(listNode == null ? "null" : listNode.val);
    }

    private static ListNode m1(ListNode head, int k) {
        if (head != null) {
            ListNode listNode = head;
            for (int i = 0; i < k - 1; i++) {
                listNode = listNode.next;
                if (listNode == null) {
                    return null;
                }
            }
            while (listNode.next != null) {
                listNode = listNode.next;
                head = head.next;
            }
            return head;
        }
        return null;
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
