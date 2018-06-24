package LRUCache;


import java.util.LinkedList;


public class LRUCache {
    LinkedList<Node> itsLog = new LinkedList<Node>();
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
            itsLog.removeLast();
        }

        itsLog.addFirst(theNewNode);
    }

    public Node search(int key) {
        for (Node inNode : itsLog) {
            if (inNode.key == key) {
                return inNode;
            }
        }
        return null;
    }
}
