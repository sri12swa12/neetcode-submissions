class Node{

    int val;
    int key;
    Node next; Node prev;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }

}
class LRUCache {

    Node dummyStart = new Node(0,0);
    Node dummyEnd = new Node(0,0);
    int capacity;
    Map<Integer, Node> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<Integer, Node>();
        dummyStart.next = dummyEnd;
        dummyEnd.prev = dummyStart;
    }
    
    public int get(int key) {
        Node n = cacheMap.get(key);
        if(n == null){
            return -1;
        }
           
        else{
            moveNodeToFront(n);
            return n.val;
        }
    }
    
    public void put(int key, int value) {
        Node n = cacheMap.get(key);
        if (n != null){
            n.val = value;
            moveNodeToFront(n);
        }
        else{
            Node n1 = new Node(key,value);
            cacheMap.put(key, n1);
            addNode(n1);
        }  
            int cacheSize = cacheMap.size();
            System.out.println(cacheSize);
            if (cacheSize > capacity) {
                 System.out.println("Removing");
                 Node lru = dummyEnd.prev;
                    removeNode(lru);
                    cacheMap.remove(lru.key);
            }
        
    }

 

    public void moveNodeToFront(Node n){
        removeNode(n);
        addNode(n);
    }
    public void removeNode(Node n){
        n.prev.next=n.next;
        n.next.prev=n.prev;
    }

    private void addNode(Node n){
    n.next = dummyStart.next;
    n.prev = dummyStart;

    dummyStart.next.prev = n;
    dummyStart.next = n;
}
}
