import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataWriter extends DataConstants {
    
    public static boolean saveStudents() {
        UserList listOfStudents = UserList.getInstance();
        ArrayList<Student> allStudents = listOfStudents.getStudents();
        JSONArray jsonStudents = new JSONArray();

        for (int i = 0; i < allStudents.size(); i++) {
            jsonStudents.add(getStudentJSON(allStudents.get(i)));
        }

        try {
            
            try (FileWriter file = new FileWriter(STUDENT_FILE_PATH)) {
            file.write(jsonStudents.toJSONString());
            file.flush();

            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static JSONObject getStudentJSON(Student student) {
        JSONObject studentDetails = new JSONObject();
        studentDetails.put("id", student.getID());
        studentDetails.put("standing", student.getStanding());
        studentDetails.put("firstName", student.getfirstName());
        studentDetails.put("lastName", student.getLastName());
        studentDetails.put("userName", student.getUsername());
        studentDetails.put("password", student.getPassword());
        studentDetails.put("major", student.getMajor());
        studentDetails.put("GPA", student.getGPA());
        studentDetails.put("coursesTaken", student.getCoursesTaken());
        studentDetails.put("notes", student.getNotes());


        return studentDetails;
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
