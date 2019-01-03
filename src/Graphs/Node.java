package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int payload;
    private List<Node> neighbors;
    private boolean visited = false;

    public Node(int inPayload) {
        payload = inPayload;
        neighbors = new ArrayList<Node>();
    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int inPayload) {
        payload = inPayload;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node> inNeighhors) {
        neighbors = inNeighhors;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean inVisited) {
        visited = inVisited;
    }
}
