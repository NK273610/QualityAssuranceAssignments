package Question6;

import java.io.PrintWriter;

public class PiggyBank {

    int numPennies;
    int numDimes;
    int numNickels;
    int numQuarters;

    public PiggyBank(AddMoney addMoney)
    {
        numPennies = addMoney.numPennies;
        numDimes = addMoney.numDimes;
        numNickels = addMoney.numNickels;
        numQuarters = addMoney.numQuarters;
    }

    public void Save()
    {
        try
        {
            PrintWriter writer = new PrintWriter("piggybank.txt", "UTF-8");
            writer.println(Integer.toString(numPennies));
            writer.println(Integer.toString(numDimes));
            writer.println(Integer.toString(numNickels));
            writer.println(Integer.toString(numQuarters));
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println("I am a bad programmer that hid an exception.");
        }
    }
}
