
import java.util.Arrays;
import java.io.Serializable;
public class Course implements Serializable
{
    // Data Member
    private String course_Name;


    // D_Constructor
    public Course()
    {
    }

    // A_Constructor
    public Course(String course_Name)
    {
        this.course_Name = course_Name;
    }

    //  Setters and Getters
    public void setCourse_Name(String course_Name)
    {
        this.course_Name = course_Name;
    }

    public String getCourse_Name()
    {
        return course_Name;
    }


    @Override
    public String toString() {
        return "Course{" +
                "course_Name='" + course_Name +'}';
    }
}
