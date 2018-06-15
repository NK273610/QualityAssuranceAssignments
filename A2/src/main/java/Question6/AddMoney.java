package Question6;

public class AddMoney {

    int numPennies;
    int numDimes;
    int numNickels;
    int numQuarters;

  public AddMoney(LoadMoney loadMoney)
   {
       this.numPennies=loadMoney.numPennies;
       this.numDimes=loadMoney.numDimes;
       this.numNickels=loadMoney.numNickels;
       this.numQuarters=loadMoney.numQuarters;
   }

    public void AddPenny()
    {
        numPennies += 1;
    }

    public void AddDime()
    {
        numDimes += 1;
    }

    public void AddNickel()
    {
        numNickels += 1;
    }

    public void AddQuarter()
    {
        numQuarters += 1;
    }

}
