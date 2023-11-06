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

    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int[] result = new int[modes.size()];
        for(int i = 0; i < modes.size(); i++){
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inOrderTraversal(TreeNode node){
        if(node == null) return;

        inOrderTraversal(node.left);

        currCount = (node.val == currVal) ? currCount + 1 : 1;
        if(currCount == maxCount){
            modes.add(node.val);
        }
        else if(currCount > maxCount){
            maxCount = currCount;
            modes.clear();
            modes.add(node.val);
        }
        currVal = node.val;

        inOrderTraversal(node.right);
    }
}