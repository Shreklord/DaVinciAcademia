import java.util.ArrayList;
import java.util.HashMap;

public class Faculty extends User{
    private ArrayList<Student> assignedStudents = new ArrayList<>();
    private ArrayList<Student> getAssignedStudents = new ArrayList<>();

    public Faculty(){
        
    }

    public void addCourse(HashMap<Course, courseNumber> courses) {
        
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

    }
    public void addNote(Student student) {
        
    }
}
