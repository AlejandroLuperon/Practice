package AddAndSearchWord;

import java.util.Stack;

public class WordDictionaryBugFixes {
    public Node root = new Node(null);
    /** Initialize your data structure here. */
    public WordDictionaryBugFixes() {

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
            Stack<Node> track = new Stack<Node>() {{
                add(root);
            }};
            Stack<Node> nextTrack = new Stack<>();
            String unit = "";
            for (int i = 1; i <= word.length(); i++) {
                unit = word.substring(i-1,i);
                if (unit.equals(".")) {
                    for (Node inNode : track) {
                        for (Node inLink : inNode.links) {
                            System.out.println("Unit " + unit);
                            System.out.println("inLink.prefix " + inLink.prefix);

                            if (word.length() == i) {
                                if (inLink.inserted) {
                                    nextTrack.add(inLink);
                                }
                            } else {
                                nextTrack.add(inLink);
                            }
                        }
                    }

                    track.clear();
                    track.addAll(nextTrack);
                    nextTrack.clear();

                    if (!track.isEmpty() && i == word.length()) {
                        return true;
                    }
                } else {
                    for (Node inNode : track) {
                        for (Node inLink : inNode.links) {

                            if (inLink.prefix.substring(inLink.prefix.length()-1).equals(unit) && word.length() != i){
                                nextTrack.add(inLink);
                            }

                            if (inLink.prefix.substring(inLink.prefix.length()-1).equals(unit) && word.length() == i){
                                if (inLink.inserted) {
                                    nextTrack.add(inLink);
                                }
                            }

                        }
                    }
                    if (nextTrack.size() == 0) {
                        return false;
                    }

                    if (!nextTrack.isEmpty() && i == word.length()) {
                        return true;
                    }

                    track.clear();
                    track.addAll(nextTrack);
                    nextTrack.clear();
                }
            }
        }
        return false;
    }
}
