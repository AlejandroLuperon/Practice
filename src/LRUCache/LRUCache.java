package LRUCache;


import java.util.HashMap;
import java.util.LinkedList;


public class LRUCache {
    LinkedList<Node> itsLog = new LinkedList<Node>();
    HashMap<Integer, Node> itsQuickRetrievalMap = new HashMap<Integer, Node>();
    int itsCapacity;
    public LRUCache(int capacity) {
        itsCapacity = capacity;
    }

    public int get(int key) {
        Node theNode = search(key);
        if (theNode != null) {
            itsLog.remove(theNode);
            itsLog.addFirst(theNode);
            return theNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        //Does key already exist?
        Node theNode = search(key);
        if (theNode != null) {
            theNode.value = value;
            itsLog.remove(theNode);
            itsLog.addFirst(theNode);
            return;
        }

        Node theNewNode = new Node(key, value);

        if (itsCapacity == itsLog.size()) {
            Node theLastNode = itsLog.removeLast();
            itsQuickRetrievalMap.remove(theLastNode.key);
        }

        itsQuickRetrievalMap.put(key, theNewNode);
        itsLog.addFirst(theNewNode);
    }

    public Node search(int key) {
        if (itsQuickRetrievalMap.containsKey(key)) {
            return itsQuickRetrievalMap.get(key);
        }

        return null;
    }
}
