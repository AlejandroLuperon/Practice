package RedundantConnection.archive;

public class Solution {
    public static void main(String[] args) {
        /*int[][] theGraph = new int[][]{
            {1,2},
            {2,3},
            {3,4},
            {1,4},
            {1,5}
        };*/
        int[][] theGraph = new int[][]{
             {1,3},
             {3,4},
             {1,5},
             {3,5},
             {2,3}
         };
        //[[1,3],[3,4],[1,5],[3,5],[2,3]]
       int[][] theGaraph = new int[][]{
            {1,2},
            {1,3},
            {2,3}
        };

        int[][] theGrapdh = new int[][]{
               {1,2},
               {2,3},
               {3,4},
               {1,4},
               {1,5}
        };

        //[[1,3],[3,4],[1,5],[3,5],[2,3]]

        SubmittedSolution theRedundantConnection = new SubmittedSolution();
        System.out.println(theRedundantConnection.findRedundantConnection(theGraph).length);
    }
}
