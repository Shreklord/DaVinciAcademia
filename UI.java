import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private Facade facade;

    // COURSE LIST MUST BE INITIALIZED BEFORE WE LOAD ANY STUDENTS WHAT SO EVER

    public UI() {
        facade = new Facade();
    }

    public void run() {

        displayLoginMenu(); //Testing JSON file loading and login scenarios 
        //scenario1();
        //scenario2();
    }

    public void displayLoginMenu() {
        System.out.println("Hello DaVinci Academia Students!");
        //System.out.println("Loading courses...");
        

       //CourseList instance = CourseList.getInstance();
       //ArrayList<Course> list = instance.getCourses();

       //System.out.println("Printing stuff::::::::::::::::::::::::");
       //for (int i = 0; i < list.size(); i++) {
       //    System.out.println(i+"------------------------------------------");
       //    Course c = list.get(i);
       //    System.out.println(c.getSubject());
       //    System.out.println(c.getHours());
       //    System.out.println(c.getID());
       //    System.out.println(c.getPrereqs());
       //    System.out.println(c.getCourseNumber());
       //    System.out.println(c.getTitle());
       //}

       //System.out.println("now testing loading students---------------------------");
       //ArrayList<Student> studentList = DataLoader.getStudents();

       //for (int i = 0; i < studentList.size(); i++) {
       //    Student s = studentList.get(i);
       //    System.out.println(s.getFirstName());
       //    System.out.println(s.getLastName());
       //    System.out.println(s.getUsername());
       //    System.out.println(s.getPassword());
       //}

        MajorList majorList = MajorList.getInstance();
        ArrayList<Major> listOfMajors = majorList.getMajors();
        for (int i = 0; i < listOfMajors.size(); i++) {
            Major m = listOfMajors.get(i);
            System.out.println(m.getName());
            System.out.println(m.getHours());
            System.out.println(m.getType());
            
            
            System.out.println("major requirements:");
            System.out.println(m.getMajorRequirements().size());
            for (int j = 0; j < m.getMajorRequirements().size(); j++) {
                System.out.print(m.getMajorRequirements().get(j).getSubject());
                System.out.print(m.getMajorRequirements().get(j).getCourseNumber());
            }

            System.out.println("\nelective requirements:");
            System.out.println(m.getElectiveCourseReqs().size());
            for (int j = 0; j < m.getElectiveCourseReqs().size(); j++) {
                System.out.print(m.getElectiveCourseReqs().get(j).getSubject());
                System.out.print(m.getElectiveCourseReqs().get(j).getCourseNumber());
            }

            System.out.println("\n");
        }

    }

    public void scenario1() {
        System.out.println("");
        System.out.println("Testing Login Success Scenario");
        ArrayList<Student> studentList = DataLoader.getStudents();
        Student s = studentList.get(0);
        if(!facade.login(s.getUsername(), s.getPassword())) {
            System.out.println("Invalid username or password");
            return;
        }
        System.out.println("Welcome " + s.getFirstName() + " " + s.getLastName());
    }

    public void scenario2() {
        System.out.println("");
        System.out.println("Testing Login Fail Scenario");
        ArrayList studentList = DataLoader.getStudents();
        Student s = (Student)studentList.get(0);
        if(facade.login(s.getUsername(), "wrongpassword")) {
            System.out.println("Invalid username or password");
            return;
        }
        System.out.println("Welcome " + s.getFirstName() + " " + s.getLastName());
    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }
}
