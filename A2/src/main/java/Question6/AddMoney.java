package Question6;

public class AddMoney {

    int numPennies;
    int numDimes;
    int numNickels;
    int numQuarters;

   public AddMoney(int numPennies,int numDimes,int numNickels,int numQuarters)
   {
       this.numPennies=numPennies;
       this.numDimes=numDimes;
       this.numNickels=numNickels;
       this.numQuarters=numQuarters;
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
