package RedundantConnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class RedundantConnection {
    private HashMap<Integer, Node> itsNodes = new HashMap<Integer, Node>();

    private List<Edge> itsBackEdges = new ArrayList<Edge>();
    private List<Edge> itsEdges = new ArrayList<Edge>();

    public int[] findRedundantConnection(int[][] edges) {
           Node theCurrentNode = null, theCurrentNeighbor = null;
           for (int i = 0; i < edges.length; i++) {
               Integer theNodePayload = edges[i][0];
               Integer theNodeNeighborPayload = edges[i][1];

               theCurrentNode = createOrGetNode(theNodePayload);
               theCurrentNeighbor = createOrGetNode(theNodeNeighborPayload);

               itsEdges.add(new Edge(theCurrentNode, theCurrentNeighbor, i));
               theCurrentNode.getSuccessor().add(theCurrentNeighbor);
               theCurrentNeighbor.getSuccessor().add(theCurrentNode);
           }


           for (Node inNode : itsNodes.values()) {
               if (!inNode.getVisited()) {
                   if (inNode.getSuccessor().size() > 0) {
                       inNode.getSuccessor().get(0).parent = inNode;
                       doDFS(inNode, inNode.getSuccessor().get(0));
                   } else {
                       inNode.setVisited(true);
                   }
               }
           }

           itsBackEdges.forEach((inEdge -> {
               inEdge.print();
           }));


           Edge theEdgeToRemove = null;
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


    private Node createOrGetNode(Integer inNodePayload) {
        if (itsNodes.containsKey(inNodePayload)) {
            return itsNodes.get(inNodePayload);
        } else {
            Node theNode = new Node(inNodePayload);
            itsNodes.put(inNodePayload, theNode);
            return theNode;
        }
    }

    private void doDFS(Node inNode, Node inTarget) {
        inNode.setVisited(true);
        inNode.setVisiting(true);

        inNode.getSuccessor().forEach((inNeighbor)->{
            if (!inNeighbor.getVisited()) {
                if (inNeighbor.getSuccessor().size() > 0) {
                     inNeighbor.getSuccessor().get(0).parent = inNode;
                     doDFS(inNeighbor, inNeighbor.getSuccessor().get(0));
                 } else {
                     inNeighbor.setVisited(true);
                 }
            }
            if (inNeighbor.equals(inTarget) && inNeighbor.parent != null && !inNeighbor.parent.equals(inTarget)) {
                System.out.println("inNeighbor: " + inNeighbor.getPayload());
                System.out.println("inNode: " + inNode.getPayload());
                System.out.println("Cycle Edge");
            }
        });
        inNode.setVisiting(false);
    }
}
