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
            JSONParser parser = new JSONParser();
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

                //Major major = (Major)studentJSON.get("major"); // not working
                //String coursesTaken = studentJSON.get("coursesTaken"); // ???
                

                String currentCourses = (String)studentJSON.get("currentCourses"); // split
                String notes = (String)studentJSON.get("notes"); // split

                students.add(new Student(id, userName, password,
                         firstName, lastName, standing,
                         null, GPA, null, null, null));

            }
        
            // UNFINISHED AND NOT WORKING

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
     * Spencer Philips
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
    public ArrayList<Major> getMajors() {

        ArrayList<Major> majors = new ArrayList<Major>();
        try {
            FileReader reader = new FileReader(COURSE_FILE_PATH);
            JSONArray majorsJSON = (JSONArray)new JSONParser().parse(reader);
            for (int i = 0; i < majorsJSON.size(); i++) {
                JSONObject majorJSON = (JSONObject)majorsJSON.get(i);

                UUID id = UUID.fromString((String)majorJSON.get("id"));
                String name = (String)majorJSON.get("name");
                String type = (String)majorJSON.get("type");
                int hours = Integer.parseInt((String)majorJSON.get("hours"));
                String[] requirements = ((String)majorJSON.get("majorreq")).split("&"); // split
                String[] electiveRequirements = ((String)majorJSON.get("electivereq")).split("&"); //split

                CourseList list = CourseList.getInstance();
                ArrayList<Course> requirementsList = new ArrayList<Course>();

                // NOT FINISHED AND NOT WORKING
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



        return majors;
    }

}