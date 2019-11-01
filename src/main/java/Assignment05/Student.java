package Assignment05;


import java.util.Objects;

public class Student
{
    //Fields
    private int id;
    private String name;
    private String email;
    private String address;


    //Constructor
    public Student(int id, String name, String email, String address) {
        this(name,email,address);
        this.id = id;
    }

    public Student(String name, String email, String address) {
        setName(name);
        setEmail(email);
        setAddress(address);
    }


    //Getters
    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getAddress()
    {
        return address;
    }

    //Setters
    public void setName(String name)//For testing
    {
        this.name = name;
    }

    public void setEmail(String email)//For testing
    {
        this.email = email;
    }

    public void setAddress(String address)//For testing
    {
        this.address = address;
    }

    //Override toString
    @Override
    public String toString()
    {
        return "\nStudents: " +
                " Id: " + id + "|"+
                " Name: " + name+
                " Email: " + email+
                " Address: " + address+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(email, student.email) &&
                Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, address);
    }
}//End of Class
