package CourseScheduleII;

import java.util.ArrayList;
import java.util.HashMap;


/**
 */

public class CourseScheduleIISubmittedSolution {
    public static void main(String[] args) {

        /*int[][] graph = {
            {0,1}
        };*/
        /*int[][] graph = {
            {1,0},
            {2, 0},
            {3, 1},
            {3, 2}
        };*/

        int[][] graph = {
            {1,0},
            {0,1}
        };

        /*int[][] graph = {
            {1,0}
        };*/

        int[] arranged = findOrder(2, graph);

        for (int i = 0; i < arranged.length; i++) {
            System.out.println(arranged[i]);
        }
    }

    public static HashMap<Integer, Course> build(int[][] prerequisites) {
        HashMap<Integer, Course> mapper = new HashMap<Integer, Course>();
        Course course, prerequisite;
        Integer current, previous;
        for (int i = 0; i < prerequisites.length; i++) {
            current = prerequisites[i][0];
            if (!mapper.containsKey(current)) {
                course = new Course(current);
                mapper.put(current, course);
            } else {
                course = mapper.get(current);
            }
            for (int j = 1; j < prerequisites[i].length; j++) {
                previous = prerequisites[i][j];
                if (!mapper.containsKey(previous)) {
                    prerequisite = new Course(previous);
                    mapper.put(previous, prerequisite);
                } else {
                    prerequisite = mapper.get(previous);
                }
                course.prerequisites.add(prerequisite);
            }
        }
        return mapper;
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> ordered = new ArrayList<Integer>();
        if (prerequisites.length == 0) {
            int[] array = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                array[i] = numCourses - i - 1;
            }
            return array;
        }

        HashMap<Integer, Course> mapper = build(prerequisites);

        mapper.values().forEach((course) -> {
            if (!course.attended) {
                doDFS(course, ordered);
            }
        });

        if (mapper.size() > ordered.size()) {
            return new int[0];
        }

        int[] arranged = new int[numCourses];

        if (numCourses > ordered.size()) {
            for (int i = 0; i < (numCourses - ordered.size()); i++) {
                arranged[i] = (numCourses - 1)- i;
            }

            for (int i = 0; i < ordered.size(); i++) {
                arranged[i + (numCourses-ordered.size())] = ordered.get(i);
            }
        } else {
            for (int i = 0; i < ordered.size(); i++) {
                 arranged[i] = ordered.get(i);
            }
        }
        return (numCourses == arranged.length ? arranged : new int[0]);
    }

    public static void doDFS(Course course, ArrayList<Integer> ordered) {
        course.attended = true;
        course.processing = true;
        Boolean isPossible = true;
        for (int i = 0; i < course.prerequisites.size(); i++){
            Course prereq = course.prerequisites.get(i);
            if (!prereq.attended) {
                doDFS(prereq, ordered);
            } else if (prereq.processing) {
                isPossible = false;
            }
        };
        course.processing = false;

        if (isPossible) {
            ordered.add(course.course);
        }
    }
}
