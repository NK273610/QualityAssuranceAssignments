package Question1.javaClass;

import Question1.Interface.Payable;

public class HourlyWorker implements Payable {

    private float hourlyRate;

    public HourlyWorker()
    {
        hourlyRate = 10.0f;
    }

    public float calculatePay(int hours)
    {
        return hourlyRate * hours;
    }
}
