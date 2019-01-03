package Graphs;

import java.util.List;

public class DepthFirstSearch {
    public void dfs(List<Node> inNodeList) {
        inNodeList.forEach((inNode) -> {
            doDFS(inNode);
        });
    }

    public void doDFS(Node inNode) {
        for (Node inNeighbor : inNode.getNeighbors()) {
//            System.out.println(inNode.getPayload() + " has " + inNeighbor.getPayload() + " as a neighbor");
            if (!inNeighbor.isVisited()) {
                System.out.println("New Node: " + inNeighbor.getPayload());
                inNeighbor.setVisited(true);
                doDFS(inNeighbor);
            }
        }
    }
}
