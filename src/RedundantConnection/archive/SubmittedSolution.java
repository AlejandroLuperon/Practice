package RedundantConnection.archive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


/**
 */

public class SubmittedSolution {
    private HashMap<Integer, RedundantConnection.Node> itsNodes = new HashMap<Integer, RedundantConnection.Node>();

    private List<RedundantConnection.Edge> itsBackEdges = new ArrayList<RedundantConnection.Edge>();
    private List<RedundantConnection.Edge> itsEdges = new ArrayList<RedundantConnection.Edge>();

    public int[] findRedundantConnection(int[][] edges) {
        RedundantConnection.Node theCurrentNode = null, theCurrentNeighbor = null;
        for (int i = 0; i < edges.length; i++) {
            Integer theNodePayload = edges[i][0];
            Integer theNodeNeighborPayload = edges[i][1];

            theCurrentNode = createOrGetNode(theNodePayload);
            theCurrentNeighbor = createOrGetNode(theNodeNeighborPayload);

            itsEdges.add(new RedundantConnection.Edge(theCurrentNode, theCurrentNeighbor, i));
            theCurrentNode.getSuccessor().add(theCurrentNeighbor);
            theCurrentNeighbor.getSuccessor().add(theCurrentNode);
        }

        for (RedundantConnection.Node inNode : itsNodes.values()) {
            if (!inNode.getVisited()) {
                doDFS(inNode);
            }
        }

        itsBackEdges.forEach((inEdge -> {
            inEdge.print();
        }));


        RedundantConnection.Edge theEdgeToRemove = null;
        if (itsBackEdges.size() > 1) {
            System.out.println(itsBackEdges);
                theEdgeToRemove = itsBackEdges.stream().max((in1, in2)->{
                 return Integer.compare(in1.getSeen(), in2.getSeen());
            }).get();
                theEdgeToRemove.print();
        } else if (itsBackEdges.size() == 1) {
            theEdgeToRemove = itsBackEdges.get(0);
        } else {
            return new int[]{};
        }

        return new int[]{theEdgeToRemove.getStart().getPayload(),theEdgeToRemove.getEnd().getPayload()};
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
        inNode.setVisiting(true);
        System.out.println("Current node: " + inNode.getPayload());
        inNode.getSuccessor().forEach((inNeighbor)->{
            System.out.println("Current neighbor: " + inNeighbor.getPayload());
            if (inNode.getPayload().equals(5) && inNeighbor.getPayload().equals(3)) {
                System.out.println("D");
                System.out.println(inNeighbor.getVisiting());
                inNode.getPredecessor().forEach((inPred)->{
                    System.out.println(inPred.getPayload());
                });
            }
            inNeighbor.getPredecessor().add(inNode);
            if (!inNeighbor.getVisited()) {
                inNeighbor.parent = inNode;
                doDFS(inNeighbor);
            } else if (inNeighbor.getVisiting() && !inNode.getPredecessor().contains(inNeighbor)) {
                System.out.println("Visiting: " + inNode.getPayload() + " / Neighbor: " + inNeighbor.getPayload());

                itsBackEdges.addAll(itsEdges.stream().filter((inEdge)->{

                    return (inEdge.getStart().equals(inNode) && inEdge.getEnd().equals(inNeighbor)) || (inEdge.getStart().equals(inNeighbor) && inEdge.getEnd().equals(inNode)) ;}).collect(Collectors.toList()));
            }
        });
        System.out.println("Finished node: " + inNode.getPayload());
        inNode.setVisiting(false);
    }
}
