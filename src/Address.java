
import java.io.Serializable;
public class Address implements Serializable
{

    private String home;
    private String street;
    private String city;

    public Address()
    {
        // Default - Constructor
    }

    public Address(String h, String s, String c)        // Argument - Constructor
    {
        home = h;
        street = s;
        city = c;
    }

    public void setHome(String h)
    {
        home = h;
    }
    public void setStreet(String s)
    {
        street = s;
    }
    public void setCity(String c)
    {
        city = c;
    }

    public String getHome()
    {
        return home;
    }
    public String getStreet()
    {
        return street;
    }
    public String getCity()
    {
        return city;
    }

    public String toString()
    {
        return "Address{" +
                "home='" + home + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}