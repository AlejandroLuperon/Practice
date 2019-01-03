package WordBreakII;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Node {
    public boolean lastStop = false;
    public List<Node> nextStops = new ArrayList<Node>();
    public String letter;

    public Node(String letter) {
        this.letter = letter;
    }

    public Node getNextStop(String letter) {
        ArrayList<Node> results = nextStops.stream().filter((currentNode)->currentNode.letter.equals(letter)).collect(Collectors.toCollection(ArrayList::new));
        return results.size() > 0 ? results.get(0) : null;
    }
}
