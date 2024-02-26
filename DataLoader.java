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
                UUID id = (UUID)studentJSON.get("id"); 
                String standing = (String)studentJSON.get("standing");
                String firstName = (String)studentJSON.get("firstName");
                String lastName = (String)studentJSON.get("lastName");
                String userName = (String)studentJSON.get("userName");
                String password = (String)studentJSON.get("password");
                double GPA = (double)studentJSON.get("GPA");
                String coursesTaken = (String)studentJSON.get("coursesTaken");  
            }

        
            // UNFINISHED AND NOT WORKING

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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
        return null;
    }

}