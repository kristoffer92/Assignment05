package Assignment05;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentsTest {



    Student student;


    @Before
    public void init(){

        student = new Student(1,"Kristoffer","kristoffer@hotmail.com","Fiskvägen 18");
    }

    @After
    public void reset()
    {
        student = null;
    }


    @Test
    public void created()
    {
        assertEquals(1, student.getId());
        assertEquals("Kristoffer", student.getName());
        assertEquals("kristoffer@hotmail.com", student.getEmail());
        assertEquals("Fiskvägen 18", student.getAddress());
    }

    @Test
    public void testToString()
    {
        String result = student.toString();
        assertTrue(result.contains("1"));
        assertTrue(result.contains("Kristoffer"));
        assertTrue(result.contains("kristoffer@hotmail.com"));
        assertTrue(result.contains("Fiskvägen 18"));

    }


}//End of studentsTestClass
