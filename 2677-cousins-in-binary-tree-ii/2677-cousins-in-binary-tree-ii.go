/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func replaceValueInTree(root *TreeNode) *TreeNode {

    root.Val = 0
    if root.Left != nil {
        root.Left.Val = 0
    }
    if root.Right != nil {
        root.Right.Val = 0
    }

    stack := []*TreeNode{root}

    for len(stack) > 0 {
        newStack := make([]*TreeNode, 0)
        currSum := 0
        for _, n := range stack {
            
            if n.Left != nil {
                currSum += n.Left.Val
                newStack = append(newStack, n.Left)
            }
            if n.Right != nil {
                currSum += n.Right.Val
                newStack = append(newStack, n.Right)
            }
        }

        for _, n := range stack {

            childSum := 0

            if n.Left != nil {
                childSum += n.Left.Val
            }
            if n.Right != nil {
                childSum += n.Right.Val
            }

            if n.Left != nil {
                n.Left.Val = currSum - childSum
            }
            if n.Right != nil {
                n.Right.Val = currSum - childSum
            }


        }

        stack = newStack
    }

    return root
}
