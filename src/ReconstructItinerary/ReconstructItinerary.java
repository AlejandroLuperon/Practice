package ReconstructItinerary;

public class ReconstructItinerary {
    /*private static Graph graph = new Graph();
    private static List<String> itinerary = new ArrayList<String>();
    private static LinkedList<Node> activeNodes = new LinkedList<Node>();
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
    }

    public static List<String> findItinerary(String[][] tickets) {
        buildGraph(tickets);
        activeNodes.add(graph.root);
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
        Node current = null, neighbor = null;
        System.out.println(activeNodes.size() + " bur bur");
        while (!activeNodes.isEmpty()) {
            current = activeNodes.removeFirst();
            if (!current.visited) {
                current.visited = true;
                itinerary.add(current.code);
                for (int i = 0; i < current.destinations.size(); i++) {
                    neighbor = current.destinations.get(i);
                    activeNodes.add(neighbor);
                }
            }
        }
        List<Node> remaining = graph.nodes.values().stream().filter((node)-> !node.visited).collect(Collectors.toList());
        System.out.println(remaining.size());
        activeNodes.addAll(remaining);
        if (activeNodes.size() > 0) {
            buildItinerary();
        }
    }*/
}
