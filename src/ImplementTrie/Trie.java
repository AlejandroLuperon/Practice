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

            if (j == word.length() && mapper.containsKey(substring.substring(0, j-1)) && !mapper.get(substring.substring(0, j-1)).words.contains(current.prefix)) {
                previous = mapper.get(substring.substring(0, j-1));
                previous.words.add(current.prefix);
            }
        }
    }

    public boolean search(String word) {
        if (word.length() == 1) {
            return mapper.containsKey(word);
        }
        return (mapper.containsKey(word.substring(0, word.length()-1)) &&  mapper.get(word.substring(0, word.length()-1)).words.contains(word)) ;
    }

    public boolean startsWith(String prefix) {
        return mapper.containsKey(prefix);
    }
}
