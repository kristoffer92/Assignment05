package Assignment05.data_access;

import Assignment05.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao {
    private static List<Student> students = new ArrayList<>();
    private static int studentcounter = 1;

    //Save a Student
    @Override
    public Student saveStudent(Student student)
    {
        Student studentWithID = new Student(studentcounter++, student.getName(),student.getEmail(), student.getAddress());
        students.add(studentWithID);
        return studentWithID;
    }

    //Finding a student by ID
    @Override
    public Student findById(int id)
    {
        for(Student studId: students)
        {
            if(id == studId.getId()){
                return studId;
            }
        }
        return null;
    }

    //Finding a student by Name
    @Override
    public List<Student> findByName(String name)
    {
        List<Student> names = new ArrayList<>();
        students.stream().filter(p -> p.getName().equals(name)).forEach(names::add);
        return names;
    }

    //Finding a student by Email
    @Override
    public Student findByEmail(String email)
    {
        for(Student studs:students)
        {
            if(email.equals(studs.getEmail()))
            {
                return studs;
            }

        }return null;

    }

    //Finding all students
    @Override
    public List<Student> findAll()
    {
        return students;
    }

    //Removing a student by ID
    @Override
    public boolean deleteStudent(Student student)
    {
        students.remove(student);
        return true;
    }

}//End of Class
