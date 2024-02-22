import java.util.ArrayList;

public class Student extends User{
    private String standing;
    private Major major;
    private double GPA;
    private ArrayList<StudentCourse> courses;
    private ArrayList<StudentCourse> currentCourses;
    private ArrayList<String> notes;

    /**
     *Constructor for Student Class
     * @param standing Current Year
     * @param major Student Major
     * @param GPA current GPA of Student
     * @param courses List of all courses needed for student
     * @param currentCourses list of current courses being taken
     * @param notes notes from advisor 
     */
    public Student(String standing, Major major, double GPA, ArrayList<StudentCourse> courses, ArrayList<StudentCourse> currentCourses, ArrayList<String> notes) {
        super(username, password, firstName, lastName);
        this.standing = standing;
        this.major = major;
        this.GPA = GPA;
        this.courses = courses;
        this.currentCourses = currentCourses;
        this.notes = notes;
    }

}
