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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode prevGroup = dummy;
        ListNode nextK;
        do{
            nextK = nextKGroup(prevGroup, k);
            if(nextK == null){
                break;
            }
            ListNode curr = prevGroup.next;
            ListNode prev = nextK.next;
            ListNode kNext = nextK.next;
            while(curr != kNext){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode temp = prevGroup.next;
            prevGroup.next = prev;
            prevGroup = temp;
        }while(nextK != null);
        
        return dummy.next;
    }

    private ListNode nextKGroup(ListNode curr, int k){
        while(curr!=null && k > 0){
            curr=curr.next;
            k--;
        }
        return curr;
    }
}
