/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

import (
    "container/heap"
)

type IntHeap []int

func (h IntHeap) Len() int {return len(h)}
func (h IntHeap) Less(i, j int) bool {return h[i] < h[j]}
func (h IntHeap) Swap(i, j int) {h[i], h[j] = h[j], h[i]}
func (h *IntHeap) Push(x interface{}) {*h = append(*h, x.(int))}
func (h *IntHeap) Pop() interface{} {
    n := len(*h)
    x := (*h)[n-1]
    *h = (*h)[0:n-1]
    return x
}

func kthLargestLevelSum(root *TreeNode, k int) int64 {
    
    h := &IntHeap{}
    heap.Init(h)
    stack := []*TreeNode{root}

    for len(stack) > 0 {
        newStack := make([]*TreeNode, 0)
        currSum := 0
        for _, n := range stack {
            currSum += n.Val
            
            if n.Left != nil {
                newStack = append(newStack, n.Left)
            }
            if n.Right != nil {
                newStack = append(newStack, n.Right)
            }
        }

        heap.Push(h, currSum)
        if h.Len() > k{
            heap.Pop(h)
        } 
        stack = newStack
    }

    if k > h.Len() {
        return -1
    }

    return int64(heap.Pop(h).(int))
}