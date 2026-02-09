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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        
        // Step 1: inorder traversal
        inorder(root, values);
        
        // Step 2: build balanced BST
        return buildBST(values, 0, values.size() - 1);
    }
    
    private void inorder(TreeNode node, List<Integer> values) {
        if (node == null) return;
        
        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }
    
    private TreeNode buildBST(List<Integer> values, int left, int right) {
        if (left > right) return null;
        
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(values.get(mid));
        
        root.left = buildBST(values, left, mid - 1);
        root.right = buildBST(values, mid + 1, right);
        
        return root;
    }
}
