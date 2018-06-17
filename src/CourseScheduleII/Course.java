package CourseScheduleII;

import java.util.ArrayList;

public class Course {
    public int course;
    public ArrayList<Course> prerequisites = new ArrayList<Course>();
    public boolean attended = false;
    public int order;
    public boolean processing;

    public Course(int inCourse) {
        course = inCourse;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int inCourse) {
        course = inCourse;
    }

    public ArrayList<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(ArrayList<Course> inPrerequisites) {
        prerequisites = inPrerequisites;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean inAttended) {
        attended = inAttended;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int inOrder) {
        order = inOrder;
    }
}
