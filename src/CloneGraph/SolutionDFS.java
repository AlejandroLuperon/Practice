package CloneGraph;

import java.util.HashMap;
import java.util.LinkedList;

class SolutionDFS {
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

        //printBFS(zero);
        //resetTraversed(zero);
        UndirectedGraphNode clone = cloneGraph(zero);
        printBFS(clone);
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

        //Do DFS
        doDFS(node, mapper);

        return mapper.get(node);
    }

    private static void doDFS(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> mapper) {
        if (!mapper.containsKey(node)) {
            UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
            mapper.put(node, clone);
        }
        System.out.println("Current Label: " + node.label);
        node.neighbors.forEach((inNeighbor)-> {
           if (!mapper.containsKey(inNeighbor)) {
               UndirectedGraphNode neighborClone = new UndirectedGraphNode(inNeighbor.label);
               mapper.put(inNeighbor, neighborClone);
               mapper.get(node).neighbors.add(neighborClone);
               doDFS(inNeighbor, mapper);
           } else {
               mapper.get(node).neighbors.add(mapper.get(inNeighbor));
           }
        });
    }

    public static void printBFS(UndirectedGraphNode node) {
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
