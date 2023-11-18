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
    public TreeNode sortedArrayToBST(int[] nums) {
        return rec(nums, 0, nums.length - 1);
    }

    private TreeNode rec(int[] nums, int l, int r){
        if(l > r) return null;

        int mid = (l+r)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = rec(nums, l, mid-1);
        node.right = rec(nums, mid+1, r);

        return node;

    }
}