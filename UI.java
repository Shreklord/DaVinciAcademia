import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private Facade facade;

    // COURSE LIST MUST BE INITIALIZED BEFORE WE LOAD ANY STUDENTS WHAT SO EVER

    public UI() {
        //this.facade = new Facade();
        //this.scanner;
    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.displayLoginMenu();
    }

    public void displayLoginMenu() {
        System.out.println("Hello DaVinci Academia Students!");
        System.out.println("Loading courses...");
        

        CourseList instance = CourseList.getInstance();
        ArrayList<Course> list = instance.getCourses();

        System.out.println("Printing stuff::::::::::::::::::::::::");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+"------------------------------------------");
            Course c = list.get(i);
            System.out.println(c.getSubject());
            System.out.println(c.getHours());
            System.out.println(c.getID());
            System.out.println(c.getPrereqs());
            System.out.println(c.getCourseNumber());
            System.out.println(c.getTitle());
        }

        System.out.println("now testing loading students---------------------------");
        ArrayList<Student> studentList = DataLoader.getStudents();

        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            System.out.println(s.getFirstName());
            System.out.println(s.getLastName());
            System.out.println(s.getUsername());
            System.out.println(s.getPassword());
        }

    }
}
