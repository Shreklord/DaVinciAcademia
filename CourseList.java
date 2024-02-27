import java.util.ArrayList;

public class CourseList {
    private static CourseList courseList;
    private static ArrayList<Course> courses = new ArrayList<Course>();

    private static void CourseList() {}

    public static CourseList getInstance() {
        if (courseList == null) {
            courseList = new CourseList();
            loadCourses();
        }
        return courseList;
    }
    
    private static void loadCourses() {
        courses = DataLoader.getCourses();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Course> getCoursesByMajor(String major) {
        return null;
    }

    public Course getByUUID(String id) {
        return null;
    }
}
