import java.util.ArrayList;
import java.util.UUID;

public class Major {
    private UUID id;
    private String name;
    private String type;
    private int hours;
    private ArrayList<Course> majorRequirements;
    private ArrayList<Course> electiveCourseReq;
    private int reccomendedSemester;

    public Major(UUID id, String name, String type, int hours, ArrayList<Course> majorReqs, ArrayList<Course> electiveReqs, int reccomendedSemester) {
        setID(id);
        setName(name);
        setType(type);
        setHours(hours);
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

    public int getReccomendedSemester() {
        return this.reccomendedSemester;
    }
}
