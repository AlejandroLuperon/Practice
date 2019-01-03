package WordBreakII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordBreakIIUsingSegments {
    public HashMap<String, Node> roots = new HashMap<String, Node>();
    public List<String> results = new ArrayList<String>();
    public HashMap<String, Segment> segments = new HashMap<String, Segment>();
    public boolean bypass = false;

    public List<String> wordBreak(String s, List<String> wordDict) {
        buildRoots(wordDict);
        navigate(s, new Segment());
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

    public void navigate(String s, Segment segment) {
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
                    if (segment.occurrences.containsKey(currentSubstring)) {
                        segment.occurrences.put(currentSubstring, segment.occurrences.get(currentSubstring) + 1);
                    } else {
                        segment.occurrences.put(currentSubstring, 1);
                    }

                    ArrayList<String> result = new ArrayList<String>();

                    for (String key : segment.occurrences.keySet()) {
                        for (int i = 0; i < segment.occurrences.get(key); i++) {
                            result.add(key);
                        }
                    }
                    results.add(String.join(" " ,result));
                } else {
                    return;
                }
            } else {
                if (currentNode.lastStop) {
                    //Huge callstack
                    //multiple graphs?

                    for (Segment cachedSegment : segments.values()) {
                        if (cachedSegment.equals(segment.occurrences)) {
                            bypass = true;
                            break;
                        }
                    }

                    if (bypass) {
                        bypass = false;
                        continue;
                    }

                    if (segment.occurrences.containsKey(currentSubstring)) {
                          segment.occurrences.put(currentSubstring, segment.occurrences.get(currentSubstring) + 1);
                      } else {
                          segment.occurrences.put(currentSubstring, 1);
                      }

                    segments.put(s.substring(currentSubstring.length(), s.length()), segment);
                    navigate(s.substring(currentSubstring.length(), s.length()), segment);
                }
            }
        }
    }
}

/*
* Divide and conquer?
* */
