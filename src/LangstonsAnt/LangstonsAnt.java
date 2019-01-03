package LangstonsAnt;

import java.util.HashMap;

public class LangstonsAnt {
    enum State {
        BLACK,
        WHITE;
    }

    enum Orientation {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    static HashMap<Integer, HashMap<Integer, Cell>> grid = new HashMap<Integer, HashMap<Integer, Cell>>();
    static Ant ant;
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.run(3, 4, 7, Orientation.LEFT, 1, 1);
        simulation.print();
    }


    static class Ant {
        public Integer row;
        public Integer column;
        public Orientation orientation;

        public Ant(Orientation orientation, Integer row, Integer column) {
            this.orientation = orientation;
            this.row = row;
            this.column = column;
        }

        public void move(State currentCellState) {
            if (currentCellState.equals(State.WHITE)) {
                switch (this.orientation) {
                    case UP:
                        this.orientation = Orientation.RIGHT;
                        this.column++;
                        break;
                    case RIGHT:
                        this.orientation = Orientation.DOWN;
                        this.row++;
                        break;
                    case DOWN:
                        this.orientation = Orientation.LEFT;
                        this.column--;
                        break;
                    case LEFT:
                        this.orientation = Orientation.UP;
                        this.row--;
                        break;
                }
            } else {
                switch (this.orientation) {
                    case UP:
                        this.orientation = Orientation.LEFT;
                        this.column--;
                        break;
                    case RIGHT:
                        this.orientation = Orientation.UP;
                        this.row--;
                        break;
                    case DOWN:
                        this.orientation = Orientation.RIGHT;
                        this.column++;
                        break;
                    case LEFT:
                        this.orientation = Orientation.DOWN;
                        this.row++;
                        break;
                }
            }

        }
    }

    static class Cell {
        public Integer row;
        public Integer column;
        public State state = State.WHITE;

        public Cell(Integer row, Integer column) {
            this.row = row;
            this.column = column;
        }

        public void toggle() {
            switch (this.state) {
                case BLACK:
                    this.state = State.WHITE;
                    break;
                case WHITE:
                    this.state = State.BLACK;
                    break;
            }
        }
    }

    static class Simulation {
        public Simulation() {}

        public void build(Integer rows, Integer columns) {
            for (int row = 0; row < rows; row++) {
                grid.put(row, new HashMap<Integer, Cell>());
                for (int column = 0; column < columns; column++) {
                    grid.get(row).put(column, new Cell(row, column));
                }
            }
        }

        public void run(Integer rows,
                        Integer columns,
                        Integer steps,
                        Orientation orientation,
                        Integer initialRow,
                        Integer initialColumn) {
            build(rows, columns);

            ant = new Ant(orientation, initialRow, initialColumn);

            Cell currentCell = grid.get(initialRow).get(initialColumn);

            for (int step = 0; step < steps; step++) {
                ant.move(currentCell.state);
                currentCell.toggle();
                currentCell = grid.get(ant.row).get(ant.column);
            }
        }

        public void print() {
            grid.keySet().forEach((row)->{
                grid.get(row).keySet().forEach((column)->{
                    if (row == ant.row && column == ant.column) {
                        switch (ant.orientation) {
                            case LEFT:
                                System.out.print("< ");
                                break;
                            case UP:
                                System.out.print("^ ");
                                break;
                            case DOWN:
                                System.out.print("V ");
                                break;
                            case RIGHT:
                                System.out.print("> ");
                                break;
                        }
                    } else {
                        if (grid.get(row).get(column).state.equals(State.WHITE)) {
                            System.out.print(". ");
                        } else {
                            System.out.print("# ");
                        }
                    }

                });
                System.out.println("");
            });
        }
    }
}
