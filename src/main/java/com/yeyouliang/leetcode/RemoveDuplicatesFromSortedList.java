package com.yeyouliang.leetcode;

/**
 * Created by YYL on 2021/8/26 : 21:38.
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * 83. 删除排序链表中的重复元素
     * */
    public static void main(String[] args) {
        ListNode lm = new ListNode(7,"a", null);
        ListNode ll = new ListNode(6,"a", lm);
        ListNode lk = new ListNode(5,"b", ll);
        ListNode lj = new ListNode(5,"a", lk);
        ListNode li = new ListNode(4,"b", lj);
        ListNode lh = new ListNode(4,"a", li);
        ListNode lg = new ListNode(3,"d", lh);
        ListNode lf = new ListNode(3,"c", lg);
        ListNode le = new ListNode(3,"b", lf);
        ListNode ld = new ListNode(3,"a", le);
        ListNode lc = new ListNode(2,"a", ld);
        ListNode lb = new ListNode(1,"b", lc);
        ListNode la = new ListNode(1,"a", lb);
        System.out.println(deleteDuplicates(la));
    }

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode root = head;
        if (head != null) {
            ListNode next = head.next;
            while (next != null) {
                if (next.val == head.val) {
                    if (next.next == null) {
                        head.next = null;
                        next = null;
                    } else {
                        head.next = next.next;
                        next = next.next;
                    }
                } else {
                    if (next.next != null) {
                        head = next;
                        next = head.next;
                    }else {
                        next = null;
                    }
                }
            }
        }
        return root;
    }

    private static class ListNode {
        int val;
        String order;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val,String order, ListNode next) {
            this.val = val;
            this.order=order;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", order='" + order + '\'' +
                    '}';
        }
    }
}
