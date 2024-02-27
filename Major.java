import java.util.ArrayList;
import java.util.UUID;

public class Major {
    private UUID id;
    private String name;
    private String type;
    private String college;
    private int hours;
    private ArrayList<Course> majorRequirements;
    private ArrayList<Course> electiveCourseReq;

    public Major(UUID id, String name, String type, String college, int hours, ArrayList<Course> majorReqs, ArrayList<Course> electiveReqs) {
        setID(id);
        setName(name);
        setType(type);
        setHours(hours);
        setCollege(college);
        setMajorRequirements(majorReqs);
        setElectiveCourseReqs(electiveReqs);
    }

    public int getHours() {
        return this.hours;
    }
    
    public void setHours(int hours) {
        this.hours = hours;
    }

    public UUID getID() {
        return this.id;
    }

    private void setID(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCollege() {
        return this.college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public ArrayList<Course> getMajorRequirements() {
        return this.majorRequirements;
    }

    private void setMajorRequirements(ArrayList<Course> reqs) {
        this.majorRequirements = reqs;
    }

    public ArrayList<Course> getElectiveCourseReqs() {
        return this.electiveCourseReq;
    }

    private void setElectiveCourseReqs(ArrayList<Course> reqs) {
        this.electiveCourseReq = reqs;
    }




}
