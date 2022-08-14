/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private ListNode getIntersect(ListNode head){
        ListNode sp = head;
        ListNode fp = head;
        
        while(fp!=null && fp.next!=null){
            sp=sp.next;
            fp=fp.next.next;
            if(sp==fp)
                return sp;
        }
        
        return null;
    }
    
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        
        ListNode ptr1 = getIntersect(head);
        
        if(ptr1 == null)
            return null;
        
        ListNode ptr2 = head;
        while(ptr1!=ptr2){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return ptr1;
    }
}