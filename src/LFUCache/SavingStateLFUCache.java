package LFUCache;

import java.util.HashMap;


/**
 */

public class SavingStateLFUCache {
    HashMap<Integer, Node> itsRetrievalMap = new HashMap<Integer, Node>();
    int capacity;
    int population = 0;
    Node head;
    Node tail;

    public SavingStateLFUCache(int inCapacity) {
        capacity = inCapacity;
    }

    public int get(int key) {
        Node theNode = search(key);
        //System.out.println("Get: " + key);
        if (theNode != null) {
            theNode.retrievals++;
            if (theNode.right != null) {
                //System.out.println("Value of " + theNode.key + ": " +  theNode.retrievals);
                //System.out.println("Value of " + theNode.right.key + ": " +  theNode.right.retrievals);

                if (theNode.right.retrievals <= theNode.retrievals) {
                    if (theNode != tail) {
                        theNode.right.left = theNode.left;
                    } else {
                        tail = theNode.right;
                    }
                    if (theNode.right != head) {
                        theNode.right.right.left = theNode;
                    } else {
                        head = theNode;
                    }

                    theNode.right.right = theNode;
                    theNode.left = theNode.right;
                    theNode.left.right = theNode.right;
                    theNode.right = theNode.right.right;

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
        //System.out.println(key + " is getting put");
        Node theNode = search(key);
        if (theNode != null) {
            theNode.val = value;
            refresh(theNode);
            return;
        } else {
            theNode = new Node(key, value);
            itsRetrievalMap.put(key, theNode);
        }

        //System.out.println("population: " + population);
        //System.out.println("capacity: " + capacity);
        //System.out.println("itsRetrievalMapSize: " + itsRetrievalMap.size());

        if (population == capacity) {
            //System.out.println(tail.key + " is getting evicted");
            /*System.out.println(itsRetrievalMap);

            System.out.println("the Node: " + theNode.key);
            System.out.println("the tail: " + tail.key);*/

            itsRetrievalMap.remove(tail.key);

            if (capacity == 1) {
                head = theNode;
                tail = theNode;
                return;
            }
            //System.out.println(itsRetrievalMap);

            if (tail.retrievals == 0) {
                Node theCurrentNext = tail;

                /*while (theCurrentNext.retrievals == 0) {
                    System.out.println("theCurrentNext " + theCurrentNext.key);
                    theNode.right = theCurrentNext.right;
                    theNode.left = theCurrentNext;
                    theCurrentNext.right = theNode;
                    theCurrentNext.right.left = theNode;
                    if (theCurrentNext.left != null) {
                        theCurrentNext.left.right = theNode;
                        theCurrentNext.left = theNode.left;
                    } else {
                        tail = theNode.left;
                    }

                    System.out.println(theNode.right);
                    if (theNode.right != null) {
                        System.out.println(theNode.right.retrievals);
                        theCurrentNext = theNode.right;
                    } else {
                        head = theNode;
                        head.right = null;
                        System.out.println("the new head: " + head.key);
                        break;
                    }
                }*/

            } else {
                tail.right.left = theNode;
                theNode.right = tail.right;
                tail = theNode;
                tail.left = null;
            }

             //System.out.println("the new tail: " + tail.key);
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
            } else {
                theNode.right = tail;
                tail.left = theNode;
                tail = theNode;
            }
            tail.left = null;
            //System.out.println("the tail is now: " + tail.key);
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
        if (inNode == head) {
            return;
        }
        Node theCurrentNext = inNode.right;
        int i = 0;
        while (theCurrentNext != null && theCurrentNext.retrievals == inNode.retrievals && i < 5) {
            System.out.println("current pop: " + population);
            System.out.println("theCurrentNext " + theCurrentNext.key);
            System.out.println("theCurrentNext.right " + theCurrentNext.right);

            System.out.println("theCurrentNext.right " + theCurrentNext.right);

            if (theCurrentNext.right != null) {
                theCurrentNext.right.left = inNode;
                inNode.right = theCurrentNext.right;
                System.out.println("BUR");
            } else {
                head = inNode;
                head.right = null;
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
                System.out.println("d ");
                System.out.println("inNode right is: " + inNode.right.key);
                System.out.println(inNode.right.retrievals);
                theCurrentNext = inNode.right;
            } else {
                System.out.println("theCu");
                head = inNode;
                head.right = null;
                System.out.println("the new head: " + head.key);
                System.out.println("the new tail: " + tail.key);
                break;
            }
            i++;
        }
    }
}
