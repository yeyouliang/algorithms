package com.yeyouliang.jianzhi;

/**
 * Created by YYL on 2021/10/25 : 11:13.
 */
public class Offer18 {
    /**
     * 剑指 Offer 18. 删除链表的节点
     * */
    public static void main(String[] args) {
        /*ListNode l4 = new ListNode(4);
        ListNode listNode = deleteNode(l4, 4);*/

        /*ListNode l4 = new ListNode(4);
        ListNode listNode = deleteNode(l4, 5);*/

        /*ListNode l9 = new ListNode(9);
        ListNode l1 = new ListNode(1);
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        l4.next = l5;
        l5.next = l1;
        l1.next = l9;
        ListNode listNode = deleteNode(l4, 4);*/
        //ListNode listNode = deleteNode(l4, 5);
        //ListNode listNode = deleteNode(l4, 1);
        //ListNode listNode = deleteNode(l4, 9);

        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        l4.next = l5;
        //ListNode listNode = deleteNode(l4, 4);
        //ListNode listNode = deleteNode(l4, 5);
        ListNode listNode = deleteNode(l4, 6);
        if (listNode != null) {
            System.out.println(listNode.val);
        } else {
            System.out.println("null");
        }
    }

    private static ListNode deleteNode(ListNode head, int val) {
        if (head != null) {
            if (head.val != val) {
                ListNode h = head;
                ListNode next = h.next;
                while (next != null) {
                    if (next.val == val) {
                        if (next.next != null) {
                            h.next = next.next;
                        } else {
                            h.next = null;
                        }
                        break;
                    } else {
                        h = next;
                        next = next.next;
                    }
                }
            } else {
                head = head.next;
            }
        }
        return head;
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
