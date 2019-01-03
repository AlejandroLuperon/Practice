package RedundantConnection;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Integer payload;
    private List<Node> successor = new ArrayList<Node>();
    private List<Node> predecessor = new ArrayList<Node>();
    private Boolean isVisited = false;
    private Boolean isVisiting = false;
    public Node parent;

    public Node(Integer inPayload) {
        payload = inPayload;
    }

    public Integer getPayload() {
        return payload;
    }

    public void setPayload(Integer inPayload) {
        payload = inPayload;
    }

    public List<Node> getSuccessor() {
        return successor;
    }

    public void setSuccessor(List<Node> inSuccessor) {
        successor = inSuccessor;
    }

    public List<Node> getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(List<Node> inPredecessor) {
        predecessor = inPredecessor;
    }

    public Boolean getVisited() {
        return isVisited;
    }

    public void setVisited(Boolean inVisited) {
        isVisited = inVisited;
    }

    public Boolean getVisiting() {
        return isVisiting;
    }

    public void setVisiting(Boolean inVisiting) {
        isVisiting = inVisiting;
    }
}
