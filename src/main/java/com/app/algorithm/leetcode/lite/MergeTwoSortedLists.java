package com.app.algorithm.leetcode.lite;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        ListNode listNode = mergeTwoSortedLists(l1, l2);
        log.info("listNode:{}", listNode);
        ListNode listNode1 = mergeTwoSortedLists1(l1, l2);
        log.info("listNode1:{}", listNode1);
    }

    @Data
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode header = new ListNode(0);
        ListNode prev = header;
        while (l1 != null & l2 != null) {
            ListNode node;
            if (l1.val < l2.val) {
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }
            prev.next = node;
            prev = node;
        }
        prev.next = l1 != null ? l1 : l2;
        return header.next;
    }

    public static ListNode mergeTwoSortedLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode header = new ListNode(0);
        ListNode prev = header;
        while (l1 != null & l2 != null) {
            ListNode node;
            if (l1.val < l2.val) {
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }
            prev.next = node;
            prev = node;
        }
        prev.next = l1 != null ? l1 : l2;
        return header.next;
    }

}
