import java.io.Serializable;
public abstract class Person implements Serializable
{
    // Data Member
    private String name;
    private String age;
    private String clg_Id;

    // Composition
    private Address address;
    private Date date_of_birth;

    //D_Constructor
    public Person()
    {
        address = new Address();
        date_of_birth = new Date();
    }

    //A_Constructor
    public Person(String name, String age, String clg_Id, Address address,
                  Date date_of_birth)
    {
        this.name = name;
        this.age = age;
        this.clg_Id = clg_Id;
        this.address = address;
        this.date_of_birth = date_of_birth;
    }

    //    Setters and Getters
    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public void setClg_Id(String clg_Id)
    {
        this.clg_Id = clg_Id;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Address getAddress(){
        return address;
    }

    public void setDate_of_birth(Date date_of_birth)
    {
        this.date_of_birth = date_of_birth;
    }
    public Date getDate_of_birth(){
        return date_of_birth;
    }

    public String getName()
    {
        return name;
    }

    public String getClg_Id() {
        return clg_Id;
    }

    public String getAge(){
        return age;
    }

    // To string
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", clg_Id='" + clg_Id + '\'' +
                ", address=" + address.toString()+
                ", date_of_birth=" + date_of_birth.toString() +
                '}';
    }
}
