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
    public String tree2str(TreeNode root) {
        if(root == null) return "";
        StringBuilder ans = new StringBuilder();
        rec(root, ans);
        return ans.toString();
    }

    private void rec(TreeNode node, StringBuilder ans){
        if(node == null) return;
        
        ans.append(node.val);

        if(node.left != null || node.right != null){
            ans.append("(");
            rec(node.left, ans);
            ans.append(")");

            if(node.right != null){
                ans.append("(");
                rec(node.right, ans);
                ans.append(")");
            }
        }
    }
}