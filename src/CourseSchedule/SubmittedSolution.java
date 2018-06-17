package CourseSchedule;

import java.util.ArrayList;
import java.util.HashMap;


public class SubmittedSolution {
    public static void main(String[] args) {
        /*int[][] graph = {
            {1,0},
            {0,1}
        };*/

        /*int[][] graph = {
            {0,1},
            {0,2},
            {1,2}
        };*/

        int[][] graph = {
            {1,0},
            {0,2},
            {2,1}
        };

        /*
        [[1,0],[0,2],[2,1]]*/
        System.out.println(canFinish(3, graph));
    }

    public static HashMap<Integer, Node> build(int[][] prerequisites) {
        HashMap<Integer, Node> mapper = new HashMap<Integer, Node>();
        Node course = new Node(0);//dummy
        Node prerequisite;
        for (int i = 0; i < prerequisites.length; i++) {
            if (!mapper.containsKey(prerequisites[i][0])) {
                course = new Node(prerequisites[i][0]);
                mapper.put(prerequisites[i][0], course);
            } else {
                course = mapper.get(prerequisites[i][0]);
            }

            for (int j = 1; j < prerequisites[i].length; j++) {
                if (!mapper.containsKey(prerequisites[i][j])) {
                    prerequisite = new Node(prerequisites[i][j]);
                    mapper.put(prerequisites[i][j], prerequisite);
                } else {
                    prerequisite = mapper.get(prerequisites[i][j]);
                }
                course.getSuccessors().add(prerequisite);
            }
        }
        return mapper;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        HashMap<Integer, Node> mapper = build(prerequisites);
        ArrayList<Boolean> possibilities = new ArrayList<Boolean>();
        mapper.values().forEach((course)->{
            if (!course.isVisited()) {
                possibilities.add(doDFSCycle(course, possibilities));
            }
        });
        return !possibilities.contains(false);
    }

    public static Boolean doDFSCycle(Node node, ArrayList<Boolean> possibilities) {
        node.setProcessing(true);
        node.setVisited(true);
        for (int i = 0; i < node.getSuccessors().size(); i++) {
            Node successor = node.getSuccessors().get(i);
            if (!successor.isVisited()) {
                successor.setVisited(true);
                possibilities.add(doDFSCycle(successor, possibilities));
            } else if (successor.isProcessing()){
                return false;
            }
        }

        node.setProcessing(false);
        return true;
    }
}

/*
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.getSuccessors().add(one);
        one.getSuccessors().add(two);
        one.getSuccessors().add(three);
        one.getSuccessors().add(four);

        two.getSuccessors().add(one);

        three.getSuccessors().add(two);
        three.getSuccessors().add(four);

        four.getSuccessors().add(two);
        four.getSuccessors().add(three);
 */