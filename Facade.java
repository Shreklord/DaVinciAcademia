import java.util.ArrayList;
import java.util.UUID;

public class Facade {
    public User currentUser;
    private String currentUserType;
    private ArrayList<Course> courses;

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

    public User login(String userName, String password) {
        return null;
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

}
