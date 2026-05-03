class PrefixTree {
    public PrefixTree() {
        this.root = new Node();
    }

    Node root;

    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node current = root;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (current.nodes[ch - 'a'] == null) {
                current.nodes[ch - 'a'] = new Node();
                current = current.nodes[ch - 'a'];
            } else {
                current = current.nodes[ch - 'a'];
            }
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node current = root;

        for (int i = 0; i < chars.length; i++) {
            if (current.nodes[chars[i] - 'a'] == null) {
                return false;
            }
            Node node = current.nodes[chars[i] - 'a'];
            if (i == chars.length - 1 && node.isWord) {
                return true;
            }
            current = node;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node current = root;

        for (char ch : chars) {
            if (current.nodes[ch - 'a'] == null) {
                return false;
            } else {
                current = current.nodes[ch - 'a'];
            }
        }
        return true;
    }

    class Node {
        public Node() {}
        Node[] nodes = new Node[26];
        boolean isWord = false;
    }
}
