package ReconstructItinerary;

/**
 */

public class Edge {
    public Node start;
    public Node end;
    public boolean traversed = false;

    public Edge(Node start, Node end) {
        this.start = start;
        this.end = end;
    }
}
