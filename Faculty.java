import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Faculty extends User{
    private ArrayList<Student> assignedStudents = new ArrayList<>();
    private ArrayList<Student> getAssignedStudents = new ArrayList<>();

    public Faculty(){
        
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
        return null;
    }
    public void addNote(Student student) {
        
    }
}
