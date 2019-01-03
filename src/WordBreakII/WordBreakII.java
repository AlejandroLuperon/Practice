package WordBreakII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordBreakII {
    public HashMap<String, Node> roots = new HashMap<String, Node>();
    public List<String> results = new ArrayList<String>();


    public List<String> wordBreak(String s, List<String> wordDict) {
        buildRoots(wordDict);
        navigate(s, "");
        return results;
    }

    public void buildRoots(List<String> wordDict) {
        Node currentNode = null, prevNode = null;
        for (String word : wordDict) {
            List<String> letters = Arrays.asList(word.split(""));
            for (int index = 0; index < letters.size(); index++) {
                String letter = letters.get(index);

                if (index == 0) {
                    if (!roots.containsKey(letter)){
                        currentNode = new Node(letter);
                        roots.put(letter, currentNode);
                    } else {
                        currentNode = roots.get(letter);
                    }
                } else {
                    prevNode = currentNode;
                    currentNode = currentNode.getNextStop(letter);
                    if (currentNode == null) {
                        currentNode = new Node(letter);
                        prevNode.nextStops.add(currentNode);
                    }
                }

                if (index == letters.size() - 1) {
                    currentNode.lastStop = true;
                }
            }
        }
    }

    public void navigate(String s, String segments) {
        List<String> letters = Arrays.asList(s.split(""));
        Node currentNode = null;
        String currentSubstring = "", letter = "";
        int level = 0;
        for (int index = 0; index < letters.size(); index++) {

            letter = letters.get(index);

            currentSubstring = currentSubstring + letter;
            if (index == 0) {
                if (!roots.containsKey(letter)) {
                    return;
                } else {
                    currentNode = roots.get(letter);
                }
            } else {
                currentNode = currentNode.getNextStop(letter);
                if (currentNode == null) {
                    return;
                }
            }

            if (index == letters.size() - 1) {
                if (currentNode.lastStop) {
                    segments = segments + currentSubstring;
                    results.add(segments);
                } else {
                    return;
                }
            } else {
                if (currentNode.lastStop) {
                    //Huge callstack
                    //multiple graphs?
                    navigate(s.substring(currentSubstring.length(), s.length()), segments + currentSubstring + " ");
                }
            }
        }
    }
}

/*
* Divide and conquer?
* */
