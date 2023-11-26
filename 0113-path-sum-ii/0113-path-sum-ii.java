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
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        rec(root, targetSum, new ArrayList<>());

        return res;
    }
    private void rec(TreeNode node, int remains, List<Integer> list){
        if(node == null) return;

        list.add(node.val);
        if(node.val == remains && node.left == null && node.right == null){
            res.add(new ArrayList<>(list));
        }

        rec(node.left, remains - node.val, list);
        rec(node.right, remains - node.val, list);

        list.remove(list.size()-1);
    }
}