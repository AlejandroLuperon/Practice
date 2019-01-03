package ReconstructItinerary;

public class ReconstructItineraryEdges {
    /*private static Graph graph = new Graph();
    private static List<String> itinerary = new ArrayList<String>();
    private static LinkedList<Edge> activeEdges = new LinkedList<Edge>();

    public static void main(String[] args) {
        String[][] tickets1 = new String[][]{
            {"MUC","LHR"},
            {"JFK","MUC"},
            {"SFO","SJC"},
            {"LHR","SFO"}
        };

        String[][] tickets2 = new String[][]{
            {"JFK","SFO"},
            {"JFK","ATL"},
            {"SFO","ATL"},
            {"ATL","JFK"},
            {"ATL","SFO"}
        };
        System.out.println(findItinerary(tickets2));
        for (Edge edge : graph.edges) {
            System.out.println(edge.traversed);
        }
    }

    public static List<String> findItinerary(String[][] tickets) {
        buildGraph(tickets);
        activeEdges.add(graph.root.edges.get(0));
        itinerary.add(graph.root.edges.get(0).start.code);
        buildItinerary();
        return itinerary;
    }

    private static void buildGraph(String[][] tickets) {
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

    public static void buildItinerary() {
        Edge currentEdge = null, neighborEdge = null;

        while (!activeEdges.isEmpty()) {
            currentEdge = activeEdges.removeFirst();
            currentEdge.traversed = true;
            itinerary.add(currentEdge.end.code);
            for (int i = 0; i < currentEdge.end.edges.size(); i++) {
                neighborEdge = currentEdge.end.edges.get(i);
                if (!neighborEdge.traversed) {
                    activeEdges.add(neighborEdge);
                }
            }

        }
        List<Edge> remaining = graph.edges.stream().filter((edge)-> !edge.traversed).collect(Collectors.toList());
        System.out.println(remaining.size());
        activeEdges.addAll(remaining);
        if (activeEdges.size() > 0) {
            buildItinerary();
        }
    }*/
}
