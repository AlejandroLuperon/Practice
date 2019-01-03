package LFUCache;

import java.util.HashMap;
import java.util.LinkedList;


class LFUCache {
    HashMap<Integer, LinkedList<Node>> retrievalMap = new HashMap<Integer, LinkedList<Node>>();
    HashMap<Integer, Node> nodeMap = new HashMap<Integer, Node>();
    int capacity;
    int population = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            moveNode(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
           return;
        }

        if (population == capacity && !nodeMap.containsKey(key)) {
            int i = 0;
            Node nodeToRemove;
            while (true) {
                if (retrievalMap.containsKey(i) && retrievalMap.get(i).size() > 0) {
                    nodeToRemove = retrievalMap.get(i).removeLast();
                    nodeMap.remove(nodeToRemove.key);
                    break;
                } else {
                    i++;
                }
            }
        }

        Node node;

        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.val = value;
            moveNode(node);
        } else {
            node = new Node(key, value);
            if (!retrievalMap.containsKey(0)) {
                retrievalMap.put(0, new LinkedList<Node>());
            }
            retrievalMap.get(0).addFirst(node);
            nodeMap.put(key, node);
            if (population < capacity) {
                population++;

            }
        }
    }

    private void moveNode(Node node) {
        node.retrievals++;
        retrievalMap.get(node.retrievals-1).remove(node);
        if (!retrievalMap.containsKey(node.retrievals)) {
            retrievalMap.put(node.retrievals, new LinkedList<Node>());
        }
        retrievalMap.get(node.retrievals).addFirst(node);
    }
}