class MyHashMap {
    private int keySize;
    private List<Bucket> hash_table;

    public MyHashMap() {
        this.keySize = 2069;
        this.hash_table = new ArrayList<Bucket>();
        for(int i=0; i<this.keySize; i++){
            this.hash_table.add(new Bucket());
        }
    }
    
    private int generateHash(int key){
        return (key%this.keySize);
    }
    
    public void put(int key, int value) {
        int index = this.generateHash(key);
        this.hash_table.get(index).put(key, value);
    }
    
    public int get(int key) {
        int index = this.generateHash(key);
        return this.hash_table.get(index).get(key);
    }
    
    public void remove(int key) {
        int index = this.generateHash(key);
        this.hash_table.get(index).remove(key);
    }
}

class Bucket{
    private LinkedList<Pair<Integer, Integer>> container;
    
    public Bucket(){
        this.container = new LinkedList<Pair<Integer, Integer>>();
    }
    
    public void put(Integer key, Integer value){
        boolean found = false;
        for(Pair<Integer, Integer> pair: this.container){
            if(pair.first.equals(key)){
                found = true;
                pair.second = value;
                return;
            }
        }
        
        if(!found){
            this.container.add(new Pair<Integer, Integer>(key, value));
        }
    }
    
    public int get(Integer key){
        for(Pair<Integer, Integer> pair: this.container){
            if(pair.first.equals(key)){
                return pair.second;
            }
        }
        return -1;
    }
    
    public void remove(Integer key){
        for(Pair<Integer, Integer> pair: this.container){
            if(pair.first.equals(key)){
                this.container.remove(pair);
                break;
            }
        }
    }
}

class Pair<U,V>{
    public U first;
    public V second;
    
    public Pair(U first, V second){
        this.first = first;
        this.second = second;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */