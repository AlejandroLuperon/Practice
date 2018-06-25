package LFUCache;


import java.util.HashMap;
import java.util.LinkedList;


public class LFUCache {
    HashMap<Integer, LinkedList<Node>> itsRetrievalMap = new HashMap<Integer, LinkedList<Node>>();
    HashMap<Integer, Node> itsNodeMap = new HashMap<Integer, Node>();
    int capacity;
    int population = 0;

    public LFUCache(int inCapacity) {
        capacity = inCapacity;
    }

    public int get(int key) {
        Node theNode;
        if (itsNodeMap.containsKey(key)) {
            theNode = itsNodeMap.get(key);
            theNode.retrievals++;

            itsRetrievalMap.get(theNode.retrievals-1).remove(theNode);
            if (!itsRetrievalMap.containsKey(theNode.retrievals)) {
                itsRetrievalMap.put(theNode.retrievals, new LinkedList<Node>());

            }
            itsRetrievalMap.get(theNode.retrievals).addFirst(theNode);
            
            return theNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (population == capacity && !itsNodeMap.containsKey(key)) {
            if (capacity == 0) {
                return;
            } else {
                int i = 0;
                Node theNodeToRemove;
                while (true) {
                    if (itsRetrievalMap.containsKey(i)) {
                        if (itsRetrievalMap.get(i).size() > 0) {
                            theNodeToRemove = itsRetrievalMap.get(i).removeLast();
                            itsNodeMap.remove(theNodeToRemove.key);
                            break;
                        } else {
                            i++;
                        }
                    } else {
                        i++;
                    }
                }
            }
        }

        Node theNode;

        if (itsNodeMap.containsKey(key)) {
            theNode = itsNodeMap.get(key);
            theNode.val = value;
            theNode.retrievals++;

            itsRetrievalMap.get(theNode.retrievals-1).remove(theNode);
            if (!itsRetrievalMap.containsKey(theNode.retrievals)) {
                itsRetrievalMap.put(theNode.retrievals, new LinkedList<Node>());
            }
            itsRetrievalMap.get(theNode.retrievals).addFirst(theNode);

        } else {
            theNode = new Node(key, value);
            if (!itsRetrievalMap.containsKey(0)) {
                itsRetrievalMap.put(0, new LinkedList<Node>());
            }
            itsRetrievalMap.get(0).addFirst(theNode);
            itsNodeMap.put(key, theNode);
            if (population < capacity) {
                population++;

            }
        }
    }
}
