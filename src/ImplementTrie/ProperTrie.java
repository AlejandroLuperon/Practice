package ImplementTrie;

import java.util.ArrayList;


/**
 */

class ProperTrie {
    public TrieNode root = new TrieNode(null);
    /** Initialize your data structure here. */
    public ProperTrie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        String segment = "";
        TrieNode current = root;
        for (int i = 1; i <= word.length(); i++) {
            segment = word.substring(0,i);

            if (!current.containsKey(segment)) {
                current.links.add(new TrieNode(segment));
            }
            current = current.get(segment);


            if (i == word.length()) {
                current.inserted = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        String segment = "";
        for (int i = 1; i <= word.length(); i++) {
            segment = word.substring(0,i);

            if (current.containsKey(segment)) {
                current = current.get(segment);
            } else {
                return false;
            }

            if (word.length() == i) {
                if (segment.equals(current.prefix) && current.inserted) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        String segment = "";
        for (int i = 1; i <= prefix.length(); i++) {
            segment = prefix.substring(0,i);

            if (current.containsKey(segment)) {
                current = current.get(segment);
            } else {
                return false;
            }

            if (prefix.length() == i) {
                if (segment.equals(current.prefix)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}

class TrieNode {
    public String prefix;
    public ArrayList<TrieNode> links = new ArrayList<TrieNode>();
    public boolean inserted = false;

    public TrieNode(String inPrefix) {
        prefix = inPrefix;
    }

    public boolean containsKey(String inPrefix) {
        for (TrieNode node : links) {
            if (node.prefix.equals(inPrefix)) {
                return true;
            }
        }
        return false;
    }

    public TrieNode get(String inPrefix) {
        for (TrieNode node : links) {
            if (node.prefix.equals(inPrefix)) {
                return node;
            }
        }
        return null;
    }
}