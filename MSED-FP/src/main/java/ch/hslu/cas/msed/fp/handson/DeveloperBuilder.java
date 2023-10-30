package ch.hslu.cas.msed.fp.handson;

public class DeveloperBuilder
{
    private String Firstname;
    private String Lastname;
    private String Email;

    public DeveloperBuilder()
    {

    }

    public DeveloperBuilder FirstName(String name)
    {
        this.Firstname = name;
        return this;
    }

    public DeveloperBuilder LastName(String name)
    {
        this.Lastname = name;
        return this;
    }

    public DeveloperBuilder Email(String email)
    {
        this.Email = email;
        return this;
    }

    public Developer build()
    {
        if(this.Firstname != null && this.Lastname != null && this.Email != null)
        {
            return new Developer(this.Firstname, this.Lastname, this.Email);
        }
        else
        {
            // Improve: Throw Exception
            return new Developer("", "", "");
        }
    }

}