package LFUCache;

public class Node {
    public Node left = null;
    public Node right = null;
    public int key;
    public int val;
    public int retrievals = 0;

    public Node(int inKey,  int inVal) {
        key = inKey;
        val = inVal;
    }
}
