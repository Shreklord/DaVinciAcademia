import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Faculty extends User{
    private ArrayList<Student> assignedStudents = new ArrayList<Student>();
    private ArrayList<Student> getAssignedStudents = new ArrayList<Student>();

    public Faculty(UUID id, String username, String password, String firstName, String lastName) {
        super(id, username, password, firstName, lastName);
        this.setAssignedStudents(assignedStudents);
        this.setGetAssignedStudents(getAssignedStudents);
    }

    public void addCourse(HashMap<Course, Integer> courses) {
        
    }
    public void removeCourse(ArrayList<Course> courses, Course course) {

    }
    public void editCourse(ArrayList<Course> courses, String category, String description) {

    }
    public void addStudent(UUID id){

    }
    public void removeStudent(UUID id) {

    }
    public void editStudent(UUID id) {

    }
    public ArrayList<Student> getAssignedStudents() {
        return assignedStudents;
    }

    public void setAssignedStudents(ArrayList<Student> assignedStudents) {
        this.assignedStudents = assignedStudents;
    }

    public ArrayList<Student> getGetAssignedStudents() {
        return getAssignedStudents;
    }

    public void setGetAssignedStudents(ArrayList<Student> getAssignedStudents) {
        this.getAssignedStudents = getAssignedStudents;
    }

    public void addNote(Student student) {
        
    }
}
