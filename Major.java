import java.util.ArrayList;
import java.util.UUID;

public class Major {
    private UUID id;
    private String name;
    private String type;
    private String college;
    private ArrayList<Course> majorRequirements;
    private ArrayList<Course> electiveCourseReq;

    public Major(String name, String type, String college) {
        setID(id);
        setName(name);
        setType(type);
        setCollege(college);
        setMajorRequirements();
        setElectiveCourseReqs();
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
        return this.getMajorRequirements();
    }

    private void setMajorRequirements() {

    }

    public ArrayList<Course> getElectiveCourseReqs() {
        return this.electiveCourseReq;
    }

    private void setElectiveCourseReqs() {

    }




}
