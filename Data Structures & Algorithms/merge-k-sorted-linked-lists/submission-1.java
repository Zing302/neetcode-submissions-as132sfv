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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        ListNode dummy=new ListNode(0,lists[0]);
        for(int i=1;i<lists.length;i++){
            dummy=mergeLists(dummy,lists[i]);
        }
        return dummy.next;
    }

    private ListNode mergeLists(ListNode dummy, ListNode nextList){
        ListNode curr=dummy.next;
        ListNode tail=dummy;
        while(curr!=null && nextList!=null){
            if(curr.val <= nextList.val){
                dummy.next=curr;
                curr=curr.next;
            }else{
                dummy.next=nextList;
                nextList=nextList.next;
            }
            dummy=dummy.next;
        }
        if(curr!=null){
            dummy.next=curr;
        }else if(nextList!=null){
            dummy.next=nextList;
        }
        return tail;
    }
}

