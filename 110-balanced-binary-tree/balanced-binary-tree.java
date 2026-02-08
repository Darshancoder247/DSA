/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        // base case
        if (node == null) return 0;

        // check left subtree
        int left = height(node.left);
        if (left == -1) return -1;

        // check right subtree
        int right = height(node.right);
        if (right == -1) return -1;

        // check balance condition
        if (Math.abs(left - right) > 1) return -1;

        // return height
        return Math.max(left, right) + 1;
    }
}
