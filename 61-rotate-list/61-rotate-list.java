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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next==null)
            return head;
        
        int size = 0;
        ListNode curr = head;
        while(curr!=null){
            curr=curr.next;
            size++;
        }
        
        k=k%size;
        size -= k+1;
        curr = head;
        
        if(k==0){
            return head;
        }
        
        while(size>0){
            curr=curr.next;
            size--;
        }
        
        ListNode nextNode = curr.next;
        curr.next = null;
        ListNode newHead = nextNode;
        while(nextNode!=null && nextNode.next!=null)
            nextNode = nextNode.next;
        nextNode.next = head;
        
        return newHead;
    }
}