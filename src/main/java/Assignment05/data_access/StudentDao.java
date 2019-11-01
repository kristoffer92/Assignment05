package Assignment05.data_access;

import Assignment05.Student;

import java.util.List;

public interface StudentDao {
    Student saveStudent(Student student);
    Student findByEmail(String email);
    List<Student> findByName(String name);
    Student findById(int id);
    List<Student>findAll();
    boolean deleteStudent(Student student);
}//End of Class
