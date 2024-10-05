/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Next *Node
 *     Random *Node
 * }
 */

func copyRandomList(head *Node) *Node {

    if head == nil {
        return nil
    }
    
    nodeMap := make(map[*Node]*Node)
    node := head
    
    for node != nil {
        nodeMap[node] = &Node{Val: node.Val}
        node = node.Next
    }

    node = head

    for node != nil {
        nodeMap[node].Next = nodeMap[node.Next]
        nodeMap[node].Random = nodeMap[node.Random]
        node = node.Next
    }

    return nodeMap[head]

}