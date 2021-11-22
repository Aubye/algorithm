package com.app.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Leetcode_2 {

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
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     */
    public static void main(String[] args) {
        //54325
        ListNode l1 = new ListNode(5, null);
        l1.next = new ListNode(2, null);
        l1.next.next = new ListNode(3, null);
        l1.next.next.next = new ListNode(4, null);
        l1.next.next.next.next = new ListNode(5, null);
        //54325
        ListNode l2 = new ListNode(5, null);
        l2.next = new ListNode(2, null);
        l2.next.next = new ListNode(3, null);
        l2.next.next.next = new ListNode(4, null);
        l2.next.next.next.next = new ListNode(5, null);
        //056801
        ListNode result = addTwoNumbers(l1, l2);
        log.info("finish, result:{}", result);
        ListNode result1 = addTwoNumbers1(l1, l2);
        log.info("finish, result1:{}", result1);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0, null);
        ListNode prev = node;
        ListNode prev1 = l1;
        ListNode prev2 = l2;
        boolean flag = false;
        while (prev1 != null || prev2 != null) {
            int v1 = prev1 != null ? prev1.val : 0;
            int v2 = prev2 != null ? prev2.val : 0;
            int sum = v1 + v2;
            if (flag) {
                sum = sum + 1;
            }
            int num = sum % 10;
            ListNode listNode = new ListNode(num, null);
            prev.next = listNode;
            prev = listNode;
            prev1 = prev1 != null ? prev1.next : null;
            prev2 = prev2 != null ? prev2.next : null;
            if (sum >= 10) {
                flag = true;
                continue;
            }
            flag = false;
        }
        if (flag) {
            prev.next = new ListNode(1, null);
        }
        return node.next;
    }

    private static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0, null);
        ListNode prev = node;
        ListNode prev1 = l1;
        ListNode prev2 = l2;
        boolean flag = false;
        while (prev1 != null || prev2 != null) {
            int v1 = prev1 != null ? prev1.val : 0;
            int v2 = prev2 != null ? prev2.val : 0;
            int sum = v1 + v2;
            if (flag) {
                sum = sum + 1;
            }
            int num = sum % 10;
            ListNode current = new ListNode(num, null);
            prev.next = current;
            prev = current;
            prev1 = prev1 != null ? prev1.next : null;
            prev2 = prev2 != null ? prev2.next : null;
            if (sum >= 10) {
                flag = true;
                continue;
            }
            flag = false;
        }
        if (flag) {
            prev.next = new ListNode(1, null);
        }
        return node.next;
    }

}
