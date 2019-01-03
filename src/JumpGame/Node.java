package JumpGame;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public Integer index;
    public Integer distance = 0;
    public boolean visited = false;
    public List<Node> neighbors = new ArrayList<Node>();

    public Node(Integer index) {
        this.index = index;
    }
}
