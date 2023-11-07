# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next or k == 0:
            return head
        
        temp = head
        size = 1

        while temp.next:
            temp = temp.next
            size += 1

        temp.next = head
        rotation = k % size
        skip = size - rotation
        last = head

        for i in range(1, skip):
            last = last.next

        head = last.next
        last.next = None

        return head

