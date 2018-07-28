public class Person
{
    private String name;
    private LoginDetails loginDetails;
    private String areaCode;
    private String phoneNumber;

    public Person(String name)
    {
        this.name = name;
    }

    public void SetAreaCode(String areaCode)
    {
        this.areaCode=areaCode;
    }
    public String GetAreaCode()
    {
        return this.areaCode;
    }
    public void SetPhoneNumber(String phoneNumber)
    {
        this.phoneNumber=phoneNumber;
    }
    public String GetPhoneNumber()
    {
        if (areaCode != null && areaCode != "")
        {
            return "(" + areaCode + ") " + phoneNumber;
        }
        return phoneNumber;
    }

    public void SetLoginCredentials(String userName, String password)
    {
        loginDetails=new LoginDetails(userName, password);
    }
    public boolean AuthenticateUser()
    {
        return loginDetails.AuthenticateUser();
    }
}