package WordSearch;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public char letter;
    public Integer row;
    public Integer column;
    public List<Node> neighbors = new ArrayList<Node>();
    public boolean used;
    public Node(char letter, Integer row, Integer column) {
        this.letter = letter;
        this.row = row;
        this.column = column;
    }
}
