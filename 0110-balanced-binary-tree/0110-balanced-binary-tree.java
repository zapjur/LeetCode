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
        if(root == null) return true;

        return check(root) != -1;
    }
    private int check(TreeNode node){
        if(node == null) return 0;

        int lH = check(node.left);
        int rH = check(node.right);

        if(lH == -1 || rH == -1) return -1;
        if(Math.abs(lH - rH) > 1) return -1;

        return Math.max(lH, rH) + 1;
        
    }
}