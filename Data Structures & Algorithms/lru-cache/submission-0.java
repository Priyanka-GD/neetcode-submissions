class LRUCache {
    Map<Integer, Node> mapOfNodes;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        mapOfNodes = new HashMap<>();
    }

    public void updateNode(Node node){
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if(mapOfNodes.containsKey(key)){
            Node node = mapOfNodes.get(key);
            removeNode(node);
            updateNode(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(mapOfNodes.containsKey(key)){
            Node node = mapOfNodes.get(key);
            removeNode(node);
            node.value = value;
            updateNode(node);
        }else{
            if(mapOfNodes.size() == capacity){
                Node node = tail.prev;
                removeNode(node);
                mapOfNodes.remove(node.key);
            }
            Node node = new Node(key, value);
            updateNode(node);
            mapOfNodes.put(key, node);
        }
    }
}

class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
