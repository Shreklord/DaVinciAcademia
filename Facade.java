import java.util.ArrayList;
import java.util.UUID;

public class Facade {
    public User currentUser;
    private UserList users = UserList.getInstance();
    private CourseList courses = CourseList.getInstance();
    private MajorList majors = MajorList.getInstance();

    public Facade() {
        ProgramFacade();
    }

    public void ProgramFacade() {
        
    }

    public ArrayList<StudentCourse> getStudentCourses() {
        return null;
    }

    public User createAccount(UUID id, String userName, String password, String firstName, String lastName) {
        return null;
    }

    public boolean login(String userName, String password) {
       if(users.getUser(userName, password) != null) {
           currentUser = users.getUser(userName, password);
           return true;
       } else {
            currentUser = null;
            return false;
       }
    }

    public Course addCourse(UUID id, int hours, String subject, int courseNumber, ArrayList<String> prereqs) {
        return null;
    }

    public void removeCourse(String courseName) {

    }

    public ArrayList<Course> getEightSemesterPlan() {
        return null;
    }

    public ArrayList<Major> getMajors() {
        return null;
    }

    public void whatIf() {
        
    }

    public User getCurrentUser() {
        return currentUser;
    }

}
