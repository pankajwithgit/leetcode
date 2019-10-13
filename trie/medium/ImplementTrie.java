class Trie {
    TrieNode root;
    
    // Each trie node can only contains 'a'-'z' characters. So we can use a small array to store the character. Array index will signify the char.
    public class TrieNode {
        TrieNode[] arr;
        boolean endOfWord;
        
        public TrieNode(){
            arr = new TrieNode[26];
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            // check if children array contains c
            if(current.arr[index] != null) {
                current = current.arr[index];
            } else {
                // create a new node if not already there
                TrieNode node = new TrieNode();
                current.arr[index] = node;
                current = node;
            }
        }
        current.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        if(node == null) {
            return false;
        }
        return node.endOfWord;
    }
    
    private TrieNode searchNode(String word) {
        if(word.isEmpty()) return null;
        
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(current.arr[index] != null) {
                current = current.arr[index];
            } else {
                return null;
            }
        }
        return current;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
