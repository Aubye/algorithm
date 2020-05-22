package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(l1, l2);
        log.info("listNode:{}", listNode);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode header = new ListNode(0);
        ListNode prev = header;
        while (l1 != null && l2 != null) {
            ListNode node;
            if (l1.val < l2.val) {
                node = l1.next;
                l1 = l1.next;
            } else {
                node = l2.next;
                l2 = l2.next;
            }
            prev.next = node;
            prev = node;
        }
        prev.next = l1 != null ? l1 : l2;
        return header.next;
    }

}
