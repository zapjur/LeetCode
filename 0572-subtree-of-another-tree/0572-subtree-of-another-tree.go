/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSubtree(root *TreeNode, subRoot *TreeNode) bool {
    if root == nil { return false }

    if rec(root, subRoot) { return true }

    return isSubtree(root.Left, subRoot) || isSubtree(root.Right, subRoot)
}

func rec(node, sub *TreeNode) bool { 
    if node == nil && sub == nil { return true }
    if node == nil || sub == nil || node.Val != sub.Val { return false }

    return rec(node.Left, sub.Left) && rec(node.Right, sub.Right)
}