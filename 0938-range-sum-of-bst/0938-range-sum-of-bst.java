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
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        rec(root, low, high);
        return sum;
    }

    private void rec(TreeNode node, int low, int high){
        if(node == null) return;
        if(node.val <= high && node.val >= low ){
            sum += node.val;
        }
        rec(node.left, low, high);
        rec(node.right, low, high);
    }
}