package ImplementTrie;

import java.util.ArrayList;


public class Node {
    public String prefix;
    public ArrayList<String> words = new ArrayList<String>();
    public boolean inserted = false;

    public Node(String inPrefix) {
        prefix = inPrefix;
    }
}