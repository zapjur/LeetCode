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
    public int getDecimalValue(ListNode head) {
        int size = -1;
        int sum = 0;

        for(ListNode temp = head; temp != null; temp = temp.next) size++;

        ListNode curr = head;

        while(curr != null){
            sum += curr.val * (Math.pow(2, size--));
            curr = curr.next;
        }

        return sum;
    }
}