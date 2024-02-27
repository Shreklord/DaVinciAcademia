import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

    /**
     * NOT FINISHED
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
                String firstName = (String)studentJSON.get("firstName");
                String lastName = (String)studentJSON.get("lastName");
                String userName = (String)studentJSON.get("userName");
                String password = (String)studentJSON.get("password");
                double GPA = Double.parseDouble((String)studentJSON.get("GPA"));
                Major major = MajorList.getMajorByName((String)studentJSON.get("major")); // not working

               
                ArrayList<StudentCourse> coursesTaken = new ArrayList<StudentCourse>();
                JSONArray courseArray = (JSONArray)studentJSON.get("coursesTaken");
                for (int j = 0; j < courseArray.size(); j++) {
                    JSONObject courseJSON = (JSONObject)courseArray.get(j);
                    String courseID = (String)courseJSON.get("courseid");
                    Double courseGrade = Double.parseDouble((String)courseJSON.get("grade"));
                    int attempts = Integer.parseInt((String)courseJSON.get("attempts"));
                    boolean isCompleted = Boolean.parseBoolean((String)courseJSON.get("isCompleted"));

                    CourseList list = CourseList.getInstance();
                    Course c = list.getByUUID(courseID);

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
                            major, GPA, coursesTaken, notesList));

            }
        
            // finished but not tested - almost 100% likely its not working

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static ArrayList<Faculty> getFaculty() {
        return null;
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