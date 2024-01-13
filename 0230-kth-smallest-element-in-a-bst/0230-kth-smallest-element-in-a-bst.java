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
    private List<Integer> val;
    public int kthSmallest(TreeNode root, int k) {
        val = new ArrayList<>();
        rec(root);
        Collections.sort(val);
        return val.get(k-1);
    }

    private void rec(TreeNode node){
        if(node == null) return;

        val.add(node.val);

        rec(node.left);
        rec(node.right);
    }
}