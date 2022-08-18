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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode start = head;
        
        
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                start.next=list1;
                start=start.next;
                list1=list1.next;
            }else{
                start.next=list2;
                start=start.next;
                list2=list2.next;
            }
        }
        if(list1!=null){
            start.next = list1;
        }
        if(list2!=null){
            start.next = list2;
        }
        return head.next;
    }
}