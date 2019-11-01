package Assignment05;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course extends SchoolProject
{
    private int id;
    private String CourseName;
    private LocalDate date;
    private int weekDuration;
    private List<Student> liststudents = new ArrayList<>();

    public Course(int id, String courseName, LocalDate date, int weekDuration)
    {
        this(courseName,date,weekDuration);
        this.id=id;
    }
    public Course(String courseName, LocalDate date, int weekDuration)
    {
        setCourseName(courseName);
        setStartDate(date);
        setWeekDuration(weekDuration);
    }

    //Getters
    public int getId()
    {
        return id;
    }

    public String getCourseName()
    {
        return CourseName;
    }

    public LocalDate getdate()
    {
        return date;
    }

    public int getWeekDuration()
    {
        return weekDuration;
    }


    public void setCourseName(String courseName)
    {
        CourseName = courseName;
    }

    public void setStartDate(LocalDate startDate)
    {
        this.date = startDate;
    }

    public void setWeekDuration(int weekDuration)
    {
        this.weekDuration = weekDuration;
    }


    //Register,Remove students
    public void register(Student student)
    {
        this.liststudents.add(student);
    }

    public void unregister(Student student)
    {
        this.liststudents.remove(student);
    }

    //Override toString
    @Override
    public String toString()
    {
        return "\nCourses: " +
                " Id: " + id + "|"+
                " CourseName: " + CourseName+
                " StartDate: " + date+
                " WeekDuration: " + weekDuration+"\n";
    }
}//End of Class
