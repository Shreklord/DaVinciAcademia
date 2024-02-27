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
