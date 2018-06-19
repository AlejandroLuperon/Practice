package AddAndSearchWord;

import java.util.Stack;


/**
 */

public class WordDictionary {
    public Node root = new Node(null);
    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node current = root;

        for (int i = 1; i <= word.length(); i++) {
            String segment = word.substring(0, i);
            if (!current.containsKey(segment)) {
                current.links.add(new Node(segment));
            }
            current = current.get(segment);

            if (word.length() == i) {
                current.inserted = true;
            }
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (!word.contains(".")) {
            Node current = root;
            String segment = "";
            for (int i = 1; i <= word.length(); i++) {
                segment = word.substring(0, i);

                if (current.containsKey(segment)){
                    current = current.get(segment);
                } else {
                    return false;
                }

                if (i == word.length()) {
                    if (current.prefix.equals(word) && current.inserted) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            Stack<Node> track = new Stack<Node>();
            Stack<Node> nextTrack = new Stack<>();
            Node current = root;
            String segment = "";
            String unit = "";
            for (int i = 1; i <= word.length(); i++) {
                unit = word.substring(i-1,i);
                segment = word.substring(0, i);

                if (i == word.length()) {
                    if (track.size() > 0) {//Condition is alredy evaluated previously
                        return true;
                    }
                }

                if (unit.equals(".")) {
                    track.clear();
                    for (Node link : current.links) {
                        track.add(link);
                    }
                } else {
                    while (!track.isEmpty()) {
                        current = track.pop();
                        if (current.containsKey(segment)){
                             current = current.get(segment);
                             nextTrack.add(current);
                        }
                    }
                    if (nextTrack.size() == 0) {
                        return false;
                    }
                    track = nextTrack;
                }
            }
        }
        return false;
    }
}
