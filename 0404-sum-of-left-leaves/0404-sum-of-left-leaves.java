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
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {

        rec(root);
        return sum;
        
    }
    private void rec(TreeNode node){
        if(node == null) return;

        rec(node.left);
        rec(node.right);

        if(node.left != null && node.left.left == null && node.left.right == null){
            sum += node.left.val;
        }
    }
}