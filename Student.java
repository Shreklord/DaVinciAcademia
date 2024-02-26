import java.util.ArrayList;
import java.util.UUID;

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
    public Student(UUID id, String username, String password, String firstName, String lastName, String standing, Major major, double GPA, ArrayList<StudentCourse> courses, ArrayList<StudentCourse> currentCourses, ArrayList<String> notes) {
        super(id, username, password, firstName, lastName);
                                                            
        this.setMajor(major);               
        this.setGPA(GPA);                               // jackson - remember to use the setters in the constructor
        this.setCourses(currentCourses);                // you also need to add the parameters (id, username, password, firstName, lastName)
        this.setCurrentCourses(currentCourses);         // in order to for the super() command to work and change the uml to reflact that. thank u - spencer
        this.setNotes(notes);
    }

    public void displayEightSemesterPlan() {
        // Need to access the major's Courses and display them.
        // Need to get each course's credit hours, 
        // Take the classes that equal out to 15,
        // Display that for each semester.
        // Display each semester.
        // The difficulty is that the classes can't be chosen at random,
        // but the prereqs have to be taken first. 
        
        // I think it fills out classes as normal, then checks prereqs.
        // If there are prereqs, then put the prereqs in the plan for that semester, repeat.

        // Will also have to check each time we add a course to the eight semester plan
        // if the course has already been taken by the student.
        //
    }
    
    public UUID getId() {
        return super.getID();
    }

    public String getUsername() {
        return super.getUsername();
    }

    public String getPassword() {
        return super.getUsername();
    }
    public String getFirstName() {
        return super.getfirstName();
    }

    public String getLastName() {
        return super.getLastName();
    }

    public String getStanding() {
        return this.standing;
    }

    public Major getMajor() {
        return this.major;
    }

    public double getGPA() {
        return this.GPA;
    }

    public ArrayList<StudentCourse> getCourses() {
        return this.courses;
    }

    public ArrayList<StudentCourse> getCurrentCourses() {
        return this.currentCourses;
    }

    public ArrayList<String> getNotes() {
        return this.notes;
    }

    public void setStanding(String standing) {
        this.standing = standing;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
    
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public void setCourses(ArrayList<StudentCourse> courses) {
        this.courses = courses;
    }

    public void setCurrentCourses(ArrayList<StudentCourse> currentCourses) {
        this.currentCourses = currentCourses;
    }

    public void setNotes(ArrayList<String> notes) {
        this.notes = notes;
    }

    
}
