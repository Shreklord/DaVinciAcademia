import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataWriter extends DataConstants {
    
    public boolean saveStudents() {
        try {
            FileWriter fileWriter = new FileWriter(STUDENT_FILE_PATH);
            // JSONParser parser = new JSONParser();
            // JSONArray studentsJSON = (JSONArray)new JSONParser().parse(reader);

            //Gets student list from UserList.java
            ArrayList<Student> students = UserList.getStudents();

            JSONObject jStudent = new JSONObject();
            for(Student student: students) {
                jStudent.put("id", student.getID());
                jStudent.put("standing", student.getStanding());
                jStudent.put("firstname", student.getFirstName());
                jStudent.put("lastname", student.getLastName());
                jStudent.put("username", student.getUsername());
                jStudent.put("password", student.getPassword());
                jStudent.put("major", student.getMajor());
                jStudent.put("GPA",student.getGPA());

            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean saveStudent(Student student) {
        return true;
    }

    public boolean saveFaculty() {
        return true;
    }
    public boolean saveFacultySingular() {
        return true;
    }

    public boolean saveCourses() {
        return true;
    }

    public boolean saveCourse(Course course) {

        JSONObject jsonCourse = new JSONObject();

        return true;
    }

    public boolean saveMajors() {
        return true;
    }

    public boolean saveMajor() {
        return true;
    }
}
