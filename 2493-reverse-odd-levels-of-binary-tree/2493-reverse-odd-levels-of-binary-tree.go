/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func reverseOddLevels(root *TreeNode) *TreeNode {
    var reverseOdd func(*TreeNode, *TreeNode, bool)
    reverseOdd = func(root1, root2 *TreeNode, isOdd bool) {
        if root1 == nil || root2 == nil {
            return
        }
        if isOdd {
            root1.Val, root2.Val = root2.Val, root1.Val
        }
        reverseOdd(root1.Left, root2.Right, !isOdd)
        reverseOdd(root1.Right, root2.Left, !isOdd)
    }
    reverseOdd(root.Left, root.Right, true)
    return root
}