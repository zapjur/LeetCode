/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var res [][]int

func levelOrder(root *TreeNode) [][]int {
    res = [][]int{}

    if root == nil { return res }

    rec(root, 0)
    return res

}

func rec(node *TreeNode, l int) {
    if node == nil { return }

    if len(res) == l {
        res = append(res, []int{}) 
    }

    res[l] = append(res[l], node.Val)

    rec(node.Left, l+1)
    rec(node.Right, l+1)
}