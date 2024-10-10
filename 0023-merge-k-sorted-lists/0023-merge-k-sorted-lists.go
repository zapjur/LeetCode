/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeKLists(lists []*ListNode) *ListNode {
    
    if len(lists) == 0 {
        return nil
    }

    for len(lists) > 1 {
        l1 := lists[0]
        l2 := lists[1]
        lists = lists[2:]

        merged := MergeTwoLists(l1, l2)
        lists = append(lists, merged)
    }

    return lists[0]

}

func MergeTwoLists(l1, l2 *ListNode) *ListNode {
    dummy := &ListNode{}
    node := dummy

    for l1 != nil || l2 != nil {
        if l1 != nil && (l2 == nil || l1.Val < l2.Val) {
            node.Next = l1
            l1 = l1.Next
        } else {
            node.Next = l2
            l2 = l2.Next
        }
        node = node.Next
    }

    return dummy.Next

}