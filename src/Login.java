import java.io.Serializable;
public class Login implements Serializable
{
    // Data Members
    private String user_Name;
    private String password;

    // D_C
    public Login()
    {
    }

    // A_C
    public Login(String user_Name, String password)
    {
        this.user_Name = user_Name;
        this.password = password;
    }


    // To String
    public String toString()
    {
        return "Login{" +
                "user_Name='" + user_Name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

