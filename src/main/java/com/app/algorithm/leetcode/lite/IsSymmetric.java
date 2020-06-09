package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IsSymmetric {

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
        boolean symmetric = isSymmetric(treeNode);
        log.info("symmetric:{}", symmetric);
    }

    public static boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSymmetric(left, right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            if (left != right) {
                return false;
            } else {
                return true;
            }
        }
        if (left.val != right.val) {
            return false;
        }
        if (!isSymmetric(left.left, right.right)) {
            return false;
        }
        if (!isSymmetric(left.right, right.left)) {
            return false;
        }
        return true;
    }

}
