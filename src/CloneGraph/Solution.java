package CloneGraph;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        UndirectedGraphNode zero = new UndirectedGraphNode(0);
        UndirectedGraphNode one = new UndirectedGraphNode(1);
        UndirectedGraphNode two = new UndirectedGraphNode(2);
        UndirectedGraphNode three = new UndirectedGraphNode(3);
        UndirectedGraphNode four = new UndirectedGraphNode(4);
        UndirectedGraphNode five = new UndirectedGraphNode(5);
        UndirectedGraphNode six = new UndirectedGraphNode(6);

        zero.getNeighbors().add(one);

        one.getNeighbors().add(zero);
        one.getNeighbors().add(four);
        one.getNeighbors().add(five);

        two.getNeighbors().add(three);
        two.getNeighbors().add(four);
        two.getNeighbors().add(five);

        three.getNeighbors().add(two);
        three.getNeighbors().add(six);

        four.getNeighbors().add(one);
        four.getNeighbors().add(two);

        five.getNeighbors().add(one);
        five.getNeighbors().add(two);
        five.getNeighbors().add(six);

        six.getNeighbors().add(three);
        six.getNeighbors().add(five);

        print(zero);
        resetTraversed(zero);
        UndirectedGraphNode clone = cloneGraph(zero);
        print(clone);
        /*[1],
        [0, 4, 5],
        [3, 4, 5],
        [2, 6],
        [1, 2],
        [1, 2, 6],
        [3, 5],*/
    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapper = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.addLast(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode original = queue.removeFirst();

            if (!mapper.containsKey(original)) {
                mapper.put(original, new UndirectedGraphNode(original.getLabel()));
            }

            System.out.println("Label: " + original.getLabel());

            original.getNeighbors().forEach((inNeighbor)-> {
                if (!mapper.containsKey(inNeighbor)) {
                    UndirectedGraphNode neighborClone = new UndirectedGraphNode(inNeighbor.getLabel());
                    mapper.put(inNeighbor, neighborClone);
                    mapper.get(original).getNeighbors().add(neighborClone);
                    queue.addLast(inNeighbor);
                } else {
                    mapper.get(original).getNeighbors().add(mapper.get(inNeighbor));
                }
            });
        }

        System.out.println("");
        return mapper.get(node);
    }

    public static void print(UndirectedGraphNode node) {
        //key original value copy
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.addLast(node);
        node.setVisited(true);
        while (!queue.isEmpty()) {
            UndirectedGraphNode original = queue.removeFirst();

            System.out.println("Label: " + original.getLabel());
            System.out.print("Neighbors: ");

            original.getNeighbors().forEach((inNeighbor)-> {
                System.out.print(inNeighbor.getLabel() + " ");
                if (!inNeighbor.isVisited()) {
                    inNeighbor.setVisited(true);
                    queue.addLast(inNeighbor);
                }
            });
            System.out.println("");
        }
        System.out.println(" ");
    }

    //only needed if you ever set the visited flags to true
    public static void resetTraversed(UndirectedGraphNode node) {
        //key original value copy
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.addLast(node);
        node.setVisited(false);
        while (!queue.isEmpty()) {
            UndirectedGraphNode original = queue.removeFirst();

            original.getNeighbors().forEach((inNeighbor)-> {
                if (inNeighbor.isVisited()) {
                    inNeighbor.setVisited(false);
                    queue.addLast(inNeighbor);
                }
            });
        }
    }
}
