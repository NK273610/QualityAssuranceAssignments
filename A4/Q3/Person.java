public class Person {

    public String name;
    public Address address;

    public Person()
    {
        name = "Rob";
        address=new Address("Rob street", "Rob city", "Rob province", "Rob postalcode");
        //constructor created for address class
    }

    public boolean IsPersonRob()
    {
        return name.equals("Rob") && IsRobsAddress(address);
    }

    private boolean IsRobsAddress(Address adr)
    {
        return adr.street.equals("Rob street") &&
                adr.city.equals("Rob city") &&
                adr.province.equals("Rob province") &&
                adr.postalCode.equals("Rob postalcode");
    }
}