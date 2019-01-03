package RedundantConnection;


public class Edge {
    private Node start;
    private Node end;
    private Integer seen;

    public Edge(Node inStart, Node inEnd, Integer inSeen) {
        start = inStart;
        end = inEnd;
        seen = inSeen;
    }

    public boolean equals(Node inStart, Node inEnd) {
        return start.equals(inStart) && end.equals(inEnd);
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node inStart) {
        start = inStart;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node inEnd) {
        end = inEnd;
    }

    public Integer getSeen() {
        return seen;
    }

    public void setSeen(Integer inSeen) {
        seen = inSeen;
    }

    public void print() {
        System.out.println("[" + start.getPayload() + ", " + end.getPayload() + "], seen at" + seen);
    }
}
