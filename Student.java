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
        this.standing = standing;                       // jackson - remember to use the setters in the constructor
        this.major = major;                             // you also need to add the parameters (id, username, password, firstName, lastName)
        this.GPA = GPA;                                 // in order to for the super() command to work and change the uml to reflact that
        this.courses = courses;                         // thank u - spencer
        this.currentCourses = currentCourses;
        this.notes = notes;
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
    public String getGradDate() {

    }
    public String getTranscript() {

    }
    public void whatIf() {

    }

}
