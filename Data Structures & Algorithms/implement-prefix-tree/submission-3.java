class PrefixTree {
    Set<String> prefixes;

    public PrefixTree() {
        this.prefixes = new HashSet<>();
    }

    public void insert(String word) {
        prefixes.add(word);
    }

    public boolean search(String word) {
        if (!word.isBlank() && prefixes.contains(word)) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        if (prefix.isBlank()) {
            return false;
        }
        for (String word : prefixes) {
            if (word.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
