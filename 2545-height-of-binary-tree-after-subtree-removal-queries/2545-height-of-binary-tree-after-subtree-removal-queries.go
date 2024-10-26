/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func findHeightOfNodes(root *TreeNode, l int, height, levelMaxHeight, levelSecondMaxHeight, level []int) int{

    if root == nil {
        return 0
    }

    level[root.Val] = l
    height[root.Val] = max(findHeightOfNodes(root.Left, l+1, height, levelMaxHeight,              levelSecondMaxHeight, level), findHeightOfNodes(root.Right, l+1, height, levelMaxHeight, levelSecondMaxHeight, level)) + 1


    if levelMaxHeight[l] < height[root.Val]{
        levelSecondMaxHeight[l] = levelMaxHeight[l]
        levelMaxHeight[l] = height[root.Val]
    } else if levelSecondMaxHeight[l] < height[root.Val]{
        levelSecondMaxHeight[l] = height[root.Val]
    }

    return height[root.Val]
}
func treeQueries(root *TreeNode, queries []int) []int {
    const n = 1000001
    height := make([]int, n)
    levelMaxHeight := make([]int, n)
    levelSecondMaxHeight := make([]int, n)
    level := make([]int, n)

    findHeightOfNodes(root, 0, height, levelMaxHeight, levelSecondMaxHeight, level)

    ans := make([]int, len(queries))

    for i, query := range queries{
        levelOfNode := level[query]

        if levelMaxHeight[levelOfNode] == height[query]{ 
            ans[i] = levelOfNode + levelSecondMaxHeight[levelOfNode] - 1
        }else{
            ans[i] = levelOfNode + levelMaxHeight[levelOfNode] - 1
        }
    }

    return ans
}