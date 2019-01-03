package CoverPoints;

import java.util.ArrayList;


/**
 */
public class Solution {

    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int step = 0;
        for (int i = 0; i < X.size() - 1; i++) {
            Coordinate current = new Coordinate(X.get(i), Y.get(i));
            Coordinate target = new Coordinate(X.get(i+1), Y.get(i));
        }
        return 0;
    }

    public Coordinate xP1y(int x, int y) {
        return new Coordinate(x + 1, y);
    }

    public Coordinate xM1y(int x, int y) {
        return new Coordinate(x - 1, y);
    }

    public Coordinate xyP1(int x, int y) {
        return new Coordinate(x, y+1);
    }

    public Coordinate xyM1(int x, int y) {
        return new Coordinate(x, y-1);
    }

    public Coordinate xM1yM1(int x, int y) {
        return new Coordinate(x-1, y-1);
    }

    public Coordinate xP1yP1(int x, int y) {
        return new Coordinate(x+1, y+1);
    }

    public Coordinate xM1yP1(int x, int y) {
        return new Coordinate(x-1, y+1);
    }

    public Coordinate xP1yM1(int x, int y) {
        return new Coordinate(x-1, y+1);
    }

    public Coordinate evaluate(Coordinate current, Coordinate target) {
        //if ()
        return new Coordinate(1, 1);
    }

    private class Coordinate {
        public int x;
        public int y;

        public Coordinate(int inX, int inY) {
            x = inX;
            y = inY;
        }

        public boolean equals(Coordinate inCoordinate) {
            return inCoordinate.x == this.x && inCoordinate.y == this.y;
        }
    }
}
