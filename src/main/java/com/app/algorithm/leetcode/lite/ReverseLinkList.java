package com.app.algorithm.leetcode.lite;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReverseLinkList {

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
        ListNode list = new ListNode(0);
        ListNode prev = list;
        for (int i = 0; i < 5; i++) {
            ListNode node = new ListNode(i + 1);
            prev.next = node;
            prev = node;
        }
        list = list.next;

        ListNode result = reverse1(list);
        log.info("result:{}", result);
    }

    private static ListNode reverse(ListNode linklist) {
        ListNode node = linklist;
        ListNode prev = null;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        linklist = prev;
        return linklist;
    }

    private static ListNode reverse1(ListNode linklist) {
        ListNode prev = null;
        ListNode node = linklist;
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
