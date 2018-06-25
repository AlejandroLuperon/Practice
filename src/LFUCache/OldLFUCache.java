package LFUCache;

import java.util.HashMap;


/**
 */

public class OldLFUCache {
    HashMap<Integer, Node> itsRetrievalMap = new HashMap<Integer, Node>();
    int capacity;
    int population = 0;
    Node head;
    Node tail;

    public OldLFUCache(int inCapacity) {
        capacity = inCapacity;
    }

    public int get(int key) {
        Node theNode = search(key);
        //System.out.println("Get: " + key);
        if (theNode != null) {
            theNode.retrievals++;
            //System.out.println("BLUR");
            refresh(theNode);
            //TODO: Work on section below
            if (theNode.right != null) {
                if (theNode.right.retrievals <= theNode.retrievals) {
                    if (theNode != tail) {
                        if (theNode.left.left != null) {
                             theNode.left.left.right = theNode;
                         }
                        theNode.left.right = theNode.right;
                        theNode.left = theNode.right;
                    } else {

                        theNode.left = theNode.right;
                        theNode.right.right = theNode;
                        theNode.right.left = null; tail.left = null;
                        tail = theNode.right;
                    }

                    if (theNode.right != head) {
                        if (theNode.right.right != null) {
                            theNode.right.right.left = theNode;
                        }
                        theNode.right.left = theNode.left;
                        theNode.right.right = theNode;
                        theNode.right = theNode.right.right;
                    } else {
                        head = theNode;
                        head.right = null;
                    }






                }
            }
            return theNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node theNode = search(key);
        if (theNode != null) {
            theNode.val = value;
            refresh(theNode);
            return;
        } else {
            theNode = new Node(key, value);
            itsRetrievalMap.put(key, theNode);
        }


        if (population == capacity) {


            itsRetrievalMap.remove(tail.key);

            if (capacity == 1) {
                head = theNode;
                tail = theNode;
                return;
            }
            tail.right.left = theNode;
            theNode.right = tail.right;
            tail = theNode;
            tail.left = null;
            refresh(tail);
            return;
        }

        if (head == null) {
            head = theNode;
            tail = theNode;
        } else {
            if (population > 1) {
                tail.right.left = theNode;
                theNode.right = tail.right;
                tail = theNode;
                refresh(theNode);
            } else {
                theNode.right = tail;
                tail.left = theNode;
                tail = theNode;
            }
            tail.left = null;
        }
        population++;
    }

    public Node search(int key) {
        if (itsRetrievalMap.containsKey(key)) {
            return itsRetrievalMap.get(key);
        }
        return null;
    }

    public void refresh(Node inNode) {
       // System.out.println("refresh called");
        if (inNode == head) {
            return;
        }
        //System.out.println("ZING");
        //System.out.println("inNode " + inNode.key);
        Node theCurrentNext = inNode.right;
        int i = 0;
        while (theCurrentNext != null && theCurrentNext.retrievals == inNode.retrievals && theCurrentNext.key != inNode.key) {
            if (theCurrentNext.right != null) {
                theCurrentNext.right.left = inNode;
                inNode.right = theCurrentNext.right;
            }

            if (inNode.left == null) {
                tail = theCurrentNext;
            }
            theCurrentNext.right = inNode;
            theCurrentNext.left = inNode.left;
            inNode.left = theCurrentNext;


            if (theCurrentNext.left != null) {
                theCurrentNext.left.right = inNode;
                theCurrentNext.left = inNode.left;
            } else {
                tail = inNode.left;
                tail.left = null;
            }

            if (inNode.right != null) {
                theCurrentNext = inNode.right;
            } else {

                head = inNode;
                head.right = null;
                break;
            }
            i++;
        }
    }
}
