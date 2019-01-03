package ReconstructItinerary;

public class IncorrectItineraryFinder {
    /*public Graph graph = new Graph();
    private List<String> itinerary = new ArrayList<String>();
    //private LinkedList<Edge> activeEdges = new LinkedList<Edge>();

    public List<String> findItinerary(String[][] tickets) {
        buildGraph(tickets);
        itinerary.add(graph.root.edges.get(0).start.code);
        buildItinerary(graph.root.edges.get(0));

        return itinerary;
    }

    private void buildGraph(String[][] tickets) {
        String start = "", end = "";
         Node startNode = null, endNode = null;
         Edge edge = null;
         for (int i = 0; i < tickets.length; i++) {
             start = tickets[i][0];
             end = tickets[i][1];

             if (!graph.nodes.containsKey((start))) {
                 startNode = new Node(start);
                 graph.nodes.put(start, startNode);
             } else {
                 startNode = graph.nodes.get(start);
             }

             if (!graph.nodes.containsKey((end))) {
                 endNode = new Node(end);
                 graph.nodes.put(end, endNode);
             } else {
                 endNode = graph.nodes.get(end);
             }

             startNode.destinations.add(endNode);

             edge = new Edge(startNode, endNode);
             graph.edges.add(edge);
             startNode.edges.add(edge);

             if (graph.root == null && start.toLowerCase().equals("jfk")) {
                 graph.root = startNode;
             }

             if (graph.root == null && end.toLowerCase().equals("jfk")) {
                 graph.root = endNode;
             }
         }
    }

    private void buildItinerary(Edge edge) {
        for (Edge next : edge.end.edges) {
            if (!next.traversed) {
                next.traversed = true;
                itinerary.add(next.start.code);
                for (Edge inner : next.start.edges) {
                    buildItinerary(inner);
                }
                for (Edge inner : next.end.edges) {
                    buildItinerary(inner);
                }
            }
        }
    }*/
}
