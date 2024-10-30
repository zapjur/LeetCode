/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeNodes(head *ListNode) *ListNode {
    dummy := &ListNode{}
    curr := dummy
    head = head.Next
    sum := 0

    for head != nil {
        if head.Val == 0 {
            curr.Next = head
            head.Val = sum
            sum = 0
            curr = curr.Next
        } else {
            sum += head.Val
        }

        head = head.Next
    }
    return dummy.Next
}