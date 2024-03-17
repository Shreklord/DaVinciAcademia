import java.util.ArrayList;
import java.util.UUID;

public class Facade {
    private User currentUser;
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

    public ArrayList<Course> getEightSemesterPlan(UUID id) {
        
        Student temp = users.getStudentByID(id);
        System.out.println(temp.getMajor().getName());
        return temp.displayEightSemesterPlan();
    }

    public ArrayList<Major> getMajors() {
        return majors.getMajors();
    }

    public void whatIf() {
        
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User u) {
        this.currentUser = u;
    }

    public String formattedStudentCourses(boolean isCompleted) {
        String returnString = "";

        // will only be called after the user has logged into student so we will handle the user as one
        Student currentStudent = users.getStudentByID(this.currentUser.getID());
        ArrayList<StudentCourse> studentCourses = currentStudent.getCourses();
        for (StudentCourse c : studentCourses) {
            
            if (isCompleted && !c.getIsCompleted()) {
                continue;
            } else if (!isCompleted && c.getIsCompleted()) {
                continue;
            }

            returnString += "----- " + c.getTitle() + " (" + c.getSubject() + c.getCourseNumber()+ ")\n";
            returnString += "\n";
            returnString += "   GPA: " + c.getGrade() + "(" + c.getLetterGrade() + ")\n";
            returnString += "   Hours: " + c.getHours() + "\n";
            returnString += "\n";
        }

        return returnString;
    }


    public String formattedStudentCoursesLeft() {
        return "";
    }


	public String formattedStudentEightSemesterPlan() {
		return "";
	}

}
