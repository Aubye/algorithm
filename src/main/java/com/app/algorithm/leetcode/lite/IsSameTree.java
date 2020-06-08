package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IsSameTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(1);
        treeNode2.right = new TreeNode(2);
        boolean isSameTree = isSameTree(treeNode1, treeNode2);
        log.info("isSameTree:{}", isSameTree);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p != q) {
                return false;
            } else {
                return true;
            }
        }
        if (p.val != q.val) {
            return false;
        }
        if (!isSameTree(p.left, q.left)) {
            return false;
        }
        if (!isSameTree(p.right, q.right)) {
            return false;
        }
        return true;
    }

}
