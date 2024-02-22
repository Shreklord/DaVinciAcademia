import java.util.ArrayList;
import java.util.UUID;

public class Course {
    private UUID id;
    private int hours;
    private String subject;
    private int coursenumber;
    private ArrayList<String> prereqs;

    public Course(UUID id, int hours, String subject, int coursenumber, ArrayList<String> prereqs){
        this.id = id;
        this.hours = hours;
        this.subject = subject;
        this.coursenumber = coursenumber;
        this.prereqs = prereqs;
    }

    public ArrayList<String> getPrereqs(){
        return this.prereqs;
    }

    public void setPrereqs(ArrayList<String> prereqs){
        this.prereqs = prereqs;
    }

    public int getCourseNumber(){
        return this.coursenumber;
    }

    public void setCourseNumber(int coursenumber){
        this.coursenumber = coursenumber;
    }

    public String getSubject(){
        return this.subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public int getHours(){
        return this.hours;
    }

    public void setHours(int hours){
        this.hours = hours;
    }

    public UUID getID(){
        return this.id;
    }




}
