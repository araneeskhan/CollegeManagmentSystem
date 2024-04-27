
import java.io.Serializable;
public  class Department implements Serializable
{

    // Data Members
    private String dep_name;


    // D_Constructor
    public Department()
    {
    }

    // A_Constructor
    public Department(String dep_name)
    {
        this.dep_name = dep_name;

    }

    // Setters and getters

    public void setDep_name(String dep_name)
    {
        this.dep_name = dep_name;
    }

    public String getDep_name()
    {
        return dep_name;
    }


    // to String
    public String toString()
    {
        return
                " \n department name: " + dep_name ;
    }
}
