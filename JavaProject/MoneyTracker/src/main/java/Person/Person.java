package Person;

public class Person
{
    private String fullName;

    public Person(String fullName)
    {
        this.fullName = fullName;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void changeFullName(String newfullName) {this.fullName = newfullName;}
}