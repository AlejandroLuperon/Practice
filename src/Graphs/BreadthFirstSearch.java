package Graphs;

import java.util.LinkedList;

public class BreadthFirstSearch {
    public void bfs(Node inRoot) {
        LinkedList<Node> queue = new LinkedList<Node>();

        queue.add(inRoot);

        while (!queue.isEmpty()) {
            Node theCurrentNode = queue.removeFirst();
            for (Node theNeighbor : theCurrentNode.getNeighbors()) {
                System.out.println(theCurrentNode.getPayload() + " has " + theNeighbor.getPayload() + " as a neighbor");
                if (!theNeighbor.isVisited()) {
                    theNeighbor.setVisited(true);
                    queue.addLast(theNeighbor);
                }
            }
        }
    }
}
