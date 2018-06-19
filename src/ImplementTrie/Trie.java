package ImplementTrie;

import java.util.HashMap;


/**
 */

public class Trie {
    public HashMap<String, Node> mapper = new HashMap<String, Node>();

    public Trie() {

    }

    public void insert(String word) {
        String substring = "";
        Node current, previous;
        for (int j = 1; j <= word.length(); j++) {
            substring = word.substring(0,j);
            if (!mapper.containsKey(substring)) {
                current = new Node(substring);
                mapper.put(substring, current);
            } else {
                current = mapper.get(substring);
            }

            if (j == word.length()) {
                current.inserted = true;
            }
        }
    }

    public boolean search(String word) {
        return mapper.containsKey(word) && mapper.get(word).inserted ;
    }

    public boolean startsWith(String prefix) {
        return mapper.containsKey(prefix);
    }
}
