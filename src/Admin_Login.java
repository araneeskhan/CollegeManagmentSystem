

import java.io.Serializable;
public class Admin_Login implements Serializable
{
    //Data_Member
    Login a;

    // D_Constructor
    public Admin_Login()
    {
        a = new Login();
    }

    // A_Constructor
    public Admin_Login(Login a)
    {
        this.a = a;
    }

    //  Setters and Getters
    public void setA(Login a)
    {
        this.a = a;
    }

    public Login getA()
    {
        return a;
    }

    // To String
    public String toString()
    {
        return "Student_Login{" +
                a.toString() +
                '}';
    }
}
