package Question1.javaClass;

import Question1.Interface.Payable;

import java.util.ArrayList;

public class Employer {

    ArrayList<Payable> Payables;

    public Employer(Payable[] payables,Integer[] num)
    {
        Payables = new ArrayList<Payable>();

        for (int i = 0; i < num.length; i++)
        {
            for (int k=0;k<num[i];k++)
            {
            Payables.add(payables[i]);

            }
        }
    }

    public void outputWageCostsForAllStaff(int hours)
    {
        float cost = 0.0f;
        for (int i = 0; i < Payables.size(); i++)
        {
            Payable payable = Payables.get(i);
            cost += payable.calculatePay(hours);
        }

        System.out.println("Total wage cost for all staff = $" + cost);
    }
}
