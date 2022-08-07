public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val=x;
    }
}

class MyLinkedList {
    
    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }
    
    public int get(int index) {
        if(index<0 || index>=size)
            return -1;
        
        ListNode cur = head;
        for(int i=0; i<=index; i++){
            cur = cur.next;
        }
        
        return cur.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size)
            return;
        
        if(index<0)
            index = 0;
        
        size++;
        
        ListNode pred = head;
        for(int i = 0; i<index; i++)
            pred = pred.next;
        
        ListNode cur = new ListNode(val);
        cur.next = pred.next;
        pred.next = cur;
    }
    
    public void deleteAtIndex(int index) {
        if(index>=size || index<0)
            return;
        
        size--;
        
        ListNode prev = head;
        for(int i=0; i<index; i++)
            prev = prev.next;
        
        prev.next = prev.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */