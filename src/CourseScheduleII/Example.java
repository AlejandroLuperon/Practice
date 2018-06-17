package CourseScheduleII;

import java.util.ArrayList;
import java.util.List;


class Example {

    public static boolean[] discovered;
    public static boolean[] visited;
    public static int[] resultSet;
    public static int counter=0;

    public static void main(String[] args) {
        int[][] graph = {
            {5,8},
            {3, 5},
            {1, 9},
            {4, 5},
            {0,2},
            {7, 8},
            {4, 9}
        };
        int[] arranged = findOrder(10, graph);
        for (int i = 0; i < arranged.length; i++) {
            System.out.println(arranged[i]);
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        // Construct adjList first
        List<Integer>[] adjList = constructAdjList(numCourses, prerequisites);

        discovered = new boolean[numCourses];
        visited = new boolean[numCourses];

        resultSet = new int[numCourses];

        for(int i=0; i<numCourses; i++) {

            if(!discovered[i]) {

                if(adjList[i] == null){
                    discovered[i] = true;
                    resultSet[counter++] = i; // Courses which don't have any prereq can be added in any order.
                    continue;
                }

                if(findCycle(i, adjList)) {
                    return new int[0];
                }

            }

        }

        return resultSet;

    }

    private static List<Integer>[] constructAdjList(int n, int[][] prereq) {

        List<Integer>[] adjList = new ArrayList[n];

        for(int i=0; i<prereq.length; i++) {

            int vertex = prereq[i][0];
            int neighbor = prereq[i][1];

            if(adjList[vertex] == null) {
                adjList[vertex] = new ArrayList<Integer>();
            }

            adjList[vertex].add(neighbor);

        }

        return adjList;

    }

    private static boolean findCycle(int vertex, List<Integer>[] adjList) {

        discovered[vertex] = true;
        visited[vertex] = true;

        boolean result = false;
        List<Integer> neighbors = adjList[vertex];

        if(neighbors!=null) {  // Important as we are constructing adjList only for vertices available in prerequisites array.
            for(Integer neighbor: neighbors) {

                if(visited[neighbor]) { // back-edge found!
                    result = true;
                    break;
                }

                if(discovered[neighbor]) { // If already discovered, no need to traverse again. Consider other neighbors!
                    continue;
                }

                if(findCycle(neighbor, adjList)) { // Perform DFS.
                    result = true;
                    break;
                }

            }
        }

        resultSet[counter++] = vertex; // Add the course to resultSet
        visited[vertex] = false;  // Very important line to find back-edge.
        return result;

    }
}