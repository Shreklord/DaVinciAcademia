import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;

public class UI {
    private Scanner scanner;
    private Facade facade;

    // COURSE LIST MUST BE INITIALIZED BEFORE WE LOAD ANY STUDENTS WHAT SO EVER

    public UI() {
        this.scanner = new Scanner(System.in);
        this.facade = new Facade(); 
    }

    public void run() {
        loginScreen();
        
    }

    public void loginScreen() {

        System.out.print("\033[H\033[2J");  
        System.out.flush();
        while (this.facade.getCurrentUser() == null) {
            System.out.println("-----DaVinci Academia-----");
            System.out.println("Enter username: ");
            String enteredUsername = scanner.nextLine();

            if (enteredUsername.equals("q"))
                System.exit(0);;

            System.out.println("Enter password: ");
            String enteredPassword = scanner.nextLine();

            if (this.facade.login(enteredUsername, enteredPassword)) {
                break;
            } else {
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("log in information was incorrected please try again");
            }
            
        }

        System.out.print("\033[H\033[2J");  
        System.out.flush();

        System.out.println("logging in");
        for (int i = 0; i < 1; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {}
            System.out.print(".");
        }

        System.out.print("\033[H\033[2J");  
        System.out.flush();

        String legalName = this.facade.getCurrentUser().getFirstName() + " " + this.facade.getCurrentUser().getLastName();
        System.out.println("logged in as " + legalName);

        if (this.facade.getCurrentUser() instanceof Student)
            studentScreen();
        if (this.facade.getCurrentUser() instanceof Faculty)
            facultyScreen();
    }

    public void studentScreen() {
        while (true) {
            System.out.println("Please choose an option to display: ");
            System.out.println("1. My current courses ");
            System.out.println("2. All my past courses ");
            System.out.println("3. Courses I have left to take ");
            System.out.println("4. Search for a course ");
            System.out.println("5. View my eight-semester plan ");
            System.out.println("6. logout");
            System.out.println("\n\n\nEnter choice: ");

            String choice = this.scanner.nextLine();

            System.out.print("\033[H\033[2J");  
            System.out.flush();

            if (choice.equals("1")) {
                System.out.println(this.facade.formattedStudentCourses(false));
            }
            if (choice.equals("2")) {
                System.out.println(this.facade.formattedStudentCourses(true));
            }
            if (choice.equals("3")) {
                System.out.println(this.facade.formattedStudentCoursesLeft()); // to do
            }
            if (choice.equals("4")) {
                System.out.println("we will handle searching here"); // to do
            }
            if (choice.equals("5")) { // to do
                System.out.println(this.facade.formattedStudentEightSemesterPlan());
            }
            if (choice.equals("6")) {
                this.facade.setCurrentUser(null);
                loginScreen();
            }


            while (true) {
                System.out.println("Enter 'q' to return home: ");
                if (this.scanner.nextLine().equalsIgnoreCase("q")) {
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    break;
                }
            }
        }
    }

    public void facultyScreen() {
        System.out.println("User type: faculty");
    }

    public void createBraxWest() {
        System.out.println("creating Brax West...");

        MajorList majors =  MajorList.getInstance();
        Major computerScience = majors.getMajorByName("Computer Science");

        CourseList courseList = CourseList.getInstance();
        ArrayList<Course> allCourses = courseList.getCoursesByMajor("Computer Science");
        ArrayList<StudentCourse> courses = new ArrayList<StudentCourse>();
        for (Course c : allCourses) {

            // Math.random() returns a double in the set [0, 1)
            Double rand = Math.random();

            StudentCourse sCourse = new StudentCourse(c.getID(), c.getTitle(), c.getHours(),
             c.getSubject(), c.getCourseNumber(), c.getPrereqs(), (rand > .5), (int)(rand * 2), rand * 100);

            courses.add(sCourse);
        }

        ArrayList<String> notes = new ArrayList<String>();
        notes.add("almost graduated!!");

        Student brax = new Student(UUID.fromString("9dee31e4-ed5e-4dc2-bfd1-634c9c9222da"),
        "brax123", "password", "Brax", "West", "junior", computerScience, 3.5, courses, notes);

        System.out.println("created brax");

        ArrayList<Student> allStudents = UserList.getStudents();
        allStudents.add(brax);
        DataWriter.saveStudents(allStudents);

        System.out.println("saved brax");
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
