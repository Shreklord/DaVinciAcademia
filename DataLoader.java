import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

    /**
     * FINISHED AND WORKING AS OF 2/28/2024
     * Spencer Philips and Anthony GoldHammer
     */
    public static ArrayList<Student> getStudents() {

        ArrayList<Student> students = new ArrayList<Student>();
        try {
            FileReader reader = new FileReader(STUDENT_FILE_PATH);
            JSONArray studentsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < studentsJSON.size(); i++) {
                JSONObject studentJSON = (JSONObject)studentsJSON.get(i); 
                UUID id = UUID.fromString((String)studentJSON.get("id"));
                String standing = (String)studentJSON.get("standing");
                String firstName = (String)studentJSON.get("firstName"); // loading in all the data for our student obj
                String lastName = (String)studentJSON.get("lastName");
                String userName = (String)studentJSON.get("userName");   
                String password = (String)studentJSON.get("password");
                double GPA = Double.parseDouble((String)studentJSON.get("GPA"));
                Major major = MajorList.getMajorByName((String)studentJSON.get("major")); // shoudnt this not work because MajorList could be null?
                                                                                              // we might need a getInstance()
               
                ArrayList<StudentCourse> coursesTaken = new ArrayList<StudentCourse>();
                JSONArray courseArray = (JSONArray)studentJSON.get("coursesTaken"); // here we are handling the courses

                for (int j = 0; j < courseArray.size(); j++) {
                    JSONObject courseJSON = (JSONObject)courseArray.get(j);
                    String courseID = (String)courseJSON.get("courseid");
                    Double courseGrade = Double.parseDouble((String)courseJSON.get("grade"));
                    int attempts = Integer.parseInt((String)courseJSON.get("attempts"));
                    boolean isCompleted = Boolean.parseBoolean((String)courseJSON.get("isCompleted"));

                    CourseList list = CourseList.getInstance();
                    Course c = list.getByUUID(courseID); // get our course information by the id

                    coursesTaken.add(new StudentCourse(c.getID(), c.getTitle(), c.getHours(),
                                                       c.getSubject(), c.getCourseNumber(),
                                                       c.getPrereqs(), isCompleted, attempts, courseGrade));
                }


                String[] notes = ((String)studentJSON.get("notes")).split("/");
                ArrayList<String> notesList = new ArrayList<String>();
                for (String note : notes) {
                    notesList.add(note);
                }

                students.add(new Student(id, userName, password,
                            firstName, lastName, standing,
                            major, GPA, coursesTaken, notesList)); // add our new student to the returned arrayList

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    /**
     * working and tested as of 2/29/2024
     */
    public static ArrayList<Faculty> getFaculty() {
        ArrayList<Faculty> faculty = new ArrayList<Faculty>();
        try {
            FileReader reader = new FileReader(FACULTY_FILE_PATH);
            JSONArray facultyJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < facultyJSON.size(); i++) {
                JSONObject facJSON = (JSONObject)facultyJSON.get(i);
                UUID id = UUID.fromString((String)facJSON.get("id"));
                String firstName = (String)facJSON.get("firstName");
                String lastName = (String)facJSON.get("lastName");
                String userName = (String)facJSON.get("userName");
                String password = (String)facJSON.get("password");
                String[] studentsArray = ((String)facJSON.get("assignedStudents")).split("&&");

                ArrayList<Student> studentsList = new ArrayList<Student>();
                UserList list = UserList.getInstance();
                for (String s : studentsArray) {
                    UUID studentID = UUID.fromString(s);
                    Student student = list.getStudentByID(studentID);
                    if (student != null)
                        studentsList.add(student);
                }

                faculty.add(new Faculty(id, userName, password, firstName, lastName, studentsList));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return faculty;
    }

    /**
     * FINISHED AND WORKING AS OF 2/26/2024
     * Spencer Philips and Anthony Goldhammer
     */
    public static ArrayList<Course> getCourses() {
        
        ArrayList<Course> courses = new ArrayList<>();
        try {
            FileReader reader = new FileReader(COURSE_FILE_PATH);
            JSONArray coursesJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i <coursesJSON.size(); i++) {
                JSONObject courseJSON = (JSONObject)coursesJSON.get(i);
                UUID id = UUID.fromString((String)courseJSON.get("id"));
                String title = (String)courseJSON.get("title");
                int courseNumber = Integer.parseInt((String)courseJSON.get("courseNumber"));
                int hours = Integer.parseInt((String)courseJSON.get("hours"));
                String subject = (String)courseJSON.get("subject");
                String prereqs = (String)courseJSON.get("prereqs");

                ArrayList<String> preqArrayList = new ArrayList<String>();
                for (String prereq : prereqs.split("&"))
                    preqArrayList.add(prereq);
                
                courses.add(new Course(id, title, hours, subject, courseNumber, preqArrayList));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }

    /**
     * FINISHED AND WORKING AS OF 2/27/2024
     * Spencer Philips and Anthony Goldhammer
     */
    public static ArrayList<Major> getMajors() {

        ArrayList<Major> majors = new ArrayList<Major>();
        try {
            FileReader reader = new FileReader(MAJOR_FILE_PATH);
            JSONArray majorsJSON = (JSONArray)new JSONParser().parse(reader);
            for (int i = 0; i < majorsJSON.size(); i++) {
                JSONObject majorJSON = (JSONObject)majorsJSON.get(i);

                UUID id = UUID.fromString((String)majorJSON.get("id"));
                String name = (String)majorJSON.get("name");
                String type = (String)majorJSON.get("type");
                int hours = Integer.parseInt((String)majorJSON.get("hours"));
                String[] requirements = ((String)majorJSON.get("majorreq")).split("&"); // split
                String[] electiveRequirements = ((String)majorJSON.get("electivereq")).split("&"); //split

                CourseList list = CourseList.getInstance(); // here we create our instance variables to be used
                ArrayList<Course> requirementsList = new ArrayList<Course>(); 
                ArrayList<Course> electiveRequirementsList = new ArrayList<Course>();

                // iterate through the list of requirements and search in CourseList to convert into courses
                for (int j = 0; j < requirements.length; j++) {
                    String title = requirements[j].substring(0, 4);
                    int courseNumber = Integer.parseInt(requirements[j].substring(4, 7));

                    Course foundCourse = list.getByTitleAndNumber(title, courseNumber);
                    if (foundCourse != null)
                        requirementsList.add(foundCourse);
                }

                // iterate through the list of requirements and search in CourseList to convert into courses
                for (int j = 0; j < electiveRequirements.length; j++) {
                    String title = electiveRequirements[j].substring(0, 4);
                    int courseNumber = Integer.parseInt(electiveRequirements[j].substring(4, 7));

                    Course foundCourse = list.getByTitleAndNumber(title, courseNumber);
                    if (foundCourse != null)
                        electiveRequirementsList.add(foundCourse);
                }

                majors.add(new Major(id, name, type, hours, requirementsList, electiveRequirementsList));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return majors;
    }

}