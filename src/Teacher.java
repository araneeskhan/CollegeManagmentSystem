import java.io.Serializable;

public class Teacher  extends Person implements Payable,Serializable {
    private String degree;
    private String teaching_experience;
    private Login login;

    // D_Constructor
    public Teacher()
    {
        super();
        login = new Login();
    }

    // A_Constructor
    public Teacher(String name, String age, String clg_Id, Address address,
                   Date date_of_birth,String degree, String teaching_experience,Login l) {

        super(name,age,clg_Id,address,date_of_birth);
        this.degree = degree;
        this.teaching_experience = teaching_experience;
        this.login =l;
    }

    //  Setters and Getters
    public void setDegree(String degree)
    {
        this.degree = degree;
    }

    public void setTeaching_experience(String teaching_experience)
    {

        this.teaching_experience = teaching_experience;
    }

    public String getDegree()
    {
        return degree;
    }

    public String getTeaching_experience()
    {
        return teaching_experience;
    }

    // Overridden method  for calculating Teacher Salary
    public double getAmount()
    {
        double salary = 100000;
        int x = 0;

        double fine = 500;

        if(x > 10)   //absents are more than 10
        {
            x = x - 10;                                      // we store xtra leaves in variable x than allowed
            salary = salary - (x * fine);
            return salary;
        }
        return salary;
    }


    // To String
    public String toString() {

        return "Teacher{" +
                super.toString()+ '\''+
                "degree='" + degree + '\''  +
                ", teaching_experience='" + teaching_experience + "Login" +login.toString() +'\''+
                '}' + "\nStudents: " +"\n"+ "Salary: " + getAmount();
    }


}
