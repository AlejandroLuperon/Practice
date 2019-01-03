package ReconstructItinerary;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public String code;
    public List<Node> destinations = new ArrayList<Node>();
    public boolean visited;
    public Node(String code) {
        this.code = code;
    }
}
