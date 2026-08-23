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
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>((a,b) -> Integer.compare(a.val,b.val));
        for(ListNode list:lists){
            if(list!=null){
                pq.add(list);
            }
        }
        while(!pq.isEmpty()){
            ListNode temp=pq.remove();
            curr.next=temp;
            temp=temp.next;
            curr=curr.next;
            if(temp!=null){
                pq.add(temp);
            }  
        }
        return dummy.next; 
    }
}

