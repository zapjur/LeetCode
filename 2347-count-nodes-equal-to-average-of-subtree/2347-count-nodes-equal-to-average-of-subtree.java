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

    private static int ans;

    private static int numOfNodes(TreeNode node){
        if(node == null) return 0;

        return numOfNodes(node.left) + numOfNodes(node.right) + 1;
    }

    private static int sumNodes(TreeNode node){
        if(node == null) return 0;

        return sumNodes(node.left) + sumNodes(node.right) + node.val;
    }

    private static void helper(TreeNode node){
        if(node == null) return;

        int sum = sumNodes(node.left) + sumNodes(node.right) + node.val;
        int num = numOfNodes(node.left) + numOfNodes(node.right) + 1;

        if(num != 0 && (node.val == (sum/num))){
            ans++;
        }
        helper(node.left);
        helper(node.right);
    }

    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;

    }
}