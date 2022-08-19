/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node start = head;
        Node curr = start;
        
        while(curr!=null){
            if(curr.child!=null){
                Node nextNode = curr.next;
                curr.next = flatten(curr.child);
                curr.child = null;
                curr.next.prev = curr;
                while(curr.next!=null)
                    curr = curr.next;
                curr.next = nextNode;
                if(curr.next!=null)
                    curr.next.prev = curr;
            }
            curr = curr.next;
        }
        
        return start;
    }
}