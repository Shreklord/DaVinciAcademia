import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public class FacadeTest {
    private Facade facade;
    
    @Before
    public void Setup() {
        facade = new Facade();
    }

    @Test
    public void loginTest() {
        Student user = DataLoader.getStudents().get(0);
        boolean login = facade.login(user.getUsername(), user.getPassword());
        assertTrue(login);
    }

    @Test
    public void loginTestInvalid() {
        boolean login = facade.login("fake", "fake");
        User currentUser = facade.getCurrentUser();
        assertNull(currentUser);
        assertEquals(false, login);
    }

    @Test
    public void getEightSemesterPlanTest() {
        Student user = DataLoader.getStudents().get(0);
        ArrayList<Course> plan = facade.getEightSemesterPlan(user.getID());
        assertNotNull(plan);
    }

    @Test
    public void getEightSemesterPlanTestInvalid() {
        ArrayList<Course> plan = facade.getEightSemesterPlan(UUID.randomUUID());
        assertNull(plan);
    }

    @Test
    public void formattedStudentCoursesTest() {
        Student user = DataLoader.getStudents().get(0);
        String formattedCourses = facade.formattedStudentCourses(user, true);
        assertNotNull(formattedCourses);
    }

    @Test
    public void formattedStudentCoursesTestInvalid() {
        Student randomUser = new Student(null, "null", "null", null, null, null, null, 0, null, null);
        String formattedCourses = facade.formattedStudentCourses(randomUser, true);
        assertNull(formattedCourses);
    }

    @Test
    public void formattedStudentCoursesLeftTest() {
        Student user = DataLoader.getStudents().get(0);
        String formattedCourses = facade.formattedStudentCoursesLeft(user);
        assertNotNull(formattedCourses);
    }

    @Test
    public void formattedStudentCoursesLeftTestInvalid() {
        Student randomUser = new Student(UUID.randomUUID(), "fake", "fake", "fake", "fake", "freshman", new Major(null, "fake", null, 0, null, null), 0.0, new ArrayList<StudentCourse>(), new ArrayList<String>());
        String formattedCourses = facade.formattedStudentCoursesLeft(randomUser);
        assertNull(formattedCourses);
    }

    @Test
    public void formattedStudentEightSemesterPlanTest() {
        Student user = DataLoader.getStudents().get(0);
        facade.setCurrentUser(user);
        String formattedPlan = facade.formattedStudentEightSemesterPlan();
        assertNotNull(formattedPlan);
    }


    
}
