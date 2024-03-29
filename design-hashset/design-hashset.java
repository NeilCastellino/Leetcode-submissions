class MyHashSet {
    private Bucket[] bucketArray;
    private int keyRange;

    public MyHashSet() {
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        for(int i=0; i<this.keyRange; i++){
            this.bucketArray[i] = new Bucket();
        }
    }
    
    private int generateHash(int key){
        return (key%this.keyRange);
    }
    
    public void add(int key) {
        int index = this.generateHash(key);
        this.bucketArray[index].insert(key);
    }
    
    public void remove(int key) {
        int index = this.generateHash(key);
        this.bucketArray[index].delete(key);
    }
    
    public boolean contains(int key) {
        int index = this.generateHash(key);
        return this.bucketArray[index].exists(key);
    }
}

class Bucket{
    private LinkedList<Integer> container;
    
    public Bucket(){
        this.container = new LinkedList<Integer>();
    }
    
    public void insert(Integer key){
        int index = this.container.indexOf(key);
        if(index == -1)
            this.container.addFirst(key);
    }
    
    public void delete(Integer key){
        this.container.remove(key);
    }
    
    public boolean exists(Integer key){
        int index = this.container.indexOf(key);
        return (index != -1);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */