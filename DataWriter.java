import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataWriter extends DataConstants {
    
    //SHOULD WORK
    //NOT TESTED
    public static boolean saveStudents(ArrayList<Student> students) {
    //     UserList listOfStudents = UserList.getInstance();
    //     ArrayList<Student> allStudents = listOfStudents.getStudents();
        JSONArray jsonStudents = new JSONArray();

        for (int i = 0; i < students.size(); i++) {
            jsonStudents.add(getStudentJSON(students.get(i)));
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
        studentDetails.put("id", String.valueOf(student.getID()));
        studentDetails.put("standing", student.getStanding());
        studentDetails.put("firstName", student.getFirstName());
        studentDetails.put("lastName", student.getLastName());
        studentDetails.put("userName", student.getUsername());
        studentDetails.put("password", student.getPassword());
        studentDetails.put("major", student.getMajor().getName());
        studentDetails.put("GPA", String.valueOf(student.getGPA()));

        //Define new JSONArray for the courses key
        // for each Student
        JSONArray coursesToAdd = new JSONArray();

        //Loop through all of the student's courses
        for (int i = 0; i < student.getCourses().size(); i++) {
            //Grabs the current course
            StudentCourse c = (student.getCourses().get(i));
            
            //If the course is taken,
            // create and fill out the JSONObject with the course's info
            if (c.getIsCompleted()) {
                JSONObject courseTaken = new JSONObject();
                courseTaken.put("courseid", String.valueOf(c.getID()));
                courseTaken.put("grade", String.valueOf(c.getGrade()));
                courseTaken.put("attempts", String.valueOf(c.getAttempts()));
                courseTaken.put("isCompleted", String.valueOf(c.getIsCompleted()));

                //Add the course object to the JSONArray
                coursesToAdd.add(courseTaken);
            }
        }
        //Finally, add the JSONArray as the value for "coursesTaken"
        studentDetails.put("coursesTaken", coursesToAdd);
        studentDetails.put("notes", student.getNotes());

        return studentDetails;
    }

    //SHOULD WORK
    //NOT TESTED
    public static boolean saveFaculty(ArrayList<Faculty> faculty) {
        // UserList listOfFaculty = UserList.getInstance();
        // ArrayList<Faculty> allFaculty = listOfFaculty.getFaculty();
        JSONArray jsonFaculty = new JSONArray();

        for (int i = 0; i < faculty.size(); i++) {
            jsonFaculty.add(getFacultyJSON(faculty.get(i)));
        }

        try (FileWriter file = new FileWriter(FACULTY_FILE_PATH)) {
            file.write(jsonFaculty.toJSONString());
            file.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    //SHOULD WORK
    //NOT TESTED
    public static JSONObject getFacultyJSON(Faculty faculty) {
        JSONObject facultyDetails = new JSONObject();

        facultyDetails.put("id", String.valueOf(faculty.getID()));
        facultyDetails.put("firstName", faculty.getFirstName());
        facultyDetails.put("lastName", faculty.getLastName());
        facultyDetails.put("userName", faculty.getUsername());
        facultyDetails.put("password", faculty.getPassword());

        JSONArray assignedStudentIDs = new JSONArray();

        for(Student student : faculty.getAssignedStudents()) {
            assignedStudentIDs.add(student.getID());
        }
        
        facultyDetails.put("assignedStudents", assignedStudentIDs);

        return facultyDetails;
    }
    
    //SHOULD WORK
    //NOT TESTED
    public static boolean saveCourses(ArrayList<Course> courses) {
        // CourseList listOfCourses = CourseList.getInstance();
        // ArrayList<Course> allCourses = listOfCourses.getCourses();
        JSONArray jsonCourses = new JSONArray();

        for (int i = 0; i < courses.size(); i++) {
            jsonCourses.add(getCourseJSON(courses.get(i)));
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
        courseDetails.put("id", String.valueOf(course.getID()));
        courseDetails.put("title", course.getTitle());
        courseDetails.put("courseNumber", String.valueOf(course.getCourseNumber()));
        courseDetails.put("hours", String.valueOf(course.getHours()));
        courseDetails.put("subject", course.getSubject());

        //Had to turn the prereq list into a string for the sake of the JSON and
        // because dataloader was already written with it as a string.
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < course.getPrereqs().size(); i++) {
            str.append(course.getPrereqs().get(i)).append("&");
        }
        courseDetails.put("prereqs", str);

        return courseDetails;
    }

    //SHOULD WORK
    //NOT TESTED
    public static boolean saveMajors(ArrayList<Major> majors) {
        // MajorList listOfMajors = MajorList.getInstance();
        // ArrayList<Major> allMajors = listOfMajors.getMajors();
        JSONArray jsonMajors = new JSONArray();

        for (int i = 0; i < majors.size(); i++) {
            jsonMajors.add(getMajorJSON(majors.get(i)));
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
        majorDetails.put("id", String.valueOf(major.getID()));
        majorDetails.put("name", major.getName());
        majorDetails.put("type", major.getType());
        majorDetails.put("hours", String.valueOf(major.getHours()));

        JSONArray majorClassJSON = new JSONArray();
        JSONArray majorElectJSON = new JSONArray();

        for (Course course : major.getMajorRequirements()) {
            majorClassJSON.add(course.getTitle() + String.valueOf(course.getCourseNumber()));
        }
        for (Course course : major.getElectiveCourseReqs()) {
            majorElectJSON.add(course.getTitle() + String.valueOf(course.getCourseNumber()));
        }

        majorDetails.put("majorreq", majorClassJSON);
        majorDetails.put("electivereq", majorElectJSON);

        return majorDetails;
    }
}
