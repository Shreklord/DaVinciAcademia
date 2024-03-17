import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.HashMap;

public class UI {
    private Scanner scanner;
    private Facade facade;

    // COURSE LIST MUST BE INITIALIZED BEFORE WE LOAD ANY STUDENTS WHAT SO EVER

    public UI() {
        facade = new Facade();
    }

    public void run() {
        displayLoginMenu(); //Testing JSON file loading and login scenarios 
        getMajorTest();
        System.out.println();
        System.out.println("Testing Eight Semester Plan");
        System.out.println("---------------------------------------------");
        testEightSemesterPlan();
        //scenario1();
        //scenario2();
        // testDataWriter();
    }

    public void getMajorTest() {
        MajorList majorList = MajorList.getInstance(); // Assuming MajorList is correctly implemented as a singleton
        ArrayList<Major> majors = majorList.getMajors();
        for(Major major : majors) { 
            HashMap<Course, Integer> temp = major.getMajorRequirements();
            HashMap<Course, Integer> temp2 = major.getElectiveCourseReqs();
            System.out.println("---------------------------------------------");
            System.out.println("Printing Major Requirements Test");
            System.out.println("---------------------------------------------");
            for(HashMap.Entry<Course, Integer> entry : temp.entrySet()) {
                    System.out.println("Course: " + entry.getKey().getTitle() + " (" + entry.getKey().getSubject() + " " + entry.getKey().getCourseNumber() + ") " + "Reccomended Semester: " + entry.getValue());
            
            }
            System.out.println();
            System.out.println("---------------------------------------------");
            System.out.println("Printing Elective Requirements Test");
            System.out.println("---------------------------------------------");
            for(HashMap.Entry<Course, Integer> entry : temp2.entrySet()) {
                    System.out.println("Course: " + entry.getKey().getTitle() + " (" + entry.getKey().getSubject() + " " + entry.getKey().getCourseNumber() + ") " + "Reccomended Semester: " + entry.getValue());
            }
        }
    }

    public void displayLoginMenu() {
        System.out.println("Hello DaVinci Academia Students!");
        
    }

    public void scenario1() {
        System.out.println("");
        System.out.println("Testing Login Success Scenario");
        Boolean temp = facade.login("JS20", "password");
        if(temp) {
            System.out.println("Welcome " + facade.currentUser.getFirstName() + " " + facade.currentUser.getLastName());
        }
        else
            System.out.println("Invalid username or password");
        temp = facade.login("LD30", "ilovemykids");
        if(temp) {
            System.out.println("Welcome " + facade.currentUser.getFirstName() + " " + facade.currentUser.getLastName());
        }
        else
            System.out.println("Invalid username or password");
        return;
    }

    public void scenario2(){
        System.out.println();
        System.out.println("Testing Login Failure Scenario");
        Boolean temp = facade.login("JS20", "password1");
        if(temp) {
            System.out.println("Welcome " + facade.currentUser.getFirstName() + " " + facade.currentUser.getLastName());
        }
        else
            System.out.println("Invalid username or password");
        temp = facade.login("LD30", "ilovemykids1");
        if(temp) {
            System.out.println("Welcome " + facade.currentUser.getFirstName() + " " + facade.currentUser.getLastName());
        }
        else
            System.out.println("Invalid username or password");
        return;
    }
    public void testDataWriter() {
        // //This can be deleted eventually. 
        // System.out.println();
        // DataLoader dl = new DataLoader();
        // Course a = dl.getCourses().getFirst();
        // StudentCourse b = new StudentCourse(a.getID(), a.getTitle(), a.getHours(), a.getSubject(), a.getCourseNumber(), a.getPrereqs(), true, 1, 95);
        // ArrayList<StudentCourse> courses = new ArrayList<StudentCourse>();
        // courses.add(b);
        // ArrayList<Student> st = dl.getStudents();
        // Major cs = dl.getMajors().getFirst();
        // ArrayList<String> not = new ArrayList<String>();
        // Student michael = new Student(UUID.randomUUID(), "u n", "4675", "Owen", "Lars", "sophomore", cs, 14.3, courses, not);
        // System.out.println(michael.getStanding());
        // st.add(michael);
        // DataWriter.saveStudents(st);
    }

    public void testEightSemesterPlan() {
        ArrayList<Student> students = UserList.getStudents();
        Student temp = students.get(0);
        int totalHours = 0;
        System.out.println("Student Name: " + temp.getFirstName() + " " + temp.getLastName());
        System.out.println("Student Major: " + temp.getMajor().getName());
        for(Course course : temp.displayEightSemesterPlan()) {
            System.out.println("Course: " + course.getTitle() + " (" + course.getSubject() + " " + course.getCourseNumber() + ")");
            totalHours += course.getHours();
        }
        System.out.println("Total Hours: " + totalHours);
    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }
}
