/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-400);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy.next;

        ListNode prev = dummy;

        while(fast != null){
            if(fast.val == slow.val){
                while(fast != null && fast.val == slow.val){
                    fast = fast.next;
                }
                slow = prev;
                slow.next = fast;
            }
            prev = slow;
            slow = slow.next;
            if(fast != null){
                fast = fast.next;
            }
        
        }
        return dummy.next;
    }
}