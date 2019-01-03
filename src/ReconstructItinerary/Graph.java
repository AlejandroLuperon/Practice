package ReconstructItinerary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class Graph {
    public List<Edge> edges = new ArrayList<Edge>();
    public HashMap<String, Node> nodes = new HashMap<String, Node>();
    public Node root = null;

    public Graph() {

    }

    public Edge getEdge(Node start, Node end) {
        List<Edge> matches = edges.stream().filter((edge) -> edge.start.code.equals(start.code) && edge.end.code.equals(end.code) && !edge.traversed).collect(Collectors.toList());

        if (matches.size() == 0) {
            return null;
        }

        return matches.get(0);
    }
}
