package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HasCycleLink {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 给定一个链表，判断链表中是否有环。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * <p>
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     */
    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = new ListNode(0, node1);
        node4.next = node2;
        boolean hasCycle = hasCycle1(node);
        log.info("hasCycle:{}", hasCycle);
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || slow == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

}
