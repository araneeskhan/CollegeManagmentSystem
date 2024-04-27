import java.util.Arrays;
import java.io.Serializable;
public class Student extends Person implements Payable,Serializable {

    // Additional Data Members
// Previous details of s student
    private String father_Name;
    private double matric_Marks;
    private String  prev_Edu_Background;
    private String current_Class;
    private Login login;


    // Composition
    private Department d;
    public  Course [] c = new Course[3];

    //D_Constructor
    public Student()
    {
        super();

        //To avoid Null pointer exception
        d = new Department();
        login = new Login();


    }

    //A_Constructor
    public Student(String name, String age, String clg_Id, Address address,
                   Date date_of_birth,String father_Name, double matric_Marks,
                   String prev_Edu_Background, String current_Class, Department d,
                   Login l )
    {
        super(name,age,clg_Id,address,date_of_birth);
        this.father_Name = father_Name;
        this.matric_Marks = matric_Marks;
        this.prev_Edu_Background = prev_Edu_Background;
        this.current_Class = current_Class;
        this.d = d;
        this.login = l;

    }

    //    Setters and Getters
    public void setFather_Name(String father_Name)
    {
        this.father_Name = father_Name;
    }

    public void setMatric_Marks(double matric_Marks)
    {
        this.matric_Marks = matric_Marks;
    }

    public void setPrev_Edu_Background(String prev_Edu_Background)
    {
        this.prev_Edu_Background = prev_Edu_Background;
    }

    public void setCurrent_Class(String current_Class)
    {
        this.current_Class = current_Class;
    }

    public void setD(Department d)
    {
        this.d = d;
    }

    public String getFather_Name()
    {
        return father_Name;
    }

    public double getMatric_Marks()
    {
        return matric_Marks;
    }

    public String getPrev_Edu_Background()
    {
        return prev_Edu_Background;
    }

    public String getCurrent_Class()
    {
        return current_Class;
    }

    public Department getD()
    {
        return d;
    }

    public Login getLogin(){
        return login;
    }

    public void setCourse(Course[] p){
        c = p;
    }
    public Course[] getCourse(){
        return c;
    }

    // Method to allocate courses
    public void allocate_Courses()
    {
        if(d.getDep_name().equalsIgnoreCase("ICS"))
        {
            c[0] = new Course("Computer");
            c[1] = new Course("Statistics");
            c[2] = new Course("Maths");
        }

        else if (d.getDep_name().equalsIgnoreCase("Pre_Medical"))
        {
            c[0] = new Course("Biology");
            c[1] = new Course("Physics");
            c[2] = new Course("Chemistry");
        }
        else
        if(d.getDep_name().equalsIgnoreCase("Pre_Engineering"))
        {
            c[0] = new Course("Maths");
            c[1] = new Course("Physics");
            c[2] = new Course("Chemistry");
        }

        int counterMedical = 0;
        int counterEnginering = 0;
        int counterICS = 0;

        for (int i = 0; i < getCourse().length; i++){
            if (d.getDep_name().equalsIgnoreCase("Pre_Medical")){
                counterMedical ++;
            }
            else if (d.getDep_name().equalsIgnoreCase("Pre_Engineering") ){
                counterEnginering ++;
            }
            else
                counterICS ++;
        }
    }

    // Overridden method  for calculating student fee
    public double getAmount() {

        double fee = 12000; //per month

        // but for the scholarship student
        if(matric_Marks >=1000)
        {
            fee = fee-6000;
            return fee;

        }
        return fee;
    }


    // To string
    public String toString()
    {
        return "Student{"  +
                super.toString()+ '\''+
                "father_Name='" + father_Name + '\'' +
                ", matric_Marks='" + matric_Marks + '\'' +
                ", prev_Edu_Background='" + prev_Edu_Background + '\'' +
                ", current_Class='" + current_Class + '\'' +
                ", department=" + d.toString() + "Login: " + login.toString()+
                ", attendance=" +
                ", Courses: "+Arrays.toString(c)+ "Fee =" + getAmount()  + '\'' +
                '}';
    }
}
