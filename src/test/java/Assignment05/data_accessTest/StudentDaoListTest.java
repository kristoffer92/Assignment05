package Assignment05.data_accessTest;

import Assignment05.Student;
import Assignment05.data_access.StudentDaoList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoListTest {
    //Arrange
    //Act
    //Assert

    private StudentDaoList testStudentDaoList;
    private Student testStudent;
    private Student testStudentWithId;
    private final String testName = "Kristoffer";
    private final String testEmail = "kristoffer@hotmail.com";
    private final String testAdress = "Fiskvägen 10";
    private List<Student> testList = new ArrayList<>();


    @Before
    public void makeBefore()
    {
        testStudentDaoList = new StudentDaoList();
        testStudent = new Student(testName,testEmail,testAdress);
        testStudentWithId = testStudentDaoList.saveStudent(testStudent);
        testList.add(testStudent);
    }

    @After
    public void makeAfter()
    {
        testStudentDaoList = null;
    }

    @Test
    public void testFindByIdExist()
    {
        assertEquals(testStudentWithId, testStudentDaoList.findById(testStudentWithId.getId()));
    }

    @Test
    public void testFindByIdNotExist()
    {
        assertNull(testStudentDaoList.findById(Integer.MAX_VALUE));
    }

    @Test
    public void testFindByNameExist()
    {
        assertEquals(testStudentDaoList.findByName(testName), testStudentDaoList.findByName(testStudent.getName()));
    }

    @Test
    public void testFindByEmail()
    {
        assertEquals(testStudentDaoList.findByEmail(testEmail), testStudentDaoList.findByEmail(testStudent.getEmail()));
    }

    @Test
    public void testFindByAll()
    {
        assertEquals(testStudentDaoList.findAll().get(0), testStudentDaoList.findById(1));
    }

    @Test
    public void testRemoveStudent()
    {

    }

}
