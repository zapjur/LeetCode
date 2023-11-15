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
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        backtrack(root, new StringBuilder(), res);

        return res;
    }

    private void backtrack(TreeNode node, StringBuilder path, List<String> res){
        if(node == null) return;
        int len = path.length();
        if(len > 0) path.append("->");
        path.append(node.val);

        if(node.left == null && node.right == null){
            res.add(path.toString());
        }
        else{
            backtrack(node.left, path, res);
            backtrack(node.right, path, res);
        }
        path.setLength(len);
    }
}