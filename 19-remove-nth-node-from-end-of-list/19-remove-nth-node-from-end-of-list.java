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
        ListNode start = new ListNode(0);
        start.next = head;
        
        int count = 0;
        ListNode lastNode = head;
        
        while(lastNode!=null){
            lastNode = lastNode.next;
            count++;
        }
        
        lastNode = start;
        count-=n;
        
        while(count>0){
            lastNode = lastNode.next;
            count--;
        }
        lastNode.next = lastNode.next.next;
        
        return start.next;
    }
}