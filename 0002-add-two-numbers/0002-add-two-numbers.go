/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {

    res := &ListNode{Val: 0}
    curr := res
    carry := 0

    for l1 != nil || l2 != nil || carry == 1 {

        sum := 0

        if l1 != nil {
            sum += l1.Val
            l1 = l1.Next
        }

        if l2 != nil {
            sum += l2.Val
            l2 = l2.Next
        }

        sum += carry
        carry = sum / 10
        node := &ListNode{Val: sum%10}
        curr.Next = node
        curr = curr.Next

    }

    return res.Next

}