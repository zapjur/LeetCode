/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isBalanced(root *TreeNode) bool {
    if root == nil { return true }

    return rec(root) != -1
}

func rec(node *TreeNode) int {
    if node == nil { return 0 }

    l := rec(node.Left)
    r := rec(node.Right)

    if l == -1 || r == -1 { return -1 }
    if Abs(l - r) > 1 { return -1 }

    return Max(l, r) + 1
}

func Abs(num int ) int {
    if num < 0 { return num * (-1)}
    return num
}

func Max(a, b int) int {
    if a > b { return a }
    return b
}