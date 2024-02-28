import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataWriter extends DataConstants {
    // ArrayList<Student> students = new ArrayList<Student>();
    // ArrayList<Faculty> faculty = new ArrayList<Faculty>();
    // ArrayList<Course> courses = new ArrayList<Course>();
    
    public static boolean saveStudents() {
        try {
            FileWriter writer = new FileWriter(STUDENT_FILE_PATH);
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
        }
        return false;
    }
    public static boolean saveStudent(Student student) {
        return true;
    }

    //NOT WORKING BECAUSE getFacultyJSON() isn't.
    //NOT TESTED
    public static boolean saveFaculty() {
        UserList listOfFaculty = UserList.getInstance();
        ArrayList<Faculty> allFaculty = listOfFaculty.getFaculty();
        JSONArray jsonFaculty = new JSONArray();

        for (int i = 0; i < allFaculty.size(); i++) {
            jsonFaculty.add(getFacultyJSON(allFaculty.get(i)));
        }

        try (FileWriter file = new FileWriter(COURSE_FILE_PATH)) {
            file.write(jsonFaculty.toJSONString());
            file.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    //NOT WORKING 
    //NOT TESTED
    public static JSONObject getFacultyJSON(Faculty faculty) {
        JSONObject facultyDetails = new JSONObject();
        facultyDetails.put("id", faculty.getID());
        facultyDetails.put("firstName", faculty.getfirstName());
        facultyDetails.put("lastName", faculty.getLastName());
        facultyDetails.put("userName", faculty.getUsername());
        facultyDetails.put("password", faculty.getPassword());

        //NOT WORKING BECAUSE OF THIS BUT I CAN FIX IT PROBABLY MAYBE
        // getAssignedStudents() returns an arraylist. We will have to loop through each and
        // get the id from each then append it to the array inside of the json, 
        // but it is a nested array so it could be funky. Also might have to create
        // a new array each time and then update it because Arrays cannot change length
        // dynamically in java booooooooo.
        facultyDetails.put("assignedStudents", faculty.getAssignedStudents());

        return facultyDetails;
    }
    //SHOULD WORK
    //NOT TESTED
    public static boolean saveCourses() {
        CourseList listOfCourses = CourseList.getInstance();
        ArrayList<Course> allCourses = listOfCourses.getCourses();
        JSONArray jsonCourses = new JSONArray();

        for (int i = 0; i < allCourses.size(); i++) {
            jsonCourses.add(getCourseJSON(allCourses.get(i)));
        }

        try (FileWriter file = new FileWriter(COURSE_FILE_PATH)) {
            file.write(jsonCourses.toJSONString());
            file.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static JSONObject getCourseJSON(Course course) {
        JSONObject courseDetails = new JSONObject();
        courseDetails.put("id", course.getID());
        courseDetails.put("title", course.getTitle());
        courseDetails.put("courseNumber", course.getCourseNumber());
        courseDetails.put("hours", course.getHours());
        courseDetails.put("subject", course.getSubject());
        courseDetails.put("prereqs", course.getPrereqs());

        return courseDetails;
    }

    //SHOULD WORK
    //NOT TESTED
    public static boolean saveMajors() {
        MajorList listOfMajors = MajorList.getInstance();
        ArrayList<Major> allMajors = listOfMajors.getMajors();
        JSONArray jsonMajors = new JSONArray();

        for (int i = 0; i < allMajors.size(); i++) {
            jsonMajors.add(getMajorJSON(allMajors.get(i)));
        }

        try (FileWriter file = new FileWriter(MAJOR_FILE_PATH)) {
            file.write(jsonMajors.toJSONString());
            file.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static JSONObject getMajorJSON(Major major) {
        JSONObject majorDetails = new JSONObject();
        majorDetails.put("id", major.getID());
        majorDetails.put("name", major.getName());
        majorDetails.put("type", major.getType());
        majorDetails.put("hours", major.getHours());
        majorDetails.put("majorreq", major.getMajorRequirements());
        majorDetails.put("electivereq", major.getElectiveCourseReqs());

        return majorDetails;
    }
}
