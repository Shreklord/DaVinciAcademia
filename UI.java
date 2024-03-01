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
        getMajorTest();
        //scenario1();
        //scenario2();
    }

    public void getMajorTest() {
        MajorList majorList = MajorList.getInstance(); // Assuming MajorList is correctly implemented as a singleton
        ArrayList<Major> majors = majorList.getMajors();
    
        for (Major major : majors) {
            System.out.println("Major Requirements for " + major.getName() + ":");
            for (Course course : major.getMajorRequirements()) {
                System.out.println(course.getTitle() + " (" + course.getCourseNumber() + ")");
            }
            System.out.println("Elective Requirements:");
            for (Course course : major.getElectiveCourseReqs()) {
                System.out.println(course.getTitle() + " (" + course.getCourseNumber() + ")");
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

    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }
}
