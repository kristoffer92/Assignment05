package Assignment05.data_access;

import Assignment05.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoList implements CourseDao{
    private static List<Course> courses = new ArrayList<>();
    private static int coursecounter = 1;

    @Override
    public Course saveCourse(Course course)
    {
        Course coursewithID = new Course(coursecounter++, course.getCourseName(), course.getdate(), course.getWeekDuration());
        courses.add(coursewithID);
        return coursewithID;
    }

    @Override
    public Course findById(int id)
    {
        for(Course CourseId: courses)
        {
            if(id == CourseId.getId()){
                return CourseId;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name)
    {
        List<Course> findNames = new ArrayList<>();
        courses.stream().filter(p -> p.getCourseName().equals(name)).forEach(findNames::add);
        return findNames;
    }

    @Override
    public List<Course> findByDate(LocalDate date)
    {
        List<Course> findDates = new ArrayList<>();
        courses.stream().filter(p -> p.getdate().equals(date)).forEach(findDates::add);
        return findDates;
    }

    @Override
    public List<Course> findAll()
    {
        return courses;
    }

    //Removing a course
    @Override
    public boolean removeCourse(Course course)
    {
        courses.remove(course);
        return true;
    }

}//End of Class
