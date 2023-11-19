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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return res;

        rec(root, 0);

        return res;
    }
    private void rec(TreeNode node, int l){
        
        if(node == null) return;
        
        if(res.size() == l){
            List<Integer> curr = new ArrayList<>();
            curr.add(node.val);
            res.add(curr);
        }
        else{
            res.get(l).add(node.val);
        }
        

        rec(node.left, l+1);
        rec(node.right, l+1);
    


    }
}