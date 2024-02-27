import java.util.ArrayList;
import java.util.UUID;

public class MajorList {
    private static MajorList majorList;
    private static ArrayList<Major> majors = new ArrayList<Major>();

    public MajorList() {}

    public ArrayList<Major> getMajors() {
        return majors;
    }   

    public static void setMajors(ArrayList<Major> majorsList) {
        majors = majorsList;
    }

    public static MajorList getInstance() {
        if (majorList == null) {
            majorList = new MajorList();
            setMajors(DataLoader.getMajors());
        }
        return majorList;
    }

    public static Major getMajorByName(String major) {
        for (Major m : majors) {
            if (m.getName().equals(major)) {
                return m;
            }
        }
        return null;
    }

    /**
     * @param String
     * @return major
     */
    public Major getByUUID(String id) {
        for (Major m : majors) {
            if (m.getID().toString() == id)
                return m;
        }
        return null;
    }
}
