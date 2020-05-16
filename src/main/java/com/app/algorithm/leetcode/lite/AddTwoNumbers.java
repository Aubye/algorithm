package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);
        log.info("listNode:{}", listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //链表头
        ListNode result = null;
        //上个链表节点
        ListNode prev = null;

        ListNode node1 = l1;
        ListNode node2 = l2;

        //是否需要进位
        boolean flag = false;
        while (true) {
            //两个链表尾部都再无节点
            if (node1 == null && node2 == null) {
                //这时需要进位只需要1
                if (flag) {
                    prev.next = new ListNode(1);
                }
                break;
            }

            //两个链表有可能长度不一致，为了复用进位逻辑赋值为0
            int v1 = node1 != null ? node1.val : 0;
            int v2 = node2 != null ? node2.val : 0;

            //核心运算逻辑
            int sum = v1 + v2;
            if (flag) {
                sum = sum + 1;
            }
            if (sum >= 10) {
                flag = true;
                sum = sum - 10;
            } else {
                flag = false;
            }
            ListNode node = new ListNode(sum);
            if (result == null) {
                result = node;
            } else {
                prev.next = node;
            }
            prev = node;

            //两个链表有可能长度不一致，为了复用进位逻辑赋值为null
            node1 = node1 != null ? node1.next : null;
            node2 = node2 != null ? node2.next : null;
        }
        return result;
    }
}
