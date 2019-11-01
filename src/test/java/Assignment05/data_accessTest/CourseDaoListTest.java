package Assignment05.data_accessTest;

import Assignment05.Course;
import Assignment05.data_access.CourseDaoList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CourseDaoListTest {

    //Arrange
    //Act
    //Assert

    private CourseDaoList testCourseDaoList;
    private Course testCourse;
    private Course testCourseWithId;
    private final String testName = "Kristoffer";
    private final LocalDate testDate = LocalDate.of(2019,10,10);
    private final int testWeekDuration = 4;
    private List<Course> testList = new ArrayList<>();


    @Before
    public void makeBefore()
    {
        testCourseDaoList = new CourseDaoList();
        testCourse = new Course(testName,testDate,testWeekDuration);
        testCourseWithId = testCourseDaoList.saveCourse(testCourse);
        testList.add(testCourse);
    }

    @After
    public void makeAfter()
    {
        testCourseDaoList = null;
    }

    @Test
    public void testFindByIdExist()
    {
        assertEquals(testCourseWithId, testCourseDaoList.findById(testCourseWithId.getId()));
    }

    @Test
    public void testFindByIdNotExist()
    {
        assertNull(testCourseDaoList.findById(Integer.MAX_VALUE));
    }

    @Test
    public void testFindByNameExist()
    {
        assertEquals(testCourseDaoList.findByName(testName), testCourseDaoList.findByName(testCourse.getCourseName()));
    }

    @Test
    public void testFindByDate()
    {
        assertEquals(testCourseDaoList.findByDate(testDate), testCourseDaoList.findByDate(LocalDate.of(2019,10,10)));
    }

    @Test
    public void testFindByDateNoExist()
    {
        assertTrue(testCourseDaoList.findByDate(LocalDate.of(1111,1,11)).isEmpty());
    }

    @Test
    public void testFindByAll()
    {
        assertEquals(testCourseDaoList.findAll().get(0), testCourseDaoList.findById(1));
    }

    @Test
    public void testRemoveCourse()
    {

    }

}
