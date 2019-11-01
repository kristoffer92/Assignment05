package Assignment05;

import Assignment05.data_access.CourseDao;
import Assignment05.data_access.CourseDaoList;
import Assignment05.data_access.StudentDao;
import Assignment05.data_access.StudentDaoList;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class SchoolControl {
    private static Scanner scanner = new Scanner(System.in);
    private StudentDao studentslist = new StudentDaoList();
    private CourseDao courselist = new CourseDaoList();


    public void makeFirstInfoMenu() {
        boolean keepAlive = true;
            while (keepAlive) {
                try{
                System.out.println("-----SchoolProject-----");
                System.out.println("1. SchoolControl");
                System.out.println("2. Show all students and courses");
                System.out.println("3. Quit");
                System.out.println("-----------------------");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        makeSchoolControlMenu();
                        break;
                    case 2:
                        makeShowStudentsAndCourses();
                        break;
                    case 3:
                        keepAlive = false;
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }//End of switch
            }catch(NumberFormatException e)
                {
                    System.out.println("Please follow the numbers within the menu.");
                }
        }
    }

    private void makeSchoolControlMenu()
    {
        boolean keepControl = true;
        while(keepControl) {
            try {
                System.out.println("-----SchoolControl-----");
                System.out.println("1. StudentControl");
                System.out.println("2. CourseControl");
                System.out.println("3. Register a Student to a Course");
                System.out.println("4. Remove a Student from a Course");
                System.out.println("5. SchoolProject Menu");
                System.out.println("-----------------------");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        makeStudentControl();
                        break;
                    case 2:
                        makeCourseControl();
                        break;
                    case 3:
                        registerStudentToCourse();
                        break;
                    case 4:
                        removeStudentFromCourse();
                        break;
                    case 5:
                        keepControl = false;
                        break;
                    default:
                        System.out.println("Make a choice within the menu.");
                        break;
                }//End of switch
            } catch (NumberFormatException e) {
                System.out.println("Please follow the numbers within the menu.");
            }
        }
    }//End of makeSchoolControlMenu

    private void makeStudentControl()
    {
        boolean keepAliveControl = true;
        while(keepAliveControl) {
            try {
                System.out.println("-----Students-----");
                System.out.println("1. Make a Student");
                System.out.println("2. Remove a Student");
                System.out.println("3. Edit a Student");
                System.out.println("4. Find a Student by ID");
                System.out.println("5. Find a Student by Name");
                System.out.println("6. Find a Student by Email");
                System.out.println("7. Show all Students");
                System.out.println("8. SchoolControl Menu");
                System.out.println("-----------------------");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        makeAddStudent();
                        break;
                    case 2:
                        List<Student> student = studentslist.findAll();
                        student.forEach(System.out::println);
                        System.out.println("Remove a student by writing the ID: ");
                        int userEnter = Integer.parseInt(scanner.nextLine());
                        Student remove = studentslist.findById(userEnter);
                        studentslist.deleteStudent(remove);
                        System.out.println("You removed the Student with the ID: " + userEnter);
                        break;
                    case 3:
                        makeEditStudent();
                        break;
                    case 4:
                        System.out.println("Write the id you wanna find: ");
                        System.out.println("The information of the following ID is: " + studentslist.findById(Integer.parseInt(scanner.nextLine())));
                        break;
                    case 5:
                        System.out.println("Write the name you wanna search for: ");
                        String name = scanner.nextLine();
                        System.out.println("You found these names: \n" + studentslist.findByName(name));
                        break;
                    case 6:
                        System.out.println("Write the email you wanna search for: ");
                        String email = scanner.nextLine();
                        System.out.println("You found these emails: \n" + studentslist.findByEmail(email));
                        break;
                    case 7:
                        List<Student> students = studentslist.findAll().stream().filter(p -> p.getId() < 50).collect(Collectors.toList());
                        students.forEach(System.out::println);//Can only print 50 students/IDs
                        break;
                    case 8:
                        keepAliveControl = false;
                        break;
                    default:
                        System.out.println("Make a choice within the menu.");
                        break;
                }//End of switch
            } catch (NumberFormatException e) {
                System.out.println("Please follow the numbers within the menu.");
            }
        }
    }//End of makeStudentControl

    private void makeCourseControl()
    {
        boolean courseControl = true;
        while(courseControl)
        {
            try{
            System.out.println("-----Courses-----");
            System.out.println("1. Make a new Course");
            System.out.println("2. Add a Student to a Course");
            System.out.println("3. Remove a Student from a Course");
            System.out.println("4. Edit a Course");
            System.out.println("5. Find a Course by ID");
            System.out.println("6. Find a Course by Name");
            System.out.println("7. Find a Course by Date");
            System.out.println("8. Show all Courses");
            System.out.println("9. Remove a Course");
            System.out.println("10. SchoolControl Menu");
            System.out.println("-----------------------");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        makeCourse();
                        break;
                    case 2:
                        registerStudentToCourse();
                        break;
                    case 3:
                        removeStudentFromCourse();
                        break;
                    case 4:
                        makeEditCourse();
                        break;
                    case 5:
                        System.out.println("Write the id you wanna find: ");
                        System.out.println("The information of the following ID is: " + courselist.findById(Integer.parseInt(scanner.nextLine())));
                        break;
                    case 6:
                        System.out.println("Write the name you wanna search for: ");
                        String name = scanner.nextLine();
                        System.out.println("You found these names: \n" + courselist.findByName(name));
                        break;
                    case 7:
                            System.out.println("Find a Course by typing in the date: \n(Example: 2019-10-10)");
                            String date = scanner.nextLine();
                            System.out.println("You found these courses with the date: " + date + "\n");
                            courselist.findAll().forEach(System.out::println);
                        break;
                    case 8:
                        courselist.findAll().forEach(System.out::println);
                        break;
                    case 9:
                        List<Course> course = courselist.findAll();
                        course.forEach(System.out::println);
                        System.out.println("Remove a Course by writing the ID: ");
                        int userEnter = Integer.parseInt(scanner.nextLine());
                        Course remove = courselist.findById(userEnter);
                        courselist.removeCourse(remove);
                        System.out.println("You removed the Course with the ID: " + userEnter);
                        break;
                    case 10:
                        courseControl = false;
                        break;
                    default:
                        System.out.println("Make a choice within the menu.");
                        break;
                }//End of switch
            }catch(NumberFormatException e){
                System.out.println("Please follow the numbers within the menu.");
            }
        }//End of while
    }//End of makeStudentControl


    //ShowStudentsAndCourses
    private void makeShowStudentsAndCourses()
    {
        System.out.println("All students: "+studentslist.findAll()+"\nAll courses: "+courselist.findAll());
    }

    public Course makeEditCourse()
    {
        int id = -1;
        courselist.findAll().forEach(System.out::println);
        System.out.println("Please write the ID of the Course you wanna edit");
        id = Integer.parseInt(scanner.nextLine());
        Course course = courselist.findById(id);
        System.out.println("You are editing Course: "+id+"\nWhat do you wanna edit: \n1. Name\n2. StartDate \n3. WeekDuration ");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                System.out.println("Write the Name you wanna change to: ");
                course.setCourseName(scanner.nextLine());
                break;
            case 2:
                boolean alive = true;
                while(alive){
                try {
                    System.out.println("Write the StartDate you wanna change to: (2019-10-04)");
                    course.setStartDate(LocalDate.parse(scanner.nextLine()));
                    alive = false;
                }catch(DateTimeParseException e) {
                    System.out.println("You need to follow the example (Year/Month/Day)");
                }
            }
                break;
            case 3:
                System.out.println("Write the WeekDuration you wanna change to: ");
                course.setWeekDuration(Integer.parseInt(scanner.nextLine()));
                break;
            default:
                System.out.println("Error");

        }
        System.out.println("You edited the Course with the ID: " + id);
        return course;
    }

    //Students
    private Student makeAddStudent()
    {

        Student student = new Student(makeUserName(), makeUserEmail(), makeUserAdress());
        student = studentslist.saveStudent(student);
        System.out.println("You created a Student:\nID: "+student.getId()+"\nName: "+student.getName()+"\nEmail: "+student.getEmail()+"\nAdress: "+student.getAddress());
        return student;
    }

    private static String makeUserName()
    {
        System.out.println("Enter your Name: ");
        return scanner.nextLine();
    }

    private static String makeUserEmail()
    {
        System.out.println("Enter your Email: ");
        System.out.println("Your email must contain any of hotmail/gmail/outlook as well as at least five letters");
        int number = 5;
        String email = null;
        boolean keepAlive = true;
        while (keepAlive) {
            email = scanner.nextLine();
            if (email.contains("@") && email.length() > number && email.contains(".")) {
                System.out.println("Email created");
                keepAlive = false;
            } else {
                System.out.println("Please write a valid Email!");
                keepAlive = true;
            }
        }
        return email;
    }

    private static String makeUserAdress()
    {
        System.out.println("Enter your Adress: ");
        return scanner.nextLine();
    }

    public Student makeEditStudent()
    {
        int id = -1;
        studentslist.findAll().forEach(System.out::println);
        System.out.println("Please write the ID of the Student you wanna edit");
        id = Integer.parseInt(scanner.nextLine());
        Student student = studentslist.findById(id);
        System.out.println("You are editing Student: "+id+"\nWhat do you wanna edit: \n1. Name\n2. Email \n3. Adress ");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    System.out.println("Write the Name you wanna change to: ");
                    student.setName(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Write the Email you wanna change to: ");
                    student.setEmail(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Write the Adress you wanna change to: ");
                    student.setAddress(scanner.nextLine());
                    break;
                default:
                    System.out.println("Error");

            }
            System.out.println("You edited the Student with the ID: " + id);
            return student;
    }



    //Courses
    private Course makeCourse()
    {
        Course course = new Course(makeCourseName(), makeCourseDate(), makeCourseWeekDuration());
        course = courselist.saveCourse(course);
        System.out.println("You created a Course:\nID: "+course.getId()+"\nName: "+course.getCourseName()+"\nStartDate: "
                +course.getdate()+"\nWeekDuration: "+course.getWeekDuration());
        return course;
    }

    private static String makeCourseName()
    {
        System.out.println("Enter the Name of the Course: ");
        return scanner.nextLine();
    }

    private static LocalDate makeCourseDate()
    {
        LocalDate date = null;
        boolean noDate = true;

        while (noDate) {
            try {
                System.out.println("Enter the date on the day you starting the course: \nExample: Year-Month-Day (2019-10-04)");
                date = LocalDate.parse(scanner.nextLine());
                noDate = false;
            } catch (DateTimeParseException e) {
                System.out.println("Please follow the example above, thanks!");
            }
        }
        return date;
    }

    private static int makeCourseWeekDuration()
    {
        int number = -1;
        boolean alive = true;
        while(alive) {
            try {
                System.out.println("Enter the WeekDuration: ");
                number = Integer.parseInt(scanner.nextLine());
                alive = false;
            } catch (NumberFormatException e) {
                System.out.println("Please write a valid number: ");
            }
        }
        return number;
    }

    //Register a student to the course
    public List<Course> registerStudentToCourse()
    {
        int courseNumber = -1;
        int studentNumber = -1;
        courselist.findAll().forEach(System.out::println);
        System.out.println("Please enter the ID of the Course: ");
        courseNumber = Integer.parseInt(scanner.nextLine());
        studentslist.findAll().forEach(System.out::println);
        System.out.println("Please enter the ID of the Student that you wanna add: ");
        studentNumber=Integer.parseInt(scanner.nextLine());
        courselist.findById(courseNumber).register(studentslist.findById(studentNumber));
        System.out.println("The student: "+studentslist.findById(studentNumber)+"has joined the course"+courselist.findById(courseNumber));
        return courselist.findAll();
    }

    //Remove a student from the course
    public List<Course> removeStudentFromCourse()
    {
        int courseNumber = -1;
        int studentNumber = -1;
        courselist.findAll().forEach(System.out::println);
        System.out.println("Please enter the ID of the Course: ");
        courseNumber=Integer.parseInt(scanner.nextLine());
        studentslist.findAll().forEach(System.out::println);
        System.out.println("Please enter the ID of the Student that u wanna remove: ");
        studentNumber=Integer.parseInt(scanner.nextLine());
        courselist.findById(courseNumber).unregister(studentslist.findById(studentNumber));
        System.out.println("The student: "+studentslist.findById(studentNumber)+"has been removed from the course"+courselist.findById(courseNumber));
        return courselist.findAll();
    }
}//End of ClassSchoolControl