import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Faculty> faculty = new ArrayList<Faculty>();
    
    private UserList(){
        users = DataLoader.getUsers();
        students = DataLoader.getStudents();
        faculty = DataLoader.getFaculty();
    }

    public UserList getInstance(){
        return userList;
    }

    public User getUser(String userName){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equals(userName)){
                return users.get(i);
            }
        }
        return null;
    }

    public User getUser(UUID id){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getID().equals(id)){
                return users.get(i);
            }
        }
        return null;
    }

    public void setInstance(UserList userList){
        UserList.userList = userList;
    }
}
