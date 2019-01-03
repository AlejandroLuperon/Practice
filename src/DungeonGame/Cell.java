package DungeonGame;

public class Cell {
    public Integer row = 0;
    public Integer column = 0;

    public Cell down = null;
    public Cell right = null;
    public Integer impact;

    public Cell() {}

    public Cell(Integer impact) {
        this.impact = impact;
    }

    public Cell(Integer row, Integer column, Integer impact) {
        this.row = row;
        this.column = column;
        this.impact = impact;
    }
}
