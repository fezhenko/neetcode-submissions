class LRUCache {
    private Map<Integer, Node> keyToNode;
    private Node mru;
    private Node lru;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyToNode = new HashMap<>(capacity);
        this.mru = new Node(-1, -1);
        this.lru = new Node(-1, -1);
        lru.next = mru;
        mru.prev = lru;
    }

    public int get(int key) {
        Node node = keyToNode.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (keyToNode.containsKey(key)) {
            remove(keyToNode.get(key));
        }
        Node newNode = new Node(key, value);
        keyToNode.put(key, newNode);
        insert(newNode);

        if (keyToNode.size() > capacity) {
            Node toDelete = lru.next;
            remove(toDelete);
            keyToNode.remove(toDelete.key);
        }
    }

    private void remove(Node node) {
        if (node == null) {
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.prev = mru.prev;
        node.prev.next = node;
        node.next = mru;
        mru.prev = node;
    }

    class Node {
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        private int key;
        private int value;
        private Node prev;
        private Node next;
    }
}
