package CourseScheduleII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;


public class Solution {
    public static void main(String[] args) {
        int[][] graph = {
            {1,0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        System.out.println(findOrder(4, graph));
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

    public static ArrayList<Integer> findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Course> mapper = build(prerequisites);
        ArrayList<Integer> arranged = new ArrayList<Integer>();

        mapper.values().forEach((course)->{
            doDFS(course);
        });

        List<Course> sorted = mapper
            .values()
            .stream()
            .sorted((c1, c2)->{
               return (Integer.valueOf(c1.order).compareTo(Integer.valueOf(c2.order)));
            })
            .collect(toList());

        sorted.forEach((course)->{
            arranged.add(course.course);
             System.out.println(course.course);
        });

        return arranged;
    }

    public static void doDFS(Course course) {
        course.attended = true;
        for (int i = 0; i < course.prerequisites.size(); i++){
            Course prereq = course.prerequisites.get(i);
            if (!prereq.attended) {
                doDFS(prereq);
            }
        };
    }

}
