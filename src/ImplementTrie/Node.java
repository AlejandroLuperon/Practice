package ImplementTrie;

import java.util.ArrayList;


public class Node {
    public String prefix;
    public ArrayList<String> words = new ArrayList<String>();

    public Node(String inPrefix) {
        prefix = inPrefix;
    }
}