package Assignment05;

import Assignment05.data_access.CourseDaoList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CoursesTest {

    Course course;
    CourseDaoList dao = new CourseDaoList();

    @Before
    public void init(){
        course = new Course(1,"Testing", LocalDate.of(2019,10,10),4);
    }

    @After
    public void reset()
    {
        course = null;
    }

    @Test
    public void created()
    {
        assertEquals(1, course.getId());
        assertEquals("Testing", course.getCourseName());
        assertEquals(LocalDate.of(2019,10,10), course.getdate());
        assertEquals(4, course.getWeekDuration());
    }

    @Test
    public void testToString()
    {
        String result = course.toString();
        assertTrue(result.contains("Testing"));
        assertTrue(result.contains("2019-10-10"));
        assertTrue(result.contains("4"));
    }

    @Test
    public void testRegisterStudentToCourse()
    {

    }


    @Test
    public void testUnRegisterStudentFromCourse()
    {

    }



}//End of coursesTestClass
