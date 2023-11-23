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
    int min = Integer.MAX_VALUE;
    int prev = -1;
    public int getMinimumDifference(TreeNode root) {
        
        rec(root);
        return min;

    }
    private void rec(TreeNode node){
        if(node == null) return;

        rec(node.left);
        if(prev != -1)
            min = Math.min(min, Math.abs(prev - node.val));
        
        prev = node.val;
        rec(node.right);
    }
}