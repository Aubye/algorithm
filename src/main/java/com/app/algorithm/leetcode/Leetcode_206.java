package com.app.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Leetcode_206 {

    static class ListNode {
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
    }

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5, null);
        l1.next = new ListNode(2, null);
        l1.next.next = new ListNode(3, null);
        l1.next.next.next = new ListNode(4, null);
        l1.next.next.next.next = new ListNode(5, null);
        ListNode result1 = reverseList(l1);
        log.info("result1:{}", result1);
        log.info("finish");
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode node = head;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

}
