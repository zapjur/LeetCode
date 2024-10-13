/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

var d int

func diameterOfBinaryTree(root *TreeNode) int {
    d = 0
    rec(root)
    return d
}

func rec(node *TreeNode) int {
    if node == nil { return 0 }

    left := rec(node.Left)
    right := rec(node.Right)

    d = Max(d, left+right)

    return Max(left, right) + 1
}

func Max(a, b int) int {
    if a > b { return a }
    return b
}