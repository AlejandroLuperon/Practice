package CourseSchedule;

import java.util.ArrayList;


/**
 */

public class Node {
    private int label;
    private ArrayList<Node> successors = new ArrayList<Node>();
    private boolean visited = false;
    private boolean processing = false;

    public Node(int inLabel) {
        label = inLabel;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int inLabel) {
        label = inLabel;
    }

    public ArrayList<Node> getSuccessors() {
        return successors;
    }

    public void setSuccessors(ArrayList<Node> inSuccessors) {
        successors = inSuccessors;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean inVisited) {
        visited = inVisited;
    }

    public boolean isProcessing() {
        return processing;
    }

    public void setProcessing(boolean inProcessing) {
        processing = inProcessing;
    }
}
