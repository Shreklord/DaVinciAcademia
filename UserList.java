import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static UserList userList;
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<Student>();
    private static ArrayList<Faculty> faculty = new ArrayList<Faculty>();
    
    private UserList(){

    }

    public static UserList getInstance(){
        if (userList == null) {
            userList = new UserList();
            students = DataLoader.getStudents();
            faculty = DataLoader.getFaculty();
        }
        return userList;
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<Faculty> getFaculty() {
        return faculty;
    }

    public User getUser(String userName){
        for(int i = 0; i < users.size(); i++){
            User user = users.get(i);
            if(user.getUsername().equals(userName)){
                return user;
            }
        }
        return null;
    }

    public User getUser(UUID id){
        for(int i = 0; i < users.size(); i++){
            User user = users.get(i);
            if(user.getID().equals(id)){
                return user;
            }
        }
        return null;
    }

    public Student getStudentByID(UUID id) {
        for (int i = 0; i < students.size(); i++)  {
            Student s = students.get(i);
            if (s.getID().equals(id))
                return s;
        }
        return null;
    }



    public void setInstance(UserList userList){
        UserList.userList = userList;
    }
}
