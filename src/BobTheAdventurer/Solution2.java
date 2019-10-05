
package BobTheAdventurer;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;

class Solution2 {
    public static void main(String[] args) {
        Point2D a = new Point2D();
        Point2D b = new Point2D();
        Point2D c = new Point2D();
        Point2D d = new Point2D();
        Point2D e = new Point2D();
        a.x = -1;
        a.y = -2;

        b.x = 1;
        b.y = 2;

        c.x = 2;
        c.y = 4;

        d.x = -3;
        d.y = 2;

        e.x = 2;
        e.y = -2;

        Point2D[] test = new Point2D[]{a, b, c, d, e};

        System.out.println(solution(test));
    }
    public static int solution(Point2D[] A) {
        // write your code in Java SE 8
        HashMap<String, ArrayList<Point2D>> smallestFactorBuckets = new  HashMap<String, ArrayList<Point2D>>();
        int x, y;
        int xFactor;
        int yFactor;

        String key = "";

        for (Point2D point : A) {
            x = point.x;
            y = point.y;
            if (x < 0) {
                xFactor = getSmallestNegativeFactor(x);
            } else {
                xFactor = getSmallestFactor(x);
            }

            if (y < 0) {
                yFactor = getSmallestNegativeFactor(y);
            } else {
                yFactor = getSmallestFactor(y);
            }
            key = xFactor + "" + yFactor;

            if (!smallestFactorBuckets.containsKey(key)) {
                smallestFactorBuckets.put(key, new ArrayList<Point2D>());
            }

            smallestFactorBuckets.get(key).add(point);
        }

        return smallestFactorBuckets.size();
    }

    public static int getSmallestFactor(int point) {
        if (point == 1) {
            return 1;
        }

        if (point == 0) {
            return 0;
        }

        int factor = 2;
        int remainder = 1;

        while (remainder != 0) {
            remainder =  point % factor;
            System.out.println("point: " + point + " " + " factor: " + factor);

            if (factor == point) {
                break;
            }
            if (remainder != 0) {
                factor++;
            } else {
                break;
            }
            if (factor > 10) {
                break;
            }
        }

        return factor;
    }

    public static int getSmallestNegativeFactor(int point) {
        if (point == -1) {
            return -1;
        }

        if (point == 0) {
            return 0;
        }

        int factor = -2;
        int remainder = 1;

        while (remainder != 0) {
            remainder =  point % factor;
            System.out.println("point: " + point + " " + " factor: " + factor);

            if (factor == point) {
                break;
            }
            if (remainder != 0) {
                factor--;
            } else {
                break;
            }
            if (factor > 10) {
                break;
            }
        }

        return factor;
    }
}