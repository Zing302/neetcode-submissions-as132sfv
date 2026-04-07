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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondHalf=slow.next;
        slow.next=null;
        ListNode curr=null;
        while(secondHalf!=null){
            ListNode temp=secondHalf.next;
            secondHalf.next=curr;
            curr=secondHalf;
            secondHalf=temp;
        }
        secondHalf=curr;
        ListNode first=head;
        while(secondHalf!=null){
            ListNode temp=first.next;
            ListNode tempTwo=secondHalf.next;
            first.next=secondHalf;
            secondHalf.next=temp;
            first=temp;
            secondHalf=tempTwo;
        }

        
    }
}
