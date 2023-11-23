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
    int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        rec(root);
        return d;
    }
    private int rec(TreeNode node){
        if(node == null) return 0;

        int left = rec(node.left);
        int right = rec(node.right);

        d = Math.max(d, left + right);

        return Math.max(left, right) + 1;
    }
}