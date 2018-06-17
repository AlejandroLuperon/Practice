package CloneGraph;

import java.util.ArrayList;
import java.util.List;


class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public boolean isVisited;

    UndirectedGraphNode(int x) {
        label = x; neighbors = new ArrayList<UndirectedGraphNode>();
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int inLabel) {
        label = inLabel;
    }

    public List<UndirectedGraphNode> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<UndirectedGraphNode> inNeighbors) {
        neighbors = inNeighbors;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean inVisited) {
        isVisited = inVisited;
    }
};


