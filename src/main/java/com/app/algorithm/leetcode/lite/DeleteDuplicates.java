package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeleteDuplicates {

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

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next = new ListNode(4);
        ListNode node = deleteDuplicates(listNode);
        log.info("node:{}", node);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        ListNode next = head.next;
        if (next == null) {
            return head;
        }
        while (true) {
            if (prev.val != next.val) {
                prev.next = next;
                prev = next;
                continue;
            }
            if (next.next == null) {
                prev.next = null;
                break;
            }
            next = next.next;
        }
        return head;
    }

}
