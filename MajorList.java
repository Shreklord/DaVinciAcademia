import java.util.ArrayList;
import java.util.UUID;

public class MajorList {
    private MajorList majorList;
    private ArrayList<Major> majors = new ArrayList<Major>();

    public MajorList() {
        this.setMajors(majors);
    }

    public MajorList getMajorList() {
        return majorList;
    }

    public ArrayList<Major> getMajors() {
        return majors;
    }   

    public void setMajorList(MajorList majorList) {
        this.majorList = majorList;
    }

    public void setMajors(ArrayList<Major> majors) {
        this.majors = majors;
    }

    public MajorList getInstance() {
        return null;
    }

    public Major getMajor(String major) {
        return null;
    }

    public Major getByUUID(UUID id) {
        return null;
    }
}
