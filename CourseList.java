import java.util.ArrayList;
import java.util.HashMap;

public class CourseList {
    private static CourseList courseList;
    private static ArrayList<Course> courses = new ArrayList<Course>();

    private static void CourseList() {}

    /**
     * if 'this' is null then it loads the courses
     * returns itself
     */
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

    /**
     * returns an unsorted list of major reqs and elective reqs
     * input string is case sensitive
     */
    public ArrayList<Course> getCoursesByMajor(String major) {
        ArrayList<Course> majorCourses = new ArrayList<Course>();
        Major currentMajor = MajorList.getMajorByName(major);
        
        for (Course c : currentMajor.getMajorRequirements().keySet())
            majorCourses.add(c);

        for (Course c : currentMajor.getElectiveCourseReqs().keySet())
            majorCourses.add(c);

        return majorCourses;
    }

    /**
     * iterates through courses and returns if there is a match
     * if there is no match then it return null
     * @param String
     * @return Course
     */
    public Course getByUUID(String id) {
        for (Course c : courses) {
            if (c.getID().toString().equals(id))
                return c;
        }
        return null;
    }

    /**
     * iterates through courses and returns a course if found null if not
     * @param String
     * @param int
     * @return Course
     */
    public Course getByTitleAndNumber(String subject, int courseNumber) {
        for (Course c : courses) {
            if (c.getSubject().equalsIgnoreCase(subject) && c.getCourseNumber() == courseNumber) {
                return c;
            }
        }
        return null;
    }
}
