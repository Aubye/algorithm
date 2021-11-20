package com.app.algorithm.leetcode.number.n2;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddTwoNumbers {

    @Data
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     */
    public static void main(String[] args) {
        // 1 - 2 - 3 - 4 - 5 - 6
        ListNode l1 = buildListNode(1, 2, 5);
        // 1 - 3 - 4 - 5 - 6 - 7
        ListNode l2 = buildListNode(1, 3, 5);
        // 2 - 5 - 7 - 9 - 1 - 4 - 1
        ListNode result = addTwoNumbers(l1, l2);
        log.info("l1:{}", l1);
        log.info("l2:{}", l2);
        log.info("finish result:{}", result);
    }

    private static ListNode buildListNode(int start, int interval, int total) {
        ListNode node = new ListNode(start);
        ListNode prev = null;
        for (int i = 0; i < total; i++) {
            int val = i + interval;
            ListNode tmp = new ListNode(val);
            if (prev == null) {
                node.next = tmp;
                prev = tmp;
                continue;
            }
            prev.next = tmp;
            prev = tmp;
        }
        return node;
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode prev = null;
        int carry = 0;

        ListNode n1 = l1;
        ListNode n2 = l2;
        while (n1 != null || n2 != null) {
            int v1 = 0;
            int v2 = 0;
            if (n1 != null) {
                v1 = n1.val;
            }
            if (n2 != null) {
                v2 = n2.val;
            }
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            int val = sum % 10;
            if (prev == null) {
                prev = new ListNode(val);
                node.next = prev;
                if (n1 != null) {
                    n1 = n1.next;
                }
                if (n2 != null) {
                    n2 = n2.next;
                }
                continue;
            }
            ListNode tmp = new ListNode(val);
            prev.next = tmp;
            prev = tmp;
            if (n1 != null) {
                n1 = n1.next;
            }
            if (n2 != null) {
                n2 = n2.next;
            }
        }
        if (carry != 0) {
            prev.next = new ListNode(carry);
        }
        return node.next;
    }

}
