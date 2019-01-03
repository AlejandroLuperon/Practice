package DungeonGame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class DungeonGameReverseTrace {
    public HashMap<Integer, HashMap<Integer, Cell>> cells = new HashMap<Integer, HashMap<Integer, Cell>>();
    public Node root;
    public List<Path> paths = new ArrayList<Path>();
    public boolean hasNegativeOverallDamagePath = false;
    public boolean hasNegativeDamagePathAtSomePoint = false;
    public Integer lowestEncounteredScore = null;
    public Integer highestLowestEncounteredScore = null;
    public ArrayList<Node> leaves = new ArrayList<Node>();

    public DungeonGameReverseTrace() {

    }

    public int calculateMinimumHP(int[][] dungeon) {
        buildGrid(dungeon);
        lowestEncounteredScore = cells.get(0).get(0).impact;
        highestLowestEncounteredScore = lowestEncounteredScore;

        root = new Node(cells.get(0).get(0));
        dfs(root);
        reverseTrace();

        leaves.forEach((leaf)->{
            System.out.println(leaf.cumulativeImpact);
        });

        if (true) {
            System.out.println("----------");
            return 0;
        }
        Path result = null;

        if (!hasNegativeOverallDamagePath) {
            if (hasNegativeDamagePathAtSomePoint) {
                List<Path> filtered = new ArrayList<Path>();
                filtered = paths.stream().filter((path) -> path.getLowestEncounteredScore() < 0).collect(Collectors.toList());
                Comparator<Path> comparator = Comparator.comparing(Path::getLowestEncounteredScore);
                result = filtered.stream().min(comparator).get();
                return (result.getLowestEncounteredScore() * -1) + 1;
            } else {
                return 1;
            }
        } else {
            Comparator<Path> comparator = Comparator.comparing(Path::getLowestEncounteredScore);
            result = paths.stream().max(comparator).get();
            return (result.getLowestEncounteredScore()*-1) + 1;
        }

        /*if (!hasNegativeOverallDamagePath) {
            if (hasNegativeDamagePathAtSomePoint) {
                return (lowestEncounteredScore * -1) + 1;
            } else {
                return 1;
            }
        } else {
            System.out.println("highestLowestEncounterScore: " + highestLowestEncounteredScore);
            return (highestLowestEncounteredScore * -1) + 1;
        }*/
    }

    public void buildGrid(int[][] dungeon) {
        Cell currentCell = null;
        Cell parentCell = null;
        Cell rightCell = null;
        Cell downCell = null;

        for (int row = 0; row < dungeon.length; row++) {
            for (int column = 0; column < dungeon[row].length; column++) {
                if (cells.containsKey(row) && cells.get(row).containsKey(column)) {
                     currentCell = cells.get(row).get(column);
                } else {
                    if (!cells.containsKey(row)) {
                         cells.put(row, new HashMap<Integer, Cell>());
                    }
                    currentCell = new Cell(row, column, dungeon[row][column]);
                    cells.get(row).put(column, currentCell);
                }

                if (column+1 < dungeon[row].length) {
                    if (cells.containsKey(row) && cells.get(row).containsKey(column+1)) {
                        rightCell = cells.get(row).get(column+1);
                    } else {
                        rightCell = new Cell(row, column, dungeon[row][column+1]);
                        cells.get(row).put(column+1, rightCell);
                    }
                    currentCell.right = rightCell;

                }


                if (row+1 < dungeon.length) {
                    if (cells.containsKey(row+1) && cells.get(row+1).containsKey(column)) {
                        downCell = cells.get(row+1).get(column);
                    } else {
                        if (!cells.containsKey(row+1)) {
                             cells.put(row+1, new HashMap<Integer, Cell>());
                        }
                        downCell = new Cell(row, column, dungeon[row+1][column]);
                        cells.get(row+1).put(column, downCell);
                    }
                    currentCell.down = downCell;
                }
                parentCell = currentCell;
            }
        }
    }

    public void dfs(Node node) {
        if (node.cell.down != null) {
            node.down = new Node(node.cell.down);
            node.down.parent = node;
            dfs(node.down);
        }

        if (node.cell.right != null) {
            node.right = new Node(node.cell.right);
            node.right.parent = node;
            dfs(node.right);
        }

        if (node.cell.down == null && node.cell.right == null) {
            if (!leaves.contains(node.parent)) {
                leaves.add(node.parent);
            }
        }
    }

    public void reverseTrace() {
        Node current = null, origin = null;
        Integer cumulativeImpact;
        for (Node leaf : leaves) {
            cumulativeImpact = 0;
            current = leaf;
            origin = leaf;
            while (true) {
                cumulativeImpact = cumulativeImpact + current.cell.impact;
                current = current.parent;
                if (current == null) {
                    break;
                }

            }
            origin.cumulativeImpact = cumulativeImpact;
        }
    }
}
