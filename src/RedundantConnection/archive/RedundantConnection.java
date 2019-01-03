/*package RedundantConnection.archive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class RedundantConnection {
    private HashMap<Integer, RedundantConnection.Node> itsNodes = new HashMap<Integer, RedundantConnection.Node>();
    private List<ArrayList<Integer>> itsBackEdges = new ArrayList<ArrayList<Integer>>();

    public List<ArrayList<Integer>> findRedundantConnection(int[][] edges) {
        RedundantConnection.Node theCurrentNode = null, theCurrentNeighbor = null;
        for (int i = 0; i < edges.length; i++) {
            Integer theNodePayload = edges[i][0];
            Integer theNodeNeighborPayload = edges[i][1];

            theCurrentNode = createOrGetNode(theNodePayload);
            theCurrentNeighbor = createOrGetNode(theNodeNeighborPayload);

            theCurrentNode.getSuccessor().add(theCurrentNeighbor);
        }

        for (RedundantConnection.Node inNode : itsNodes.values()) {
            if (!inNode.getVisited()) {
                doDFS(inNode);
            }
        }
        System.out.println(itsBackEdges);

        return itsBackEdges;
    }

    private RedundantConnection.Node createOrGetNode(Integer inNodePayload) {
        if (itsNodes.containsKey(inNodePayload)) {
            return itsNodes.get(inNodePayload);
        } else {
            RedundantConnection.Node theNode = new RedundantConnection.Node(inNodePayload);
            itsNodes.put(inNodePayload, theNode);
            return theNode;
        }
    }

    private void doDFS(RedundantConnection.Node inNode) {
        inNode.setVisited(true);
        inNode.getSuccessor().forEach((inNeighbor)->{
            inNeighbor.getPredecessor().add(inNode);
            if (!inNeighbor.getVisited()) {
                doDFS(inNeighbor);
            } else {
                ArrayList<Integer> theBackEdge = new ArrayList<Integer>();
                theBackEdge.add(inNode.getPayload());
                theBackEdge.add(inNeighbor.getPayload());
                itsBackEdges.add(theBackEdge);
            }
        });
    }
}*/
