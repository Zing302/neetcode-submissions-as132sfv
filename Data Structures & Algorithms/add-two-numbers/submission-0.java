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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1=l1;
        ListNode curr2=l2;
        ListNode sum=new ListNode(0,null);
        ListNode curr=sum;
        int carry=0;
        while(curr1!=null || curr2!=null){
            int s = carry;
            if(curr1!=null){
                s += curr1.val;
                curr1= curr1.next;
            }
            if(curr2!=null){
                s += curr2.val;
                curr2 = curr2.next;
            }
            curr.next = new ListNode(s %10,null);
            carry = s / 10;
            curr=curr.next;
        }
        if(carry !=0){
            curr.next = new ListNode(carry);
        }
        return sum.next;
    }
}
