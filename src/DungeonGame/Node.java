package DungeonGame;

/**
 */

public class Node {
    public Cell cell;
    public Node down;
    public Node right;
    public Node parent;
    public Integer cumulativeImpact;

    public Node(Cell cell) {
        this.cell = cell;
    }
}
