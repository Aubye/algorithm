package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxDepth {

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
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(2);
        int maxDepth = maxDepth(treeNode);
        log.info("maxDepth:{}", maxDepth);
    }

    public static int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        depth++;
        int leftDeep = maxDepth(root.left, depth);
        int rightDeep = maxDepth(root.right, depth);
        return Math.max(leftDeep, rightDeep);
    }

    public static int maxDepth(TreeNode root, int number) {
        int depth = number;
        if (root == null) {
            return depth;
        }
        depth++;
        if (root.left == null && root.right == null) {
            return depth;
        }
        int leftDeep = maxDepth(root.left, depth);
        int rightDeep = maxDepth(root.right, depth);
        return Math.max(leftDeep, rightDeep);
    }

}
