import java.util.ArrayList;
import java.util.UUID;

public class Course {
    private UUID id;
    private int hours;
    private String subject;
    private int coursenumber;
    private ArrayList<String> prereqs;

    public Course(int hours, String subject, int coursenumber, ArrayList<String> prereqs){

    }

    public ArrayList<Course> getPrereqs(){
        return null;
    }

}
