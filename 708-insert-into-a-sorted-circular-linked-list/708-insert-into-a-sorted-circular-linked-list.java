/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if(head==null){
            newNode.next = newNode;
            return newNode;
        }
        
        Node curr = head;
        while(curr.next!=head){
            if(curr.val<=insertVal && insertVal<= curr.next.val){
                break;
            }else if(curr.val>curr.next.val){
                if(curr.val<=insertVal && curr.next.val<=insertVal){
                    break;
                }
                if(curr.val>=insertVal && curr.next.val>=insertVal){
                    break;
                }
            }
            curr=curr.next;
        }
        Node next = curr.next;
        curr.next = newNode;
        curr = curr.next;
        curr.next = next;
        
        return head;
    }
}