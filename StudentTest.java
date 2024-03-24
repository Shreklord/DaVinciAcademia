import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.UUID;
import java.beans.Transient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTest {
    
    @BeforeEach
    public void setup() {
    }

    @AfterEach
    public void tearDown() {
        // runs after each test
    }

    @Test
    public void displayEightSemesterPlanTest() {
        // test the displayEightSemesterPlan method
        // create a new student
        DataLoader dl = new DataLoader();  
        Student student = dl.getStudents().get(0);
        ArrayList<Course> plan = student.displayEightSemesterPlan();
        assertNotNull(plan);
    }

    @Test void displayEightSemesterPlanInvalidTest() {
        // test the displayEightSemesterPlan method with an invalid student
        Student student = new Student(UUID.randomUUID(), null, "password", "first", "last", null, new Major(null, null, null, 0, null, null), 4.0, new ArrayList<StudentCourse>(), new ArrayList<String>());
        ArrayList<Course> plan = student.displayEightSemesterPlan();
        assertNull(plan);
    }
}
