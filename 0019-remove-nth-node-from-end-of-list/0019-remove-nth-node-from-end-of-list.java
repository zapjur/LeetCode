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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null || head.next == null) return null;

        int cnt = 0;
        ListNode curr = head;

        while(curr != null){
            curr = curr.next;
            cnt++;
        } 
        ListNode move = head;

        if(cnt == n){
            head = move.next;
            return head;
        }

        for(int i = 1; i < cnt - n; i++){
            move = move.next;
        }

        move.next = move.next.next;


        return head;

    }
}