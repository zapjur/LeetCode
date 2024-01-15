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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false; 
        if (check(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    private boolean check(TreeNode node, TreeNode sub){
        if (node == null && sub == null) {
            return true;
        }

        if (node == null || sub == null || node.val != sub.val) {
            return false;
        }

        return check(node.left, sub.left) && check(node.right, sub.right);
    }

    private TreeNode find(TreeNode node, TreeNode subRoot){
        if(node == null) return null;
        if(node.val == subRoot.val) return node;

        TreeNode left = find(node.left, subRoot);
        if (left != null) return left;

        TreeNode right = find(node.right, subRoot);
        return right;
    }
}