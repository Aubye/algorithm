package com.app.algorithm.leetcode.lite;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemoveNthFromEnd {

    @Data
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 1; i < 7; i++) {
            ListNode next = new ListNode(i);
            node.next = next;
            node = next;
        }
        head = head.next;

        ListNode removeNth = removeNth(head, 2);
        log.info("result2:{}", removeNth);
        ListNode removeNthFromEnd = removeNthFromEnd(head, 2);
        log.info("result1:{}", removeNthFromEnd);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static ListNode removeNth(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n - 2; i++) {
            slow = node.next;
            node = node.next;
        }
        node = head;
        for (int i = 0; i < n; i++) {
            fast = node.next;
            node = node.next;
        }
        slow.next = fast;
        return head;
    }

}
