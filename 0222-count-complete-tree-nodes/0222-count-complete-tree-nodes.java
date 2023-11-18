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
    private int res = 0;
    public int countNodes(TreeNode root) {
        if(root == null ) return 0;

        rec(root);
        return res;
    }
    private void rec(TreeNode node){
        if(node == null) return;
        res++;
        rec(node.left);
        rec(node.right);
    }
}