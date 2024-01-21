/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return rec(target.val, cloned);
    }

    private TreeNode rec(int orgVal, TreeNode node){
        if(node == null) return null;
        if(orgVal == node.val) return node;

        
    TreeNode leftSearch = rec(orgVal, node.left);
    if(leftSearch != null) return leftSearch;

    return rec(orgVal, node.right);

    }
}