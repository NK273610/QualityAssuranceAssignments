package Question1.javaClass;

import Question1.Interface.Payable;

public class SalaryWorker implements Payable {

    private float salary;
    private int hoursPerWeek;

    public SalaryWorker()
    {
        salary = 50000.0f;
        hoursPerWeek = 40;
    }

    public float calculatePay(int hours)
    {
        float hourlyRate = salary / (52 * hoursPerWeek);
        return hourlyRate * hours;
    }
}
