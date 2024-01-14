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
    TreeNode prev = null;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        rec(root);
        return min;
    }

    private void rec(TreeNode node){
        if(node == null) return;

        rec(node.left);

        if(prev != null){
            min = Math.min(min, node.val - prev.val);
        }
        prev = node;

        rec(node.right);
    }
}