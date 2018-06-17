package ImplementTrie;

import java.util.ArrayList;
import java.util.HashMap;


/**
 */

public class CurrentSubmittedSolution {
    public static void main(String[] args) {
        HashMap<String, Node> mapper = new HashMap<String, Node>();

        String test = "apple";
        ArrayList<String> words = new ArrayList<String>() {{
            add("apple");
            add("appearance");
            add("apparel");
            add("ate");
        }};

        String substring = "";
        Node current, previous;
        for (int i = 0; i < words.size(); i++) {
            for (int j = 1; j <= words.get(i).length(); j++) {
                substring = words.get(i).substring(0,j);
                System.out.println("substring: " + substring);
                if (!mapper.containsKey(substring)) {
                    current = new Node(substring);
                    mapper.put(substring, current);
                } else {
                    current = mapper.get(substring);
                }

                if (mapper.containsKey(substring.substring(0, j-1)) && !mapper.get(substring.substring(0, j-1)).words.contains(current.prefix)) {
                    previous = mapper.get(substring.substring(0, j-1));
                    previous.words.add(current.prefix);
                }
            }
        }
        System.out.println(mapper.get("a").words);
        System.out.println(mapper);
        System.out.println(mapper.size());
    }
}
