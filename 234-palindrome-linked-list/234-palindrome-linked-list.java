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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode ptr2 = reverseList(mid.next);
        ListNode ptr1 = head;
        boolean isSame = true;
        while(isSame && ptr2!=null){
            if(ptr1.val!=ptr2.val)
                isSame = false;
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return isSame;
    }
    
    private ListNode getMid(ListNode head){
        ListNode sp=head, fp=head;
        while(fp.next!=null && fp.next.next!=null){
            sp = sp.next;
            fp = fp.next.next;
        }
        return sp;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}